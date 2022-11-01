package onboarding;

import java.util.List;

/*
조건
페이지는 1~400, 주어지는 리스트 2개 [?,?]
기능
MaxValue() : 페이지의 각 자리 숫자를 더하거나 곱해서 가장 큰 수를 구함
페이지가 1,400 or 연이은 페이지번호가 아니면  return -1
 */

class Problem1 {
    public static int maxValue(int x){
        int pValue=0, mValue=1,n;
        
        int a = x % 10;
        int b = (x / 10)%10;
        int c = (x/100);

        pValue = a+b+c;
        if(b==0) b=1;
        if(c==0) c=1;
        mValue = a*b*c;
        return Math.max(pValue,mValue);
    }

    public static boolean isPage(List<Integer> list){
        boolean result=true;
        if(list.get(0)+1 != list.get(1))
            result=false;

        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(isPage(pobi)&&isPage(crong)))
            return -1;

        int pScore,cScore;
        pScore=Math.max(maxValue(pobi.get(0)),maxValue(pobi.get(1)));
        cScore=Math.max(maxValue(crong.get(0)),maxValue(crong.get(1)));

        if(pScore>cScore)
            answer=1;
        else if (cScore>pScore)
            answer=2;
        else if (pScore==cScore)
            answer=0;

        return answer;
    }
}