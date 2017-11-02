package com.mrx.appfactory.common.util;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author xuwen
 *
 */
public abstract class BaseTokenManager{

    private static AtomicReference<String> TOKEN = new AtomicReference<String>(null);
    
    private static AtomicReference<Date> EXPIRE_TIME = new AtomicReference<Date>(null);
    
    public static AtomicReference<Date> REFRESH_TIME = new AtomicReference<Date>(null);
    
    private final static long MIN_REFRESH_TIME = 1000;
    
    public String getToken() throws Exception{
        if(TOKEN == null || TOKEN.get() == null || isExpire()){
            synchronized (this) {
                if(TOKEN == null || TOKEN.get() == null || isExpire()){
                    getNewToken();
                }
            }
        }
        return TOKEN.get();
    }
    
    public String getNewTokenByForce() throws Exception{
        Date lastRefreshTime = REFRESH_TIME.get();
        Date current = new Date();
        if(isExpire() || lastRefreshTime==null || current.getTime() - lastRefreshTime.getTime() > MIN_REFRESH_TIME){
            synchronized (this) {
                if(isExpire() || lastRefreshTime==null || current.getTime() - lastRefreshTime.getTime() > MIN_REFRESH_TIME){
                    getNewToken();
                }
            }
        }
        return TOKEN.get();
    }
    
    protected Date getExpireTime(){
        return EXPIRE_TIME.get();
    }
    
    protected void updateToken(String token, Date expireTime) {
        if (EXPIRE_TIME == null || EXPIRE_TIME.get() == null
                || EXPIRE_TIME.get().getTime() < expireTime.getTime()) {
            synchronized (this) {
                if (EXPIRE_TIME == null || EXPIRE_TIME.get() == null
                        || EXPIRE_TIME.get().getTime() < expireTime.getTime()) {
                    TOKEN.set(token);
                    EXPIRE_TIME.set(expireTime);
                    REFRESH_TIME.set(new Date());
                }
            }
        }

    }
    
    public boolean isExpire() {
        return this.getExpireTime() == null || this.getExpireTime().getTime() <= new Date().getTime();
    }
    
    protected abstract void getNewToken() throws Exception;
}


