package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = checkNum(number);
        return answer;
    }

    public static int checkNum(int number)
    {
        String strNum;
        int cnt = 0;

        for (int i = 1; i <= number; i++)
        {
            strNum = Integer.toString(i);
            if (strNum.contains("3") || strNum.contains("6") || strNum.contains("9"))
                cnt++;
        }
        return cnt;
    }
}
