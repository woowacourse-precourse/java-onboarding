package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (myNumber(pobi) == -1 || myNumber(crong) == -1) {
            return -1;
        }
        int pobiNum = myNumber(pobi);
        int crongNum = myNumber(crong);

        return answer;
    }

    public static int myNumber(List<Integer> name) {
        if (name.get(0) + 1 != name.get(1)) {
            return -1;
        }
        if (name.get(0) == 1 || name.get(1) == 400) {
            return -1;
        }

        int myNum = 0;

        for (int i = 0; i < 2; i++) {
            int num = name.get(i);
            int sum = 0;
            int mul = 1;

            while (num > 0) {
                sum += num % 10;
                mul *= num % 10;
                num /= 10;
            }
            num = bigger(sum, mul);
            if (myNum < num) {
                myNum = num;
            }
        }
        return myNum;
    }

    public static int bigger(int a, int b) {
        return Math.max(a, b);
    }
}
