package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String s="";
        char c;

        for(int i=1; i<number+1; i++)
        {
            s=String.valueOf(i);
            for(int j=0; j<s.length(); j++)
            {
                c=s.charAt(j);
                if(c=='3' || c=='6' || c== '9')
                {
                    answer++;
                }

            }

        }
        return answer;
    }
}