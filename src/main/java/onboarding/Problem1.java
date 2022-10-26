package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {

    /**
     * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * @Method: Solution
     * 점수를 비교하여, 알맞은 값을 return한다.
     * TODO: 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0을 return 한다.
     */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 1. 책을 임의로 펼친다.
     * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
     * @Method: checkPageException
     * 페이지 자체에 에러가 존재하는지 확인한다.
     */
    private static boolean checkPageException(List<Integer> pages) {
        int left = pages.get(0);
        // 왼쪽 페이지가 3 ~ 397 사이의 값인지 확인
        if(3 <= left && left <= 397) {
            int right = pages.get(1);
            // 왼쪽 페이지 + 1이 오른쪽 페이지가 맞는지 확인
            if (left + 1 == right) {
                // 왼쪽 페이지가 홀수가 맞는지 확인
                return left % 2 == 1;
            }
        }
        // 예외사항은 -1을 return
        return false;
    }

    /**
     * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     * @Method: calcPoint
     * 본인의 점수를 구한다. (2~3번 과정을 단계별로 method로 만든다.)
     * TODO: 가장 큰 수를 return 한다.
     */


    /**
     * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     */

    /**
     * @Method: digitPage
     * 페이지 번호를 자릿수 별로 나눈다.
     */
    private static List<Integer> digitPage(Integer num) {
        List<Integer> digits = new ArrayList<>();
        // 각 페이지 번호를 받아 자릿수 별로 나눈다.
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        // List 형태로 return
        return digits;
    }

    /**
     * @Method: addDigit
     * 각 자릿수를 기반으로 더한 값을 구한다.
     */
    private static int addDigit(List<Integer> digits) {
        int answer = 0;
        // 각 자릿수를 더한다.
        for(Integer digit : digits) {
            answer += digit;
        }
        return answer;
    }


    /**
     * @Method: mutiplyDigit
     * 각 자릿수를 기반으로 곱한값을 구한다.
     * TODO: 각 자릿수를 곱한다.
     */
}

