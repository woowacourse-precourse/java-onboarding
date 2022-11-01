package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    public static String decrypt(String cryptogram) {

        char[] chars = cryptogram.toCharArray();

        int k = 0;
        char prev = chars[k];

        int i = 1;
        int start = 0;

        while (i < chars.length) {
            if (prev != chars[i]) {
                chars[++k] = chars[i++];
                prev = chars[k];
            } else {
                while (i < chars.length && prev == chars[i]) {
                    i++;
                }
                if (k == 0) {
                    if (i == chars.length) {
                        return "";
                    }
                    k = i;
                    start = i;
                    i++;

                    prev = chars[k];
                } else {
                    prev = chars[--k];
                }
            }
        }
        return new String(chars).substring(start, k + 1);
    }
}
