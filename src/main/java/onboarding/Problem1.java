package onboarding;

import java.util.List;
import java.util.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore =0;
        int crongScore = 0;
        
        //pobiScore = Math.max(getMaxCalc(pobi.get(0).intValue()), getMaxCalc(pobi.get(1).intValue()));
        //crongScore = Math.max(getMaxCalc(crong.get(0).intValue()), getMaxCalc(crong.get(1).intValue()));

        pobiScore = getMaxPage(pobi);
        crongScore = getMaxPage(crong);

        if(pobiScore == -1 ||  crongScore == -1)
        {
            return -1;
        }
        else if(pobiScore > crongScore)
        {
            answer = 1;
        }
        else if(pobiScore < crongScore)
        {
            answer = 2;
        }
        else if(pobiScore == crongScore)
        {
            answer = 0;
        }
        else
            answer = -1;

        
        return answer;
    }

    public static int getMaxCalc(int num)
    {
        String numString = Integer.toString(num);
        int add = 0; int mul = 1;

        for(int i = 0; i < numString.length(); i++)
        {
            add = add + (numString.charAt(i) - '0');
            mul = mul * (numString.charAt(i) - '0');
        }
        

        return Math.max(add, mul);
    }
    public static int getMaxPage(List<Integer> input)
    {
        int left , right;
        if(input.get(1).intValue() - input.get(0).intValue() != 1)
            return -1;
        
        left = getMaxCalc(input.get(0).intValue());
        right = getMaxCalc(input.get(1).intValue());
 
        return Math.max(left, right);
        
    }
}