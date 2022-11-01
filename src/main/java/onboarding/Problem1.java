package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong){
        int answer = Integer.MAX_VALUE;

        int pobiMax = pageMaxValue(pobi); // pobi의 가장 큰 page
        int crongMax = pageMaxValue(crong);// crong의 가장 큰 page

        if(pobiMax == -1 || crongMax == -1) // 올바르지 않은 페이지에 대한 예외처리
            return -1;

        if (pobiMax > crongMax)
            answer = 1;
        else if (pobiMax < crongMax)
            answer = 2;
        else
            answer = 0;
        return answer;
    }

    /**
     * DESCRIPTION
     *   대소비교를 원하는 page 번호가 들어있는 list를 전달받으면
     *   두 페이지 중 문제의 조건을 만족하는 page를 계산 후 반환
     *
     * Params
     *   pages - 대소비교를 원하는 page가 들어있는 list
     *
     * RETURN
     *   두 page 중 더 큰 값
     */
    public static int pageMaxValue(List<Integer> pages){

        int leftValue = pages.get(0); // 왼쪽 페이지 번호
        int rightValue = pages.get(1); // 오른쪽 페이지 번호

        if(rightValue <= leftValue || (rightValue -1) != leftValue)
            return -1;

        return Math.max(splitAndCalc(leftValue), splitAndCalc(rightValue));
    }

    /**
     * DESCRIPTION
     *   전달받은 page 번호를 자리 수 별로 분해 후,
     *   분해한 값들의 합, 곱을 계산하고
     *   합, 곱 중 큰 값을 반환
     *
     * Params
     *   pageNumber - 분해하고자 하는 page의 번호
     *
     * RETURN
     *   분해한 page 번호의 합, 곱 중 큰 값
     */
    public static int splitAndCalc(int pageNumber){

        List<Integer> numbers = new ArrayList<>(); // 전달받은 정수의 각 자리수를 저장
        int multiple = 1; // 곱한 값을 저장
        int sum = 0; // 더한 값을 저장

        // 1. 자리수 분해
        while(pageNumber > 0){
            numbers.add(pageNumber % 10);
            pageNumber/=10;
        }

        // 2. 각 자리 수를 곱하거나 더함
        for(int num : numbers){
            multiple *= num;
            sum += num;
        }

        // 3. (2)에서 구한 값 중 큰 값을 반환
        return Math.max(multiple, sum);
    }
}