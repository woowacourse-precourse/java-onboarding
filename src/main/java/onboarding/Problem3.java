package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = ThreeSixNineController.findTotal369(number);
        return answer;
    }
}


class ThreeSixNineController {
    private static boolean is369(int num) {
        return (num == 3 || num == 6 || num == 9);
    }

    private static int find369(int num) {
        int result = 0;

        while (num!=0) {
            result += is369(num % 10)? 1 : 0;
            num /= 10;
        }
        return result;
    }

    static int findTotal369(int num) {
        int result = 0;

        for (int i = 1; i <= num; i++) {
            result += find369(i);
        }
        return result;
    }
}