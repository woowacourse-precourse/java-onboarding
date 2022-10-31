package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String temp;

        for(int i = 0; i <= number; i++)
        {
            temp = Integer.toString(i);
            for(int j = 0; j < temp.length(); j++)
            {
                if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9')
                {
                    answer ++;
                }
            }
          
        }
        return answer;
    }
}
