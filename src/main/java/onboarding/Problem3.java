package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int i;
        for(i=1;i<=number;i++)
        {
            int tmp=i;
            while(tmp>0)
            {
                if(tmp%10==3||tmp%10==6||tmp%10==9)
                {
                    answer++;
                }
                tmp/=10;
            }
        }
        return answer;
    }
}
