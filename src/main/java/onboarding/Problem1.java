package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiSum = add(pobi);

        int crongSum = add(crong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int add(List<Integer> values) {
        int leftPageSum = getOnePageSum(values.get(0));
        int rightPageSum = getOnePageSum(values.get(1));

        return max(leftPageSum, rightPageSum);
    }

    private static int getOnePageSum(int pageNumber) {
        int onePageSum = 0;
        String[] stringArray = String.valueOf(pageNumber).split("");

        for(String number : stringArray) {
            onePageSum += Integer.parseInt(number);
        }

        return onePageSum;
    }

    private static int max(int first, int second) {
        if(first > second) {
            return first;
        }
        return second;
    }

}