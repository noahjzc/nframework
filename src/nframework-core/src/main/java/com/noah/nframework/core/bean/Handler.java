package com.noah.nframework.core.bean;

import java.lang.reflect.Method;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 11:36
 */
public class Handler {
    private Class<?> controllerClass;
    private Method actionMethod;


    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
