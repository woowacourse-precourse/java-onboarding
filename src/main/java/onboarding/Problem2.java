package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeLetter(cryptogram);
    }


    private static int isOverlap(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    private static String removeLetter(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = isOverlap(cryptogram);

        if (index == -1) {
            return cryptogram;
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (index == i) {
                i++;
            } else if (index != i) {
                stringBuilder.append(cryptogram.charAt(i));
            }
        }
        return removeLetter(String.valueOf(stringBuilder));
    }
}
