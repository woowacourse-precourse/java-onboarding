package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        char[] ch = cryptogram.toCharArray();

        if (cryptogram == null || cryptogram.length() == 0 || ch[0] == ch[1]) {
            return "";
        }


        int i, k = 0;

        for (i = 1; i < ch.length; i++) {
            if (ch[i - 1] != ch[i]) {
                ch[k++] = ch[i - 1];
            }else {

                while (i < ch.length && ch[i - 1] == ch[i]) {
                    i++;
                }
            }
        }

        ch[k++] = ch[i - 1];

        String answer = new String(ch).substring(0, k);

        if (k != ch.length) {
            return solution(answer);
        }

        return answer;

    }
}
