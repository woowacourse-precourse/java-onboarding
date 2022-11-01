package onboarding;

import java.util.List;

class Problem1 {
    // 전체 기능 호출
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkValidPage(pobi, crong)) {
            return judgedScore(getMaxScore(pobi), getMaxScore(crong));
        }
        return -1;
    }
    // 각 자릿수의 덧셈과 곱셈 중 큰 값을 반환하는 기능
    private static int getMaxScore(List<Integer> list) {
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            String page = String.valueOf(list.get(i));
            maxScore = Math.max(getAddition(page), getMultiplication(page));
        }
        return maxScore;
    }
    // 페이지의 각 자릿수의 덧셈을 반환하는 기능
    private static int getAddition(String digit) {
        int total = 0;
        for (int i = 0; i < digit.length(); i++) {
            total += Integer.parseInt(String.valueOf(digit.charAt(i)));
        }
        return total;
    }
    // 페이지의 각 자릿수의 곱셈을 반환하는 기능
    private static int getMultiplication(String digit) {
        int total = 1;
        for (int i = 0; i < digit.length(); i++) {
            total *= Integer.parseInt(String.valueOf(digit.charAt(i)));
        }
        return total;
    }
    // 두 플레이어의 승부를 각 점수로 판별하는 기능
    private static int judgedScore(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        }
        else if (pobi < crong) {
            return 2;
        }
        return 0;
    }
    // 예외처리 기능
    @SafeVarargs
    private static boolean checkValidPage(List<Integer>...list) {
        for (int i = 0; i < list.length; i++) {
            if (isNotConsecutiveNumber(list[i])) return false;
            if (isNotEvenNumber(list[i].get(1))) return false;
            if (isNotOddNumber(list[i].get(0))) return false;
        }
        return true;
    }
    // 두 페이지가 연속된 숫자인지 판별하는 기능
    private static boolean isNotConsecutiveNumber(List<Integer> list) {
        return list.get(1) - list.get(0) != 1;
    }
    // 왼쪽 페이지가 짝수인지 판별하는 기능
    private static boolean isNotEvenNumber(int number) {
        return number % 2 != 0;
    }
    // 오른쪽 페이지가 홀수인지 판별하는 기능
    private static boolean isNotOddNumber(int number) {
        return number % 2 == 0;
    }
}