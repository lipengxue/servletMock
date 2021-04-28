package utils;

import java.util.Arrays;

public class StringUtils {
    public static boolean idNull(String s){
        return s == null||"".equals(s);
    }

    public static boolean areNull(String... data){
        return Arrays.stream(data).anyMatch(StringUtils::idNull);
    }

}
