package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(0) == pobi.get(1)-1 && crong.get(0) == crong.get(1)-1){
            int pobiMax = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
            int crongMax = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));

            if(pobiMax == crongMax) return 0;
            return (pobiMax > crongMax) ? 1 : 2;
        }else{
            return -1;
        }
    }

    public static int findMaxNum(int n) {
        int add = n % 10;
        int mul = n % 10;
        n /= 10;

        while(n > 0) {
            int temp = n % 10;
            add += temp;
            mul *= temp;
            n /= 10;
        }

        return Math.max(add, mul);
    }
}