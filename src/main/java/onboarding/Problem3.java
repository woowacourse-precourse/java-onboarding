package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // 박수칠 숫자 체크
    static int check(int number) {
        int result = 0;
        while (number > 0) {
            int jarisoo_1 = number%10;
            if (jarisoo_1 == 3 || jarisoo_1 == 6 || jarisoo_1 == 9) result ++;
            number /= 10;
        }
        return result;
    }
}
