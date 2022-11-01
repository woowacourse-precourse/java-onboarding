package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        if(number <=2)
            return 0;

        for(int i=3; i<=number; i++)
        {
            String numStr = i+"";
            for(int j=0; j<numStr.length(); j++)
            {
                if(numStr.charAt(j)=='3' || numStr.charAt(j)=='6' || numStr.charAt(j)=='9')
                    count++;
            }
        }
        return count;
    }
}
