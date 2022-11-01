package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * Class : Problem 1
 *
 * Date : 2022.10.29
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. 책을 임의로 펼친다.
 * 2. 각자의 패를 선택하기 위한 클래스를 만든다.
 * 3. 왼쪽 페이지 번호의 각 자리 숫자를 구한다.
 * 4. 각 자리 수를 모두 더하는 함수를 만든다.
 * 5. 각 자리 수를 모두 곱하는 함수를 만든다.
 * 6. 왼쪽 페이지 번호의 각 자리 숫자를 더한 값을 저장한다.
 * 7. 왼쪽 페이지 번호의 각 자리 숫자를 곱한 값을 저장한다.
 * 8. 오른쪽 페이지도 3~5번을 수행한다.
 * 9. 4~6번으로 저장된 4개의 값 중 가장 큰 수를 본인의 점수로 한다.
 * 10. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 11. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * 12. 책의 페이지 번호는 연속적인 수이며 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수만 가능하다.
 *
 * */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // pobi's card
        Card pobiCard = new Card();
        Integer pobiTurn = pobiCard.selectCard(pobi);

        // crong's card
        Card crongCard = new Card();
        Integer crongTrun = crongCard.selectCard(crong);

        // compare the scores and choose the winner
        if (pobiTurn == -1 || crongTrun == -1) {
            answer = -1;
        }
        else if (pobiTurn > crongTrun) {
            answer = 1;
        }
        else if (pobiTurn < crongTrun) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }
}

// make card class
class Card {
    List<Integer> getMax = new ArrayList<>();
    Integer selectCard(List<Integer> player) {
        // to check an exception to a page that is invalid or cannot be opened.
        if ((player.get(0) % 2) == 0 || (player.get(1) % 2) != 0 || (player.get(1) - player.get(0)) > 1
                || player.get(0) == 1 || player.get(1) == 400){
            return -1;
        }

        else {
            // to get player's left and right pages
            for (int i = 0; i < 2; i++) {
                // divide the number by each digit
                List<Integer> digits = new ArrayList<>();
                Integer getPage = player.get(i);
                while (getPage > 0) {
                    digits.add(getPage % 10);
                    getPage = getPage / 10;
                }
                // sum each number and add put it in the max list
                getMax.add(sumDigits(digits));
                // multiply each number and put it in the max list
                getMax.add(multiplicationDigits(digits));
                digits.clear();
            }
            return getMax.stream().max(Integer::compare).orElse(-1);
        }
    }

    // function to find the sum of each number
    Integer sumDigits(List<Integer> card) {
        Integer sum = 0;
        for (int i = 0; i < card.size(); i++) {
            sum += card.get(i);
        }
        return sum;
    }

    // function to find the multiplication of each number
    Integer multiplicationDigits(List<Integer> card) {
        Integer multiplication = 1;
        for (int i = 0; i < card.size(); i++) {
            multiplication *= card.get(i);
        }
        return multiplication;
    }

}
