package onboarding;

public class Problem3 {

    public static int GetClap(int number)
    {
        int ret = 0;
        while (number != 0)
        {
            if ((number % 10 != 0) && (number % 10) % 3 == 0)
                ret++;
            number /= 10;
        }
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++)
            answer += GetClap(i);
        return answer;
    }
}
