package onboarding;

public class Problem2 {
    public static String removeDup(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        int k = 0;
        int i = 0;
        for(i = 1; i < chars.length; i++) {
            if(chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
            } else {
                while(i < chars.length - 1 && chars[i - 1] == chars[i]) {
                    i++;
                }
            }
        }
        if(chars[i - 1] != chars[i - 2]) {
            chars[k++] = chars[i - 1];
        }

        String result = new String(chars).substring(0, k);

        return result;
    }

    public static String decodeCryptogram(String cryptogram) {
        while (true) {
            String tmp = removeDup(cryptogram);

            if(cryptogram.length() == tmp.length()) {
                break;
            }

            cryptogram = tmp;
        }
        String result = cryptogram;

        return result;
    }

    public static String solution(String cryptogram) {
        String answer = decodeCryptogram(cryptogram);

        return answer;
    }
}
