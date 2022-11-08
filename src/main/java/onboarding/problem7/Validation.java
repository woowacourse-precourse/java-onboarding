package onboarding.problem7;

import java.util.List;

import static java.util.regex.Pattern.matches;

public class Validation {

    private static final String idRegex = "^([a-z]*)$";

    public static boolean isIdOutOfRange(List<String> idList) {
        boolean isOutOfRange = false;

        for (String id : idList) {
            isOutOfRange = isOutOfRange || id.length() < 1 || id.length() > 30;
        }

        return isOutOfRange;
    }

    public static boolean isListIndexOutOfRange(List<String> list) {
        return list.isEmpty() || list.size() > 10000;
    }

    public static boolean isInvalidId(List<String> idList) {
        boolean isInvalid = false;

        for (String id : idList) {
            isInvalid = isInvalid || !matches(idRegex, id);
        }

        return isInvalid;
    }
}
