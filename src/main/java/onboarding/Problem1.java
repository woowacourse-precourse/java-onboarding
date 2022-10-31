package onboarding;

import java.util.List;

class Problem1 {
    public static int checkPages(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)
            return 0;
        else if (pobi.get(0) <= 1 || crong.get(0) <= 1)
            return 0;
        else if (pobi.get(1) >= 400 || crong.get(1) >= 400)
            return 0;
        else if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0)
            return 0;
        else if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1)
            return 0;
        return 1;
    }
    public static int getPageMaxNumber(int page) {
        int add = 0;
        int mul = 1;

        for (int num = page; num != 0; num /= 10) {
            add += (num % 10);
            mul *= (num % 10);
        }
        return Math.max(add, mul);
    }
    public static int getMaxNumber(List<Integer> who) {
        int leftMaxNumber = getPageMaxNumber(who.get(0));
        int rightMaxNumber = getPageMaxNumber(who.get(1));

        return Math.max(leftMaxNumber, rightMaxNumber);
    }
    public static int getResult(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = getMaxNumber(pobi);
        int crongMax = getMaxNumber(crong);

        if (pobiMax > crongMax)
            return 1;
        else if (pobiMax < crongMax)
            return 2;
        return 0;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPages(pobi, crong) == 0)
            return -1;
        return getResult(pobi, crong);
    }
}