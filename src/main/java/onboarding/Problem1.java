package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //각 자리의 합계 구하는 메서드
    private static int sumOfEachDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    //각 자리의 곱셈의 합계를 구하는 메서드
    private static int multiplicationOfEachDigit(int num) {
        int multi = 1;
        while (num > 0) {
            multi *= num % 10;
            num /= 10;
        }
        return multi;
    }

    //유효성 검사 메서드
    private static boolean isValid(List<Integer> numbers) {
        //Valid하지 않는 경우들
        //List의 사이즈가 2가 아닌 경우
        if (numbers.size() != 2) return false;

        Integer leftPage = numbers.get(0);
        Integer rightPage = numbers.get(1);
        //null값인 경우
        if (leftPage == null || rightPage == null) return false;

        //왼쪽 페이지가 홀수가 아닌 경우, 오른쪽 페이지가 짝수가 아닌 경우
        if (leftPage % 2 == 0 || rightPage % 2 == 1) return false;
        //두 페이지가 연속하지 않는 경우
        if (rightPage - leftPage != 1) return false;
        //1보다 작은 경우 or 400보다 큰 경우
        if (leftPage < 1 || rightPage > 400) return false;
        return true;
    }
}