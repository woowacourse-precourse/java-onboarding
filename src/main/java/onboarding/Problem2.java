package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);
        int before_len = 0;
        int count = 0;
        char now = 'X';
        char previous = 'S';

        while (true) {
            cryptogram = answer.toString();
            before_len = cryptogram.length();
            previous = 'S';
            answer = new StringBuilder();
            count = 0;
            for (int i = 0; i < before_len; i++) {
                now = cryptogram.charAt(i);
                if (previous == 'S') {
                    previous = now;
                    continue;
                }
                if (previous == now) {
                    count += 1;
                }
                else {
                    if (count == 0)  {
                        answer.append(previous);
                    }
                    if (i == before_len -1) {
                        answer.append(now);
                    }
                    previous = now;
                    count = 0;
                }
            }
            if ((answer.length() == before_len) || answer.length() == 0)
                break;
        }
        return answer.toString();
    }
}
