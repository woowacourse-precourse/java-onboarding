package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // digitClap: 1,10,100,1000,10000 이하 박수 횟수
        int[] digitClap = new int[5];

        digitClap[0] = 0;

        for (int i = 1; i < 5; ++i) {
            digitClap[i] = 10 * digitClap[i - 1] + 3 * (int) Math.pow(10, i - 1);
        }

        // digit: number의 각 자릿수
        int[] digit = new int[5];

        for (int i = 0; i < 5; ++i) {
            if (number == 0) {
                break;
            }
            digit[i] = number % 10;
            number /= 10;

            // num369: 0부터 digit[i]-1까지의 수 중 3,6,9의 개수
            int num369 = (digit[i] - 1) / 3;

            answer += digit[i] * digitClap[i] + num369 * (int) Math.pow(10, i);
            if (digit[i] % 3 == 0 && digit[i] != 0) {
                // 1의 자리수가 아닐 때
                if (i > 0) {
                    answer += digit[i - 1] + 1;
                }
                // 1의 자리수일 때
                else {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
