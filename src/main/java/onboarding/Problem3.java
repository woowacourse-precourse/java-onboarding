package onboarding;

public class Problem3 {
    static int clap(int number)
    {
        int count = 0;
        int clap = 0;

        while(number > 0)
        {
            if (number%10 ==3 ||number%10 ==6||number%10 ==9)
            {
                count++;
            }
            number = number/10;
        }
        return count;
    }
    static int countNum(int number)
    {
        int count = 0;
        for(int i =1;i<=number;i++)
        {
            count += clap(i);
        }
        return count;
    }


    public static int solution(int number) {
        int answer = countNum(number);
        return answer;
    }
}
