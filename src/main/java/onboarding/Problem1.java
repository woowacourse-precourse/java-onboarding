package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - 페이지 번호가 1~400 의 책
 * - 왼쪽이 홀수 오른쪽이 짝수
 *
 * 1. 점수 산정 방식
 * - 왼쪽, 오른쪽 페이지중 각 자리 숫자를 모두 더한 값, 곱한 값 중 가장 큰 수를 본인 점수로 선정
 *
 * 2. 승자 선정 방식
 * - 더 큰 점수인 사람이 승자
 *
 * 3. 제한 사항 -> 해당 경우 예외 사항으로 간주하여 -1 return
 * - 시작 면, 마지막 면 페이지는 펼치지 않도록
 * - 연속된 페이지 번호가 아닐경우
 * - [ 홀수 ,짝수 ] 로 페이지 번호가 입력되지 않을 경우
 * */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;



        return answer;
    }

    // 입력받은 두 페이지 번호를 가지고 각 자리 숫자를 모두 더한 값, 곱한 값 중 가장 큰 수를 리턴
    public int calculateScore(int leftPageNum, int rightPageNum){

        int sumLeftPageNum = 0;
        int mulLeftPageNum = 1;
        int sumRightPageNum = 0;
        int mulRightPageNum = 1;

        int[] leftPageNumArray = Stream.of(String.valueOf(leftPageNum).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] rightPageNumArray = Stream.of(String.valueOf(rightPageNum).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 각자리 술자를 모두 더하고 곱함
        for (int pageNum: leftPageNumArray) {
            sumLeftPageNum += pageNum;
            mulLeftPageNum *= pageNum;
        }

        // 각자리 술자를 모두 더하고 곱함
        for (int pageNum: rightPageNumArray) {
            sumRightPageNum += pageNum;
            mulRightPageNum *= pageNum;
        }

        return Integer.max(Integer.max(sumLeftPageNum,mulLeftPageNum),Integer.max(sumRightPageNum,mulRightPageNum));

    }
}