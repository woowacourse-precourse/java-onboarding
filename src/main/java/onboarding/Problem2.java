package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder crypt = new StringBuilder(cryptogram);
        while (true) {
            boolean dup = false;
            for (int i = 0; i < crypt.length(); ++i) {
                int tmp = 1;
                while (i + tmp < crypt.length() && crypt.charAt(i) == crypt.charAt(i + tmp))
                    tmp++;
                if (tmp > 1) {
                    dup = true;
                    for (int j = 1; j <= tmp; ++j)
                        crypt.deleteCharAt(i);
                }
            }
            if (!dup)
                break;
        }
        String answer = crypt.toString();

        return answer;
    }
}
