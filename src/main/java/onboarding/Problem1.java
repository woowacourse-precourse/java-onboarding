package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 책을 임의로 펼친다.
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * -> 예외 사황
 *    1. 길이가 2가 아닌 경우
 *    2. 첫번째 혹은 마지막 페이지인 경우
 *    3. 왼쪽 , 왼쪽 + 1 이 아닌 경우
 *    4. 왼쪽이 홀수가 아닌 경우 , 오른쪽이 짝수가 아닌 경우
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!validation(pobi) || !validation(crong))
            answer = -1;
        else
            answer = decisionAnswer(maxValue(pobi), maxValue(crong));
        return answer;
    }


        /**
         *  요구 사항에 맞게 인자로 들어온 값을  비교하여 리턴한다
         */
        public static Integer decisionAnswer(Integer valueA , Integer valueB){
            if(valueA > valueB) return 1;
            else if(valueA < valueB) return 2;
            else return 0;
        }

        /**
         * 왼쪽 페이지 번호 , 오른쪽 페이지 번호의 계산된 값 중 큰 값을 리턴한다
         */
        public static Integer maxValue(List<Integer> values){
            Integer left = calculation((values.get(0)));
            Integer right = calculation((values.get(1)));
            return left > right ? left:right;
        }
        /**
         * Integer 값을 인자로 받는다.
         * Max(각 자리수의 모두 더한 값 ,각 자리수 모두 곱한 값)를 리턴한다
         */
        private static Integer calculation(Integer value){
            Integer resultSum = 0;
            Integer resultMulti = 1;
            String str = value.toString();
            for(int i = str.length() - 1;i >= 0;i--){
                int temp = str.charAt(i)  - '0';
                resultSum += temp;
                resultMulti *= temp;
            }
            return resultSum > resultMulti ? resultSum : resultMulti;
        }
        /**
         * 왼쪽 페이지 번호 , 오른쪽 페이지 번호를 인자로 받는다.
         * 예외 사항인 경우 false 를 리턴한다
         * 정상 입력인 경우 true 를 리턴한다.
         */
        public static boolean validation(List<Integer> values){
            if(values.size() != 2) return false;
            int leftValue = values.get(0);
            int rightValue = values.get(1);
            if(1  >  leftValue || leftValue > 400) return  false;
            if(1  >  rightValue || rightValue > 400) return  false;
            if(leftValue + 1 != rightValue) return false;
            if(leftValue % 2 == 0 || rightValue % 2 != 0) return false;
            return true;
        }

}