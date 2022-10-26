package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    /** 기능 명세
     * 1. 승부에 낼 값 결정하기
     *     - 왼쪽과 오른쪽의 페이지 번호로 만들 수 있는 가장 큰 값을 찾아 선택
     * 2. 승부 결과 출력
     * 3. 예외 처리
     *     - 왼쪽, 오른쪽 페이지가 서로 연속된 숫자가 아닌 경우
     *     - 시작면이나 마지막 면이 나온 경우
     */

    // 기능 명세 1번에 해당하는 함수
    public static int findMax(List<Integer> pageList) {
        int max = 0;
        int leftPage = pageList.get(0)-1;
        for (int currentPage : pageList) {
            if (leftPage+1 == currentPage) {
                int[] pageNumToArr = Stream.of(String.valueOf(currentPage).split("")).mapToInt(Integer::parseInt).toArray();
                int sumOfPage = Arrays.stream(pageNumToArr).sum();
                int mulOfPage = multipleCalculator(pageNumToArr);  // 각 자리 곱셈은 별도의 함수로 분리하여 계산

                if (sumOfPage > mulOfPage) { max = sumOfPage; }
                else           { max = mulOfPage; }

                leftPage = currentPage;
            } else { max = -1; break; }
        }
        return max;
    }


    // 각 자리 곱셈은 따로 계산하기 위해 별도의 함수 생성
    public static int multipleCalculator(int[] pageNumToArr) {
        int multipleResult = 1;
        for (int num : pageNumToArr) { multipleResult *= num; }
        return multipleResult;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobiAnswer = findMax(pobi);
        int crongAnswer = findMax(crong);

        if (pobiAnswer == -1 || crongAnswer == -1 ) { answer = -1; }
        else {
            switch (Integer.compare(pobiAnswer, crongAnswer)) {
                case 1:
                    answer = 1;
                    break;
                case 0:
                    answer = 0;
                    break;
                case -1:
                    answer = 2;
                    break;
                default:   // exception은 -1 출력
                    answer = -1;
                    break;
            }
        }
        return answer;
    }
}