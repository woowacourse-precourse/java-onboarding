package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validate(List<Integer> pageNumbers) {
        Integer leftPage = pageNumbers.get(0);
        Integer rightPage = pageNumbers.get(1);

        // null check.
        if (leftPage == null || rightPage == null)
            return false;

        // 1 - 400 사이의 값인지 확인하는 과정
        // "시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다."
        if (leftPage <= 1 || rightPage >= 400)
            return false;
        
        // "책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고"
        if (leftPage % 2 == 0 || rightPage % 2 == 1)
            return false;

        // 왼쪽 페이지 번호 + 1 == 오른쪽 페이지 번호.
        if (leftPage + 1 != rightPage)
            return false;

        return true;
    }

    public static int calculateDigits(Integer value) {
        // 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int sum = 0, mul = 1;

        while (value != 0) {
            int digit = value % 10;
            sum += digit;
            mul *= digit;
            value /= 10;
        }

        return Integer.max(sum, mul);
    }

    public static int calculateScore(List<Integer> pageNumbers) {
        // 왼쪽 페이지와 오른쪽 페이지의 값을 비교해서 점수를 반환한다.
        Integer leftPage = pageNumbers.get(0);
        Integer rightPage = pageNumbers.get(1);

        return Integer.max(
                calculateDigits(leftPage),
                calculateDigits(rightPage)
        );
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (validate(pobi) && validate(crong)) {
            int pobiScore = calculateScore(pobi);
            int crongScore = calculateScore(crong);

            if (pobiScore > crongScore)
                answer = 1;
            else if (pobiScore < crongScore)
                answer = 2;
            else if (pobiScore == crongScore)
                answer = 0;
        } else
            answer = -1;
        return answer;
    }
}