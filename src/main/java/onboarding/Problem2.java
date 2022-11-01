package onboarding;

public class Problem2 {

    public static String deleteDup(String cryptogram) {
        String str = "";
        Character pre = null;

        for (int i = 0; i < cryptogram.length(); i++) {
            if (pre == null) {
                pre = cryptogram.charAt(i);
                str += cryptogram.charAt(i);
                continue;
            }

            if (pre == cryptogram.charAt(i)) {
                str = str.substring(0, str.length() - 1);
                continue;
            } else if (pre != cryptogram.charAt(i)) {
                str += cryptogram.charAt(i);
                pre = cryptogram.charAt(i);
            }
        }

        if (cryptogram.length() != str.length()) {
            return deleteDup(str);
        }

        cryptogram = str;
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = deleteDup(cryptogram);

        return answer;
    }
}
