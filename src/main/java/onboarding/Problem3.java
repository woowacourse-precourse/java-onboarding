package onboarding;

public class Problem3 {
    public static int solution(int number) {


        return calculate(number);
    }

    public static int calculate(int number) {

        int tmp = 0;
        int result = 0;

        while (tmp <= number) {

            //한 자리수
            if (tmp < 10) {
                if (tmp%10 == 3 || tmp%10 == 6 || tmp%10 == 9) {
                  result++;
                }
                tmp++;
            }

            //10의 자리수
            if (10<= tmp && tmp < 100) {
                if (tmp%10 == 3 || tmp%10 == 6 || tmp%10 == 9) {
                    result++;
                }
                if (tmp/10 == 3 || tmp/10 == 6 || tmp/10 == 9) {
                    result++;
                }
                tmp++;
            }

            if (100<= tmp && tmp < 1000) {
                if (tmp%10 == 3 || tmp%10 == 6 || tmp%10 == 9) {
                    result++;
                }
                if (tmp%100 / 10 == 3 || tmp%100 / 10 == 6 || tmp%100 / 10 == 9) { // 십의 자릿수
                    result++;
                }
                if (tmp/100 == 3 || tmp/100 == 6 || tmp/100 == 9) { // 백의 자릿수
                    result++;
                }
                tmp++;
            }

            if (1000<= tmp && tmp < 10000) {
                if (tmp%10 == 3 || tmp%10 == 6 || tmp%10 == 9) {
                    result++;
                }
                if (tmp%100 / 10 == 3 || tmp%100 / 10 == 6 || tmp%100 / 10 == 9) {
                    result++;
                }
                if (tmp%1000 / 100 == 3 || tmp%1000 / 100 == 6 || tmp%1000 / 100 == 9) {
                    result++;
                }
                if (tmp/1000 == 3 || tmp/1000 == 6 || tmp/1000 == 9) {
                    result++;
                }
                tmp++;
            }
        }

        return result;
    }
}
