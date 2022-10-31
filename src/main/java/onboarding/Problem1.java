package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiSum = add(pobi);
        int pobiMulti = multiply(crong);
        int pobiMax = max(pobiSum, pobiMulti);

        int crongSum = add(crong);
        int crongMulti = multiply(crong);
        int crongMax = max(crongSum, crongMulti);

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

    private static int multiply(List<Integer> values) {
        int leftPageMulti = getOnePageMulti(values.get(0));
        int rightPageMulti = getOnePageMulti(values.get(1));

        return max(leftPageMulti, rightPageMulti);
    }

    private static int getOnePageMulti(int pageNumber) {
        int onePageMulti = 1;
        String[] stringArray = String.valueOf(pageNumber).split("");

        for(String number : stringArray) {
            onePageMulti *= Integer.parseInt(number);
        }

        return onePageMulti;
    }

}