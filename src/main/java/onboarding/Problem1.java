package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(1)-pobi.get(0)!=1||crong.get(1)-crong.get(0)!=1)
            return -1;

        int pobiValue = finder(pobi.get(0),pobi.get(1));
        int crongValue = finder(crong.get(0),crong.get(1));

        if(pobiValue>crongValue)
            answer=1;
        else if(pobiValue<crongValue)
            answer=2;
        else if(pobiValue==crongValue)
            answer=0;

        return answer;
    }
    public static int finder(int left,int right)
    {
        int sumLeft=0;
        int sumRight=0;
        int multipleLeft=1;
        int multipleRight=1;
        int maxValue=0;
        while(left>0)
        {
            sumLeft +=left%10;
            multipleRight *=left%10;
            left=left/10;
        }
        while(right>0)
        {
            sumRight +=right%10;
            multipleRight *=right%10;
            right=right/10;
        }
        maxValue=sumLeft;
        if(multipleLeft>maxValue)
            maxValue=multipleLeft;
        if(sumRight>maxValue)
            maxValue=sumRight;
        if(multipleRight>maxValue)
            maxValue=multipleRight;
        return maxValue;
    }
}