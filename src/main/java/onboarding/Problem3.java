package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int temp, clap = 0;
            int length = String.valueOf(i).length();

            while (length > 0) {
                if (length == 1)
                    temp = i % 10;
                else
                    temp = (int) (i / Math.pow(10, length - 1));
                if (temp == 3 || temp == 6 || temp == 9)
                    clap++;
                length--;
            }
            answer += clap;
        }
        return answer;
    }
}
