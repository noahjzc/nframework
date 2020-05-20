package com.noah.nframework.core.bean;

import com.noah.nframework.core.util.CastUtil;

import java.util.Map;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 13:26
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
