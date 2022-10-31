package onboarding;

public class Problem4 {
    public static String solution(String word) {
        /**
         * a = 97 z = 122, A=65 Z=90 대문자 -> 소문자 + 32
         *              대문자 기준
         * 0  1  2  3  4  5  ... i = 현재 문자 - 65
         * 65 66 67 68 69 70 ... A B C D E F ...
         * 90 89 88 87 86 85 ... Z Y X W V U ...
         * 25 23 21 19 17 15 ... 25-(i*2) --> 더해준다.
         * Z = 90, i = 25, 65에 0을 더해준다. --> A
         * @param word
         * @return
         */
        int l = word.length();
        String res = "";
        for (int j = 0; j < l; j++) {
            char c = word.charAt(j);
            int n = (int) c;
            if (65 <= n && n <= 90) {
                int i = n - 65;
                System.out.println(((char) i));
                n = (65+i) + (25-(i * 2));
                c = (char) n;
            } else if (97 <= n && n <= 122) {
                int i = n - 97;
                n = (97+i) + (25-(i * 2));
                c = (char) n;
            }
            res += c;
        }
        return res;
    }
}
