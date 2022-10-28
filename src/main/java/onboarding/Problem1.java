package onboarding;

import java.util.List;

class Problem1 {
    public static int maxVal(List<Integer> pages)
    {
        int maxVal = Integer.MIN_VALUE;
        
        for (Integer page : pages) {
            int sum = 0;
            int mul = 1;
            for (String strPage : page.toString().split("")) {
                sum += Integer.parseInt(strPage);
                mul *= Integer.parseInt(strPage);
            }
            if(maxVal<sum) maxVal = sum;
            if(maxVal<mul) maxVal = mul;
        }
        
        return maxVal;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if ((pobi.get(1)-pobi.get(0) != 1)
                || (crong.get(1)-crong.get(0) != 1)
                || (pobi.get(0) == 1) || (pobi.get(1) == 400)
                || (crong.get(0) == 1) || (crong.get(1) == 400))
        {
            answer = -1;
            return answer;
        }

        int pobiScore = maxVal(pobi);
        int crongScore = maxVal(crong);
        
        if(pobiScore == crongScore) answer = 0;
        else if(pobiScore > crongScore) answer = 1;
        else answer = 2;

        return answer;
    }
}