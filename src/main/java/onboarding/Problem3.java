package onboarding;
/*
    기능 목록
    1. 박수를 쳐야하는지 아닌지 체크하는 기능 -> getClap
    2. 3, 6, 9에 해당하는지 체크하는 기능 -> is369
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (; number > 0; number--)
            answer += getClap(number);
        return answer;
    }

    private static int getClap(int number) {
        int ret = 0;

        while (number > 0) {
            if (is369(number) || is369(number % 10))
                ret++;
            number /= 10;
        }
        return ret;
    }

    private static boolean is369(int number) { return (number == 3 || number == 6 || number == 9); }
}
