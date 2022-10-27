package onboarding;

public class Problem2 {
    public static Integer findDuplicateIndex(String cryptogram) {
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
                return index;
            }
        }
        return -1;
    }

    public static String deleteDuplicateString(String cryptogram, Integer index) {
        cryptogram = cryptogram.substring(0, index) + cryptogram.substring(index + 2);
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer;

        while (true) {
            Integer duplicateIndex = findDuplicateIndex(cryptogram);
            if (duplicateIndex == -1) {
                break;
            }
            cryptogram = deleteDuplicateString(cryptogram, duplicateIndex);
        }
        answer = cryptogram;

        return answer;
    }
}
