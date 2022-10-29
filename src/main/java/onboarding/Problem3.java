package onboarding;

import java.io.CharArrayReader;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer=count369(number);
        return answer;
    }
    public static int count369(int number)
    {
        int count = 0;

        for (int i=3;i<=number;i++)
        {
            String numberToString = Integer.toString(i);
            char stringToCharArray[] = numberToString.toCharArray();
            for (char c : stringToCharArray)
            {
                if(c=='3'||c=='6'||c=='9')
                {
                    System.out.println(i);
                    count++;
                }
            }
        }
        return count;
    }
}
