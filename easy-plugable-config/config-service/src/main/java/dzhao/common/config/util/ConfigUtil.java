package dzhao.common.config.util;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

public class ConfigUtil {
    static boolean DEFAULT_BOOLEAN = false;
    static byte DEFAULT_BYTE = 0;
    static short DEFAULT_SHORT = 0;
    static int DEFAULT_INT = 0;
    static long DEFAULT_LONG = 0L;
    static float DEFAULT_FLOAT = 0.0f;
    static double DEFAULT_DOUBLE = 0.0d;
    static double DEFAULT_CHAR = '\u0000';
    static String DEFAULT_STR = null;

    private ConfigUtil(){}

    public static String format(String value, String split){
        StringBuilder output = new StringBuilder();
        String[] tokens = StringUtils.splitByCharacterTypeCamelCase(value);
        for(String token : tokens){
            if(output.length() > 0){
                output.append(split);
            }
            output.append(token.toLowerCase().trim());
        }
        return output.toString();
    }

    public static Object getValue(AbstractConfiguration configuration, String key, Field field) {
        synchronized (configuration) {
            if (int.class.isAssignableFrom(field.getType())) {
                return configuration.getInt(key);
            } else if (boolean.class.isAssignableFrom(field.getType())) {
                return configuration.getBoolean(key);
            } else if (long.class.isAssignableFrom(field.getType())) {
                return configuration.getLong(key);
            } else if (short.class.isAssignableFrom(field.getType())) {
                return configuration.getShort(key);
            } else if (byte.class.isAssignableFrom(field.getType())) {
                return configuration.getByte(key);
            } else if (float.class.isAssignableFrom(field.getType())) {
                return configuration.getFloat(key);
            } else if (double.class.isAssignableFrom(field.getType())) {
                return configuration.getDouble(key);
            } else if (char.class.isAssignableFrom(field.getType())) {
                return configuration.getString(key).toCharArray()[0];
            } else if (String[].class.isAssignableFrom(field.getType())) {
                return configuration.getStringArray(key);
            } else if (String.class.isAssignableFrom(field.getType())) {
                return configuration.getString(key, null);
            } else if (Integer.class.isAssignableFrom(field.getType())) {
                return configuration.getInteger(key, Integer.valueOf(DEFAULT_INT));
            } else if (Long.class.isAssignableFrom(field.getType())) {
                return configuration.getLong(key, Long.valueOf(DEFAULT_LONG));
            } else if (Double.class.isAssignableFrom(field.getType())) {
                return configuration.getDouble(key, Double.valueOf(DEFAULT_DOUBLE));
            } else if (Float.class.isAssignableFrom(field.getType())) {
                return configuration.getFloat(key, Float.valueOf(DEFAULT_FLOAT));
            } else if (Boolean.class.isAssignableFrom(field.getType())) {
                return configuration.getBoolean(key, Boolean.valueOf(null));
            } else if (Byte.class.isAssignableFrom(field.getType())) {
                return configuration.getByte(key, Byte.valueOf(DEFAULT_BYTE));
            } else if (Short.class.isAssignableFrom(field.getType())) {
                return configuration.getShort(key, Short.valueOf(DEFAULT_SHORT));
            } else if (List.class.isAssignableFrom(field.getType())) {
                return configuration.getList(key, null);
            } else {
                throw new UnsupportedOperationException("not supported the value type");
            }
        }
    }
}
