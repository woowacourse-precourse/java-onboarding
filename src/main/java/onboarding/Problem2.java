package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean[] isDeleted = new boolean[cryptogram.length()];
        boolean isChanged = true;
        StringBuilder sb = new StringBuilder(cryptogram);
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
                sb.delete(0, sb.length());
                for (int i = 0; i < cryptogram.length(); i++) {
                    if (!isDeleted[i]) {
                        sb.append(cryptogram.charAt(i));
                    }
                }
                cryptogram = sb.toString();
                isDeleted = new boolean[cryptogram.length()];
            }
        }
        return cryptogram;
    }

    private static boolean isShort(String cryptogram) {
        return cryptogram.length() == 1 || cryptogram.length() == 0;
    }
}
