package com.mrx.appfactory.common.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.common.util.TimeUtil;

/**
 * 参数验证aop，生成提示信息
 * @author zhangtx
 *
 */
@Aspect
@Component
public class BindingResultAop {

    /**
     * BindingResult 转为 错误信息
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(public * com.mrx.appfactory..*.*Controller*.*(..))")
    public Object valid(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }
        }
        if (bindingResult != null) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            if (errors.size() > 0) {
                StringBuilder msg = new StringBuilder();
                FieldError error = errors.get(0);
                Class<?> fieldType = bindingResult.getFieldType(error.getField());
                if (TimeUtil.isTimeType(fieldType)) {
                    msg.append("时间格式错误");
                } else {
                    msg.append(error.getDefaultMessage());
                }

                throw new APIException(APIResults.PARAM_INVALID, msg.toString());
            }
        }
        return joinPoint.proceed();
    }

}
