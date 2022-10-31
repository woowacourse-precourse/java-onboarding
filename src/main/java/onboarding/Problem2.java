package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        char prev = 0;
        int k = 0;

        for (char c: chars) {
            if (prev != c) {
                chars[k++] = c;
                prev = c;
            }
            else {
                chars[k--] = ' ';
                if (k-1 >=0)
                    prev = chars[k-1];
            }
        }
        return new String(chars).substring(0,k);
    }
}