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

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int crongSumMax = Math.max(getDigitSum(crong.get(0)), getDigitSum(crong.get(1)));
        int crongMulMax = Math.max(getDigitMul(crong.get(0)), getDigitMul(crong.get(1)));

        int pobiSumMax = Math.max(getDigitSum(pobi.get(0)), getDigitSum(pobi.get(1)));
        int pobiMulMax = Math.max(getDigitMul(pobi.get(0)), getDigitMul(pobi.get(1)));

        return answer;
    }
}