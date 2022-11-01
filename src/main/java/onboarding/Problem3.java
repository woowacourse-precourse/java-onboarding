package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        for(int i=1; i<=number; i++)
        {
            numberList.add(i);
        }

        for(int i=0; i<number; i++)
        {
            String numStr = numberList.get(i)+"";
            for(int j=0; j<numStr.length(); j++)
            {
                if(numStr.charAt(j)=='3' || numStr.charAt(j)=='6' || numStr.charAt(j)=='9')
                    count++;
            }
        }
        return count;
    }
}
