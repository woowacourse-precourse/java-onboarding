package onboarding;

public class Problem2 {
    public static final int minLength = 1;
    public static final int maxLength = 1000;
    public static boolean haveDuplicated = false;

    public static String solution(String cryptogram) {
        if(cryptogram.length() < minLength || cryptogram.length() > maxLength) {
            throw new IllegalArgumentException("길이가 1이상 1000이하 문자열이어야합니다.");
        }
        for (char alphabet : cryptogram.toCharArray()) {
            if(!Character.isLowerCase(alphabet)) {
                throw new IllegalArgumentException("알파벳 소문자로만 이루어져야합니다.");
            }
        }
        do {
            haveDuplicated = false;
            cryptogram = decrypt(cryptogram);
        } while(haveDuplicated && cryptogram.length() > 0);
        return cryptogram;
    }

    private static String decrypt(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        char prev = stringBuilder.charAt(0);

        for (int i = 1; i < cryptogram.length(); i++) {
            char cur = cryptogram.charAt(i);
            if(prev == cur) {
                stringBuilder.setCharAt(i-1, '*');
                stringBuilder.setCharAt(i, '*');
                haveDuplicated = true;
            }
            prev = cur;
        }
        return stringBuilder.toString().replace("*", "");
    }
}
