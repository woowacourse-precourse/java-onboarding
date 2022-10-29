package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int[] getArrayByNumber(int number) {
        // 숫자를 배열로 만드는 메소드
        String string = Integer.toString(number);
        int[] digits = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            digits[i] = string.charAt(i) - '0';
        }

        Arrays.sort(digits);
        return digits;
    }

    private static int getSumByNumber(int number) {
        // 숫자의 각 자리수를 모두 더하는 메소드
        int sumValue = 0;
        int[] array = getArrayByNumber(number);

        for (int value : array) {
            sumValue += value;
        }

        return sumValue;
    }

    private static int getMulByNumber(int number){
        // 숫자의 각 자리수를 모두 곱하는 메소드
        int mulValue = 1;
        int[] array = getArrayByNumber(number);

        for (int value : array){
            mulValue *= value;
        }

        return mulValue;
    }

    private static boolean isInputError(List<Integer> pages) {
        // 올바른 입력이 들어왔는지 확인하는 메소드
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 1 ~ 400 이내인지 확인
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
            return true;
        }

        // 페이지의 차이가 1인지 확인
        if (rightPage - leftPage != 1) {
            return true;
        }

        // 왼쪽 페이지가 홀수이고 오른쪽 페이지가 짝수인지 확인
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return true;
        }

        return false;
    }

}