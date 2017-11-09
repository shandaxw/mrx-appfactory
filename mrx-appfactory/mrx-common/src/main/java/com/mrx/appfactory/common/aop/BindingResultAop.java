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

/**
 * 
 * @Type BindingResultAop.java
 * @Desc 
 * @author xuwen
 * @date 2017年11月8日 下午3:57:28
 * @version
 */
@Aspect
@Component
public class BindingResultAop {

    /**
     * 〈一句话功能简述〉参数验证aop，生成提示信息
     * 〈功能详细描述〉
     *
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
                throw new APIException(APIResults.PARAM_INVALID);
            }
        }
        return joinPoint.proceed();
    }

}
