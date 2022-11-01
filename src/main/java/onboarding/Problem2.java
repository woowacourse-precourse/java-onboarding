package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!verifyException(cryptogram)) {
            return "Error";
        }
        return decodeCryptogram(cryptogram);
    }

    private static boolean verifyException(String cryptogram) {
        return (cryptogram != null && checkLength(cryptogram) && isLowerCase(cryptogram));
    }

    private static boolean checkLength(String cryptogram) {
        return (cryptogram.length() >= 1 && cryptogram.length() <= 1000);
    }

    private static boolean isLowerCase(String cryptogram) {
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
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
        int endIndex = 0;
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
}