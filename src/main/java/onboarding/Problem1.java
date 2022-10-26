package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 가장 큰 수를 구하는 기능을 하는 함수
    public static int getMaxNumber (Integer leftPageNum, Integer rightPageNum) {
        int leftPageMaxNum = calcMax(getSumPageNum(leftPageNum), getMultiplyPageNum(leftPageNum));
        int rightPageMaxNum = calcMax(getSumPageNum(leftPageNum), getMultiplyPageNum(leftPageNum));

        return calcMax(leftPageMaxNum, rightPageMaxNum);
    }

    // 승부 체크 기능을 하는 함수
    public static int getWinner(Integer pobiMaxNum, Integer crongMaxNum) {
        if (pobiMaxNum.equals(crongMaxNum)) { // pobi, crong DRAW
            return 0;
        } else if (pobiMaxNum > crongMaxNum) {   // pobi WIN
            return 1;
        } else if (pobiMaxNum < crongMaxNum) {  // crong WIN
            return 2;
        }
        return -1;
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하는 기능을 하는 함수
    public static int getSumPageNum(Integer pageNum){
        int sum = 0;
        while (pageNum > 0) {
            sum += pageNum % 10;
            pageNum /= 10;
        }
        return sum;
    }

    // 페이지 번호의 각 자리 숫자를 모두 곱하는 기능을 하는 함수
    public static int getMultiplyPageNum(Integer pageNum) {
        int mul = 1;
        while (pageNum > 0) {
            mul *= pageNum % 10;
            pageNum /= 10;
        }
        return mul;
    }

    // 두 수 중 큰 수를 반환하는 기능을 하는 함수
    public static int calcMax(Integer num1, Integer num2) {
        return Math.max(num1, num2);
    }

    /**
     *  예외사항 체크
     * 0. 전체 예외사항들을 체크 - > isException()
     * 1. 각 페이지 번호가 1 ~ 400 범위 안에 들어가있는지 확인 -> isPageRange()
     * 2. 왼쪽, 오른쪽 페이지 번호가 연속된 수인지 확인 -> isContinuous()
     * 3. 왼쪽 페이지 번호는 홀수, 오른쪽 페이지 번호는 짝수인지 확인 -> isEvenOrOdd()
     * 4. 시작 면과 마지막 면이 아닌지 확인 -> isNotNull()
     */

    public static boolean isException(List<Integer> page) {
        if (isPageRange(page) && isContinuous(page) && isEvenOrOdd(page) && isNotNull(page))  return true;
        return false;
    }

    public static boolean isPageRange (List<Integer> page) {
        if (page.get(0) >= 1 && page.get(0) <= 400 && page.get(1) >= 1 && page.get(1) <= 400) return true;
        return false;
    }

    public static boolean isContinuous(List<Integer> page) {
        if ((page.get(1) - page.get(0)) == 1)  return true;
        return false;
    }

    public static boolean isEvenOrOdd(List<Integer> page){
        if ((page.get(0) % 2 == 1) && (page.get(1) % 2 == 0)) return true;
        return false;
    }

    public static boolean isNotNull(List<Integer> page) {
        if (page.get(0) != null && page.get(1) != null) return true;
        return false;
    }
}