package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isWrongPage(pobi.get(0), pobi.get(1)) || isWrongPage(crong.get(0), crong.get(1))) {
            return -1;
        }

        int pobiScore = Math.max(getMaxPageOperationValue(pobi.get(0)), getMaxPageOperationValue(pobi.get(1)));
        int crongScore = Math.max(getMaxPageOperationValue(crong.get(0)), getMaxPageOperationValue(crong.get(1)));

        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        } else {
            return 2;
        }
    }

    //페이지 번호의 각 자릿수를 모두 더하기, 모두 빼기 한 가장 큰 수 반환
    static int getMaxPageOperationValue(int num) {

        int sum = 0, mul = 1;

        while (num > 0) {
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }

        return Math.max(sum, mul);
    }

    //잘못된 페이지인지 확인
    static boolean isWrongPage(int leftPage, int rightPage) {

        if (leftPage > rightPage) {
            return true;
        }
        if (rightPage - leftPage > 1) {
            return true;
        }
        return false;
    }
}