package onboarding.problem2.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<String> convertStringToList(String string) {
        String[] strings = string.split("");
        List<String> stringList = new ArrayList<>();

        for (String str : strings) {
            stringList.add(str);
        }

        return stringList;
    }

    public static String convertStackToString(List<String> stack) {
        return String.join("", stack);
    }
}
