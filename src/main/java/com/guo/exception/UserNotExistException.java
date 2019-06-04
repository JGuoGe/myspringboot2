package com.guo.exception;

/**
 * @author guo
 * @create 2019-05-21 14:15
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
