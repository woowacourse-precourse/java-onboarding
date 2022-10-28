package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        checkException(number);

        answer = start(number);

        return answer;
    }

    public static int start(int num)
    {
        int cnt = 0;
        for (int i = 0; i <= num; i++)
            cnt += checkDuplication(i);

        return cnt;
    }

    //중복 체크
    public static int checkDuplication(int num)
    {
        int cnt = 0;

        while (num > 0)
        {
            if ((num % 10) == 3 || (num % 10) == 6 || (num % 10) == 9)
                cnt++;
            num /= 10;
        }

        return cnt;
    }
    /*
    예외 처리 함수
     */
    public static void checkException(int number) {
        if (number < 1 || number > 10000)
            throw new IllegalArgumentException("ERROR");
    }
}
