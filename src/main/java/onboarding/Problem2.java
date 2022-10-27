package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean[] isDeleted = new boolean[cryptogram.length()];
        boolean isChanged = true;
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        while (isChanged) {
            isChanged = false;
            if (isShort(cryptogram)) {
                return cryptogram;
            }
            char previous = cryptogram.charAt(0);
            for (int i = 1; i < cryptogram.length(); i++) {
                char current = cryptogram.charAt(i);
                if (previous == current) {
                    isDeleted[i - 1] = true;
                    isDeleted[i] = true;
                    isChanged = true;
                }
                previous = current;
            }
            if (isChanged) {
                stringBuilder.delete(0, stringBuilder.length());
                for (int i = 0; i < cryptogram.length(); i++) {
                    if (!isDeleted[i]) {
                        stringBuilder.append(cryptogram.charAt(i));
                    }
                }
                cryptogram = stringBuilder.toString();
                isDeleted = new boolean[cryptogram.length()];
            }
        }
        return cryptogram;
    }

    private static boolean isShort(String cryptogram) {
        return cryptogram.length() == 1 || cryptogram.length() == 0;
    }
}
