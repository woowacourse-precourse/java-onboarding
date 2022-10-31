package onboarding;


import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int tmpAnswer = Integer.MAX_VALUE;

        // 1. valueCheck
        boolean result1 = valueCheck(pobi);
        boolean result2 = valueCheck(crong);

        // exception handling
        if(!(result1 & result2)) {
            answer = -1;
            return answer;
        }

        // 2. valueGetMax
        answer = valueGetMax(pobi);
        tmpAnswer = valueGetMax(crong);

        // 3. Compare answer vs tmpAnswer
        if(answer > tmpAnswer) {
            return 1;
        }
        else if (answer < tmpAnswer) {
            return 2;
        }
        else {
            return 0;
        }

    }

    public static boolean valueCheck(List<Integer> value) {

        int left = value.get(0);
        int right = value.get(1);

        if(left < 1 || left > 399 || right < 1 || right > 399)  // 페이지 번호가 1부터 시작되는 400페이지
            return false;
        if(left > right)
            return false;
        if((right-left) > 1)
            return false;
        if((left%2 == 0) && (right%2 == 1))
            return false;
        else
            return true;
    }
    /**
     *
     *   @param value //  add or multiply all value
     *   @return the largest value
     *
     */
    public static int valueGetMax(List<Integer> value) {
        int left = value.get(0);
        int right = value.get(1);

        // Calculate sum
        // left
        int l_sum = getSum(left);
        int l_mul = getMul(left);
        if(l_sum > l_mul) {
            left = l_sum;
        } else {
            left = l_mul;
        }

        // right
        int r_sum = getSum(right);
        int r_mul = getMul(right);
        if(r_sum > r_mul) {
            right = r_sum;
        } else {
            right = r_mul;
        }
        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    public static int getSum(int number) {
        int total = 0;
        while(number > 0) {
            total += number % 10;
            number /= 10;
        }
        return total;
    }
    public static int getMul(int number) {
        int total = 1;
        while(number > 0) {
            total *= number * 10;
            number /= 10;
        }
        return total;
    }
}