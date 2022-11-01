package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return compare(pobi,crong);
    }
    private static int compare(List<Integer> pobi,List<Integer> crong){
        int pobiMax=Math.max(calc(pobi.get(0)),calc(pobi.get(1)));
        int crongMax=Math.max(calc(crong.get(0)),calc(crong.get(1)));
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1) return -1;
        else if(pobiMax < crongMax) return 2;
        else if(pobiMax > crongMax) return 1;
        else return 0;
    }
    private static int calc(int num){
        char[] Test=Integer.toString(num).toCharArray();
        return Math.max(multi(Test), plus(Test));
    }
    private static int multi(char[] ch){ //곱할 경우
        int sum=1;
        for(int i=0;i<ch.length; i++)
            sum=sum*(ch[i]-'0');
        return sum;
    }
    private static int plus(char[] ch){ //더한 경우
        int sum=0;
        for(int i=0;i<ch.length; i++)
            sum=sum+(ch[i]-'0');
        return sum;
    }
}