package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        int len;

        do {
            char start = cryptogram.charAt(0);
            String tmp = "";
            int count = 1;

            len = cryptogram.length();
            for(int i = 1; i < len; i++) {
                char c = cryptogram.charAt(i);
                if(c != start) {
                    if(count == 1) tmp = tmp.concat(String.valueOf(start));
                    if(i == len - 1) tmp = tmp.concat(String.valueOf(cryptogram.charAt(i)));
                    start = c;
                    count = 1;
                }
                else count++;
            }
            cryptogram = tmp;
        } while (len > cryptogram.length() && cryptogram.length() > 1);

        answer = cryptogram;
        return answer;
    }
}
