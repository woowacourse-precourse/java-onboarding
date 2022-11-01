package onboarding;
import java.util.List;

class Problem1 {

    public int Max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public static int splitSum(int target) {
        int sum = 0;
        while (target != 0) {
            sum += target % 10;
            target = (int) (target / 10);
        }

        return sum;
    }

    public static int splitProd(int target) {
        int prod = 1;
        while (target != 0) {
            prod *= target % 10;
            target = (int) (target / 10);
        }
        return prod;
    }

    public static int getMaxValue(List<Integer> nums) {
        int maxValue = Integer.MIN_VALUE;
        int sum, prod;
        for (int num : nums) {
            sum = splitSum(num);
            prod = splitProd(num);

            if (sum > prod) {
                maxValue = sum;
            } else {
                maxValue = prod;
            }
        }

        return maxValue;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiRight - pobiLeft == 1 && crongRight - crongLeft == 1) {

            int pobiMax = getMaxValue(pobi);
            int crongMax = getMaxValue(crong);
            if (pobiMax > crongMax) {
                answer = 1;
            } else if (pobiMax < crongMax) {
                answer = 2;
            } else {
                answer = 0;
            }


        } else {
            answer = -1;
        }

        return answer;
    }
}