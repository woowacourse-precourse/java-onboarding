package onboarding;

import javax.xml.validation.Validator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (validateNum(pobi) == -1 || validateNum(crong) == -1)
            return -1;

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        answer = getWinner(pobiScore, crongScore);
        return answer;
    }
    // 페이지가 맞으면 1, 아니면 -1
    private static int validateNum(List<Integer> list) {
        if (list.get(0) < 1 || list.get(1) > 400)
            return -1;
        if (list.get(0) % 2 == 0 || list.get(1) % 2 == 1)
            return  -1;
        if (list.get(0) + 1 != list.get(1))
            return  -1;

        return 1;
    }
    private static int getScore(List<Integer> list) {
        int leftScore = 0;
        int rightScore = 0;

        leftScore = Math.max(addDigit(list.get(0)), multiplyDigit(list.get(0)));
        rightScore = Math.max(addDigit(list.get(1)), multiplyDigit(list.get(1)));

        return Math.max(leftScore, rightScore);
    }

    private static int addDigit(int num) {
        int sum = 0;
        String[] arr = String.valueOf(num).split("");
        int[] numbers = new int[arr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        for (int k = 0; k < numbers.length; k++) {
            sum += numbers[k];
        }
        return sum;
    }

    private static int multiplyDigit(int num) {
        int sum = 1;

        String[] arr = String.valueOf(num).split("");
        int[] numbers = new int[arr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        for (int k = 0; k < numbers.length; k++) {
            sum *= numbers[k];
        }
        return sum;
    }

    private static int getWinner(int num1, int num2) {
        if (num1 > num2)  // 포비 win
            return  1;
        if (num1 < num2)  // 크롱 win
            return 2;
        return 0;         // 무승부
    }
}