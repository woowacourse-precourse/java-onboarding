package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiResult = getResult(pobi);
        int crongResult = getResult(crong);

        if (pobi.get(1) - pobi.get(0) != 1 | crong.get(1) - crong.get(0) != 1)
            return -1;
        else if (pobiResult > crongResult)
            return 1;
        else if (pobiResult < crongResult)
            return 2;
        return 0;
    }

    private static int getResult(List<Integer> names) {
        int result = 0;
        for (int temp : names) {
            int addUp = 0, multipleUp = 1;
            while (temp > 0) {
                addUp += temp % 10;
                multipleUp *= temp % 10;
                temp /= 10;
            }
            result = Math.max(result, Math.max(addUp, multipleUp));
        }
        return result;
    }
}
