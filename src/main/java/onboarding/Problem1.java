package onboarding;

import java.util.List;

/**
 * 기능 요구사항
 * 1. 책을 임의로 펼친다
 *          -> 페이지 값이 주어지므로 구현 x
 * 2,3. 페이지 번호의 각자리 숫자를 모두 더하거나 , 모두 곱해 가장 큰 수를 구한다.
 *          -> 각자리 숫자 의 합,곱 을 구하는 메서드 구현
 * 4. 2,3 과정에서 가장 큰 수를 본인의 점수로 한다.
 *          -> 둘중 큰 값을 찾아내는 로직 구현
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 *          -> 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0 , 예외사항은 -1 을 반환 하도록 구현
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *          -> 유의미한 입력 값을 확인 해야한다.
 *
 * 문제 분석
 * 1. 1~400 페이지의 책을 사용한다는 조건과 기능 요구사항 1,6번 그리고 제한사항을 근거로
 *      - 모든 값이 1~400 이 되는지 확인
 *      - 왼쪽값이 홀수인지, 오른쪽 값이 항상 왼쪽값+1 이 되는지 확인 절차 를 거쳐야한다(메서드 구현).
 *    즉, 왼쪽이 1~399 사이의 홀수 값인지 확인후 오른쪽 값이 왼쪽값 +1 이 되는지 확인하고 아니라면 -1 반환
 *
 * 2. 값의 확인절차 후 기능 요구사항 2,3 번을 수행할 각자리 숫자의 합, 곱중 가장 큰값 을 반환하는 메서드를  구현 하고,
 *      기능 요구사항 4번을 수행할 가장 큰값을 찾는 메서드를 구현한다.
 *      즉, solution() -> 값의 확인절차
 *                     -> 각자리 숫자의 합,곱중 가장 큰값()
 *                     -> 가장 큰 값 찾기()
 *                     의 순서로 로직을 수행한다.
 *                     
 * 3. 포비, 크롱 의 가장 큰값을 비교하여 기능요구사항 5번에 부합하는 값을 반환한다.
 *
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer ;
        if (!isCorrectValue(pobi) || !isCorrectValue(crong)) {
            return -1;
        }

        int pobiPoint = getMaxFromList(pobi);
        int crongPoint =getMaxFromList(crong);

        answer = pobiPoint > crongPoint ? 1 : (pobiPoint < crongPoint ? 2 : 0);
        return answer;
    }
    static boolean isCorrectValue(List<Integer> input){
        int leftValue = input.get(0);
        int rightValue = input.get(1);
        if (leftValue <= 399 && leftValue % 2 == 1 && rightValue == leftValue + 1) {
            return true;
        }else{
            return false;
        }
    }
    static int getMaxFromSumAndMultiple(int num){
        int sum = 0;
        int multi = 1;
        while (num > 0) {
            sum += num % 10;
            multi *= num % 10;
            num /= 10;
        }
        return Math.max(sum,multi);
    }

    static int getMaxFromList(List<Integer> input) {
        int result=-1;
        for (int i : input) {
            result = Math.max(result,getMaxFromSumAndMultiple(i));
        }
        return result;
    }

}