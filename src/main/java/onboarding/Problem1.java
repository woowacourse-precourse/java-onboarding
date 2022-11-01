package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validateInput(List<Integer> who) {
        if (who.size() != 2)
            return false;
        else if (who.get(0) <= 1)
            return false;
        else if (who.get(1) >= 400)
            return false;
        else if (who.get(0) % 2 == 0)
            return false;
        else if (who.get(1) - who.get(0) != 1)
            return false;
        return true;
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
        if (!validateInput(pobi) || !validateInput(crong))
            return -1;
        return getResult(pobi, crong);
    }
}