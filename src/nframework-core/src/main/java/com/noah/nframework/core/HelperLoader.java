package com.noah.nframework.core;

import com.noah.nframework.core.helper.BeanHelper;
import com.noah.nframework.core.helper.ControllerHelper;
import com.noah.nframework.core.helper.IocHelper;
import com.noah.nframework.core.util.ClassHelper;
import com.noah.nframework.core.util.ClassUtil;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 11:44
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classList) {
            ClassUtil.loadClass(clazz.getName(), true);
        }
    }
}
