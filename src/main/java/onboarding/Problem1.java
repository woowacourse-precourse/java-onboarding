package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 각 자리 숫자 더하기
    public static int getSum(int page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }
    // 각 자리 숫자 곱하기
    public static int getMultiply(int page) {
        int multiplication = 0;
        while(page > 0) {
            multiplication *= page % 10;
            page /= 10;
        }
        return multiplication;
    }
    // 큰 숫자 구하기
    public static int getMaxNumber(int sum, int multiple) {
        return Math.max(sum,multiple);
    }
    // 결과 비교
    public static int getResult(int pobiNumber, int crongNumber) {
        if(pobiNumber>crongNumber) return 1;
        else if (pobiNumber<crongNumber) return 2;
        else return 0;
    }
    // 예외: 왼쪽 홀수. 오른쪽 짝수, 연결된 번호 인지 확인. 1이거나 400이면 안됨
    public static boolean isAvailablePageRange(List<Integer> page){
        if(page.get(0) <=1 || page.get(1) <= 1 || page.get(0) >= 400 || page.get(1) >= 400) return false;
        return true;
    }
}

