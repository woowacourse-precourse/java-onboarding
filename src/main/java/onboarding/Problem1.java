package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int sum(List<Integer> list){
        int max=Integer.MIN_VALUE;
        int num = 0;
        for(int i=0; i<2; i++){
            int cur = list.get(i);
            if(cur >= 100){
                num += cur/100;
                num += (cur%100)/10;
                num += cur%10;
            }
            else{
                num += cur/10;
                num += cur%10;
            }
            max = Math.max(max, num);
            num=0;
        }
        return max;
    }
    public static boolean checkException(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            return false;
        }
        return true;
    }
}