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

        return answer;
    }
}