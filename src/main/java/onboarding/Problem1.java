package onboarding;

import java.util.List;

class Problem1 {

    public static int calculate(int leftPage, int rightPage) {
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


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = calculate(pobi.get(0),pobi.get(1));
        int crongMax = calculate(crong.get(0), crong.get(1));

        return answer;
    }
}