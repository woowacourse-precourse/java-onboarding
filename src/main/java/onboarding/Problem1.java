package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(check(pobi)&& check(crong)){
            int pobiMax = calculateMax(pobi);
            int crongMax = calculateMax(crong);
            if (pobiMax > crongMax) return 1;
            else if (pobiMax < crongMax) return 2;
            else return 0;
        }else return -1;
    }

    private static boolean check(List<Integer> list) {
        if(list.get(1)-list.get(0)==1)return true;
        else return false;
    }

    private static int calculateMax(List<Integer> list) {
        int left= list.get(0);
        int right= list.get(1);
        int sumMax= Math.max(numSum(left),numSum(right));
        int multiMax = Math.max(numMulti(left),numMulti(right));
        int max = Math.max(sumMax, multiMax);
        return max;
    }
    private static int numSum(int i){
        int sum = 0;
        while(i>0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
    private static int numMulti(int i){
        int multi = 1;
        while(i>0){
            multi*=i%10;
            i=i/10;
        }
        return multi;
    }
}