package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int p = -1, c = -1;

        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
            return answer;
        }

        p = getMax(pobi);
        c = getMax(crong);

        if(p != -1 && c != -1 && p > c)
            answer = 1;
        else if(p == c)
            answer = 0;
        else
            answer = 2;

        return answer;
    }

    private static int getMul(int n, int mul) {
        while(n / 10 != 0 || n % 10 != 0) {
            mul *= n % 10;
            n /= 10;
        }
        return mul;
    }

    private static int getSum(int n, int sum) {
        while(n / 10 != 0 || n % 10 != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int getMax(List<Integer> person) {
        int max = -1;
        int sum = 0;
        int mul = 1;
        int n = person.get(0);

        sum = getSum(n, sum);

        n = person.get(1);
        mul = getMul(n, mul);

        if (sum > mul) {
            max = sum;
        } else {
            max = mul;
        }
        return max;
    }
}