package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1)) {
            if (pobi.get(0) > 2 && pobi.get(0) < 398 && pobi.get(1) > 3 && pobi.get(1) < 399 && crong.get(0) > 2 && crong.get(0) < 398 && crong.get(1) > 3 && crong.get(1) < 399) {
                int a = Math.max(getSumOfNumbers(pobi.get(0)),getSumOfNumbers(pobi.get(1)));
                int b = Math.max(getProductOfNumbers(pobi.get(0)),getProductOfNumbers(pobi.get(1)));
                int pobiMax = Math.max(a, b);

                a = Math.max(getSumOfNumbers(crong.get(0)),getSumOfNumbers(crong.get(1)));
                b = Math.max(getProductOfNumbers(crong.get(0)),getProductOfNumbers(crong.get(1)));
                int crongMax = Math.max(a, b);

                if (pobiMax > crongMax) {
                    answer = 1;
                }
                else if (pobiMax < crongMax) {
                    answer = 2;
                }
                else {
                    answer = 0;
                }
            }
            else {
                answer = -1;
            }
        }
        else {
            answer = -1;
        }
        return answer;
    }
    public static int getSumOfNumbers(int num) {
        int sum  = 0;
        int temp = num;
        while (temp != 0) {
            sum += Math.floorMod(temp, 10);
            temp = Math.floorDiv(temp, 10);
        }
        return sum;
    }
    public static int getProductOfNumbers(int num) {
        int sum  = 1;
        int temp = num;
        while (temp != 0) {
            sum *= Math.floorMod(temp, 10);
            temp = Math.floorDiv(temp, 10);
        }
        return sum;
    }
}