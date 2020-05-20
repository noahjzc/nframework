package com.noah.nframework.core.util;


import org.apache.commons.lang3.StringUtils;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 13:28
 */
public final class CastUtil {
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj) {
        return castDouble(obj, 0);
    }


    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = 0;
        if (obj != null) {
            String stringValue = castString(obj);
            if (StringUtils.isNotEmpty(stringValue)) {
                try {
                    doubleValue = Double.parseDouble(stringValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj) {
        return castLong(obj, 0L);
    }

    public static long castLong(Object obj, long defaultValue) {
        long longValue = 0L;
        if (obj != null) {
            String stringValue = castString(obj);
            if (StringUtils.isNotEmpty(stringValue)) {
                try {
                    longValue = Long.parseLong(stringValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    public static int castInteger(Object obj) {
        return castInteger(obj, 0);
    }

    public static int castInteger(Object obj, int defaultValue) {
        int intValue = 0;
        if (obj != null) {
            String stringValue = castString(obj);
            if (StringUtils.isNotEmpty(stringValue)) {
                try {
                    intValue = Integer.parseInt(stringValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = false;
        if (obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }


}
