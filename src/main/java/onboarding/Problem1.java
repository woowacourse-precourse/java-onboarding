package onboarding;

import java.util.List;

class Problem1 {

    public static int calculate(int leftPage, int rightPage) {
        if (!isSatisfiedCondition(leftPage, rightPage)) {
            return -1;
        }
        Integer leftMax = getMax(leftPage);
        Integer rightMax = getMax(rightPage);
        return Math.max(leftMax, rightMax);
    }

    public static Integer getMax(Integer page) {
        String number = String.valueOf(page);
        Integer sum = 0, multiple = 1;
        for (int i=-0; i<number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
            multiple *= Character.getNumericValue(number.charAt(i));
        }
        return Math.max(sum,multiple);
    }


    public static boolean isSatisfiedCondition(int leftPage, int rightPage) {
        if (leftPage%2 != 1 || rightPage%2 != 0) {
            return false;
        }
        if (leftPage != rightPage-1) {
            return false;
        }
        if (leftPage <= 1 || rightPage >= 400) {
            return false;
        }
        return true;
    }



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = calculate(pobi.get(0),pobi.get(1));
        int crongMax = calculate(crong.get(0), crong.get(1));

        return answer;
    }
}