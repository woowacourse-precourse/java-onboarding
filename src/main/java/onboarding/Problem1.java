package onboarding;

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
 *
 * */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 problem1 = new Problem1();
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0;
        int crongScore = 0;

        // 제한 사항
        // 시작 면, 마지막 면 페이지가 펼쳐진 경우
        if((pobi.get(0) == 1) || (pobi.get(1) == 400)
                || (crong.get(0) == 1) || (crong.get(1) == 400)){
            return -1;
        }
        // 연속된 페이지 번호가 아닐경우
        if((pobi.get(1)-pobi.get(0) != 1) || (crong.get(1)-crong.get(0) != 1)){
            return -1;
        }

        // 포비와 크롱의 점수를 계산
        pobiScore = Integer.max(problem1.calculateScore(pobi.get(0)),problem1.calculateScore(pobi.get(1)));
        crongScore = Integer.max(problem1.calculateScore(crong.get(0)),problem1.calculateScore(crong.get(1)));

        if(pobiScore > crongScore){
            answer = 1;
        }else if(pobiScore < crongScore){
            answer = 2;
        }else if(pobiScore == crongScore){
            answer = 0;
        }

        return answer;
    }

    // 입력받은 두 페이지 번호를 가지고 각 자리 숫자를 모두 더한 값, 곱한 값 중 가장 큰 수를 리턴
    public int calculateScore(int inputNum){

        int sumInputNum = 0;
        int mulInputNum = 1;

        // inputNum의 각자리 수를 int형 배열에 각각 저장
        int[] inputNumArray = Stream.of(String.valueOf(inputNum).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 각자리 숫자를 모두 더하고 곱함
        for (int pageNum: inputNumArray) {
            sumInputNum += pageNum;
            mulInputNum *= pageNum;
        }

        return Integer.max(sumInputNum,mulInputNum);

    }
}