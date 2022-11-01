package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int j=3;j<=number;j++)
        {
            int i=j;
            while(i>0)
            {
                if(i%10==3||i%10==6||i%10==9)
                {
                    answer++;
                }
                i=i/10;
            }
        }


        return answer;
    }
}
