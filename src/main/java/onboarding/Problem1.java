package onboarding;

import java.util.List;

/**
 * 기능 목록
 * 1. 각 자리 숫자를 모두 더하는 함수, 각 자리를 모두 곱하는 함수
 * 2. (1)를 이용하여 왼쪽, 오른쪽 페이지 중 가장 큰 수 구하는 함수
 * 3. 입력 예외사항 처리
 * 4. 포비, 크롱의 수를 구한 후 비교하여 승부 결과 값 반환
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        char[] leftPageNumberForPobi = String.valueOf(pobi.get(0)).toCharArray();
        char[] rightPageNumberForPobi = String.valueOf(pobi.get(1)).toCharArray();

        char[] leftPageNumberForCrong = String.valueOf(crong.get(0)).toCharArray();
        char[] rightPageNumberForCrong = String.valueOf(crong.get(1)).toCharArray();

        return answer;
    }

    public static int addEachDigits(char[] pageNumber){
        int sumEachDigits = 0;

        for(char number : pageNumber){
            sumEachDigits += number - '0';
        }

        return sumEachDigits;
    }

    public static int multiplyEachDigits(char[] pageNumber){
        int multiplyEachDigits = 1;

        for(char number : pageNumber){
            multiplyEachDigits *= number - '0';
        }

        return multiplyEachDigits;
    }

}