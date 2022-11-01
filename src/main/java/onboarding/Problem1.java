package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax=Integer.MIN_VALUE;
        int crongMax=Integer.MIN_VALUE;

        if(!checkException(pobi, crong)) return -1;

        pobiMax = Math.max(pobiMax, sum(pobi));
        pobiMax = Math.max(pobiMax, mul(pobi));
        crongMax = Math.max(crongMax, sum(crong));
        crongMax = Math.max(crongMax, mul(crong));

        if(pobiMax > crongMax){
            return 1;
        }
        else if(pobiMax < crongMax){
            return 2;
        }
        else{
            return 0;
        }
    }
    public static int mul(List<Integer> list){
        int max = Integer.MIN_VALUE;
        int num = 1;
        for(int i=0; i<2; i++){
            int cur = list.get(i);
            if(cur >= 100){
                num *= cur/100;
                num *= (cur%100)/10;
                num *= cur%10;
            }
            else{
                num *= cur/10;
                num *= cur%10;
            }
            max = Math.max(max, num);
            num=1;
        }
        return max;
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
        for(int i=0; i<2; i++){
            if(!isValidPage(pobi.get(i)) || !isValidPage(crong.get(i)))
                return false;
        }
        return true;
    }
    public static boolean isValidPage(int page){
        if(page < 1 || page >400)
            return false;
        return true;
    }
}