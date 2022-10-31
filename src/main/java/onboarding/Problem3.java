package onboarding;

//-----기능-----
// 1. 숫자에 3, 6, 9 갯수 판별

public class Problem3 {
    private static int findNum(int num) {
        int cnt = 0;
        while (num > 0)
        {
            int digit = num % 10;
            num /= 10;
            if (digit == 3 || digit == 6 || digit == 9)
                cnt++;
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        while (number > 0)
            answer += findNum(number--);
        return answer;
    }
}
