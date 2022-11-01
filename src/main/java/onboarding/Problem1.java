package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (pobi.size() !=2 || crong.size() != 2 ||pobi.get(1) - pobi.get(0) != 1
            || crong.get(1) - crong.get(0) != 1 || pobi.get(0) == 1 || crong.get(0)== 1
            || pobi.get(1) == 2 || crong.get(1) == 2 || pobi.get(0) == 399
            || crong.get(0)== 399 || pobi.get(1) == 400 || crong.get(1) == 400
            || pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return -1;
        }

        int pobimax = Math.max(calculate(pobi.get(0)), calculate(pobi.get(1)));
        int crongmax = Math.max(calculate(crong.get(0)), calculate(crong.get(1)));

        if (pobimax > crongmax) {
            answer = 1;
        } else if (pobimax < crongmax) {
            answer = 2;
        } else
            answer = 0;

        return answer;
    }

    public static int calculate(int n) {
        int sum = 0;
        int mul = 1;
        while (n != 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }
        return Math.max(sum, mul);
    }

}
