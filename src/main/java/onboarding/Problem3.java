package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=3;i<=number;i++)
        {
            int subNum=i;
            while(subNum>0)
            {
                int check=subNum%10;
                if(check==3||check==6||check==9) {
                    answer++;
                }
                subNum=subNum/10;
            }
        }
        return answer;
    }
}
