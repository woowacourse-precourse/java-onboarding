package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }

        return findMaxValue(pobi) > findMaxValue(crong) ? 1 : 0;
    }

    private static boolean checkError(List<Integer> user) {
        if (checkMaxPage(user)) {
            return true;
        }

        //check page continuity
        return user.get(1) - user.get(0) != 1;
    }

    private static boolean checkMaxPage(List<Integer> user) {
        return user.stream().anyMatch(page -> page > 400);
    }

    private static Integer findMaxValue(List<Integer> user) {
        int maxNum = 0;

        for (Integer page : user) {
            String pageString = Integer.toString(page);

            maxNum = selectOperResult(maxNum, pageString);
        }

        return maxNum;
    }

    private static int selectOperResult(int maxNum, String pageString) {
        int sum = 0;
        int mul = 1;

        for (char num : pageString.toCharArray()) {
            sum += Character.getNumericValue(num);
            mul *= Character.getNumericValue(num);
        }

        maxNum = Math.max(maxNum, Math.max(sum, mul));

        return maxNum;
    }
}