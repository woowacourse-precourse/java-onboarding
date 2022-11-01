package onboarding;

import java.util.List;

class Problem1 {

    // 페이지 번호를 받아서, 각 자리를 더한 값 반환
    static int getDigitSum(Integer page){
        int result = 0;
        while (page != 0){
            result += (page % 10);
            page /= 10;
        }
        return result;
    }

    // 페이지 번호를 받아서, 각 자리를 곱한 값 반환
    static int getDigitMul(Integer page){
        int result = 1;
        while (page != 0){
            result *= (page % 10);
            page /= 10;
        }
        return result;
    }

    // 예외 처리:
    // 1. 연속된 페이지여야 하며
    // 2. 홀수, 짝수를 만족해야 한다.
    static boolean isValid(List<Integer> person){
        // 1 ~ 400 사이여야 한다.
        if (1 > person.get(0) || person.get(0) > 400) return false;
        if (1 > person.get(1) || person.get(1) > 400) return false;

        // 연속된 페이지여야 한다.
        if (person.get(1) - person.get(0) != 1) return false;
        // 왼쪽은 홀수, 오른쪽은 짝수여야 한다.
        if ((person.get(0) & 1) != 1) return false;
        if ((person.get(1) & 1) != 0) return false;
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi) || !isValid(crong))
            return -1;

        int crongSumMax = Math.max(getDigitSum(crong.get(0)), getDigitSum(crong.get(1)));
        int crongMulMax = Math.max(getDigitMul(crong.get(0)), getDigitMul(crong.get(1)));

        int pobiSumMax = Math.max(getDigitSum(pobi.get(0)), getDigitSum(pobi.get(1)));
        int pobiMulMax = Math.max(getDigitMul(pobi.get(0)), getDigitMul(pobi.get(1)));

        // 최종 점수를 빼서 양수면 크롱, 음수면 포비, 0이면 무승부
        int cmpValue = Math.max(crongSumMax, crongMulMax) - (Math.max(pobiSumMax, pobiMulMax));
        if (cmpValue > 0) answer = 2;
        else if (cmpValue < 0) answer = 1;
        else answer = 0;

        return answer;
    }
}