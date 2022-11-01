package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(!isValid(pobi, crong)) {
            return -1;
        }
        int pobiMax = Math.max(getMax(pobi.get(0)), getMax(pobi.get(1)));
        int crongMax = Math.max(getMax(crong.get(0)), getMax(crong.get(1)));

        if(pobiMax > crongMax) {
            answer = 1;
        } else if(pobiMax < crongMax) {
            answer = 2;
        }
        return answer;
    }

    public static boolean isValid(List<Integer> l1, List<Integer> l2) {
        return l1.get(1) - l1.get(0) == 1 && l2.get(1) - l2.get(0) == 1;
    }

    public static int getMax(int num) {
        int sum = 0;
        int sum1 = 1;
        while(num > 0) {
            int temp = num % 10;
            sum += temp;
            sum1 *= temp;
            num /=  10;
        }
        return Math.max(sum, sum1);
    }
}
