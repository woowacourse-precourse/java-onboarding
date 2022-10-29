package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String errorMessage = null;

        if ((errorMessage = verifyException(cryptogram)) != null) {
            return errorMessage;
        }
        return decodeCryptogram(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        String newAnswer = "";

        while(true) {
            newAnswer = removeDuplicate(cryptogram);
            if (newAnswer.equals(cryptogram))
                break;
            cryptogram = newAnswer;
        }
        return newAnswer;
    }

    private static String removeDuplicate(String cryptogram) {
        int endIndex;
        String result = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            char target = cryptogram.charAt(i);

            if ((endIndex = findDuplicateIndex(cryptogram, i + 1, target)) != i) {
                i += (endIndex - i);
            } else {
                result += Character.toString(target);
            }
        }
        return result;
    }

    private static int findDuplicateIndex(String cryptogram, int endIndex, char c) {
        while (endIndex < cryptogram.length() && c == cryptogram.charAt(endIndex)) {
            endIndex++;
        }
        return endIndex - 1;
    }

    private static String verifyException(String cryptogram) {
        String result = null;

        /* [TODO] 에러 메세지 enum으로 ..? 어떻게 변경할지 고려해보자 */
        if (cryptogram == null) {
            result = "Error: Don't allow null string";
            return result;
        }
        if (!isLowerCase(cryptogram))
            result = "Error: Must be lowercase";
        if (result == null && !checkLength(cryptogram)) {
            result = "Error: Length 1 to 1000";
        } else if (!checkLength(cryptogram))
            result = "Error: Length 1 to 1000 and Must be lowercase";
        return result;
    }

    private static boolean isLowerCase(String cryptogram) {
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLength(String cryptogram) {
        return (cryptogram.length() >= 1 && cryptogram.length() <= 1000);
    }
}