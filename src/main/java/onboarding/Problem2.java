package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    public static String decrypt(String cryptogram) {
        String str = "";
        int length = cryptogram.length();
        Character recentCh = null;

        for (int i = 0; i < length; i++) {
            char ch = cryptogram.charAt(i);

            if (recentCh == null) {
                recentCh = ch;
                str += ch;
                continue;
            }

            if (recentCh == ch) {
                str = str.substring(0, str.length() - 1);
                continue;
            }

            if (recentCh != ch) {
                str += ch;
                recentCh = ch;
            }
        }

        if (length != str.length()) {
            return decrypt(str);
        }

        cryptogram = str;
        return cryptogram;
    }

}
