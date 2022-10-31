package onboarding;

public class Problem3 {
    public static int check(int x)
    {
        String num = Integer.toString(x);
        int count = 0;
        int len = num.length();
        int now = 0;

        for (int i = 0; i < len; i++)
        {
            now = num.charAt(i);
            if (now == '3' || now == '6' || now == '9')
            {
                count += 1;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i < number+1; i++)
            answer += check(i);
        return answer;
    }
}
