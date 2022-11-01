/*
자바 클린 코드 규칙
- 한 메서드에 오직 한 단계의 들여쓰기만 허용했는가?
- else 예약어를 쓰지 않았는가?
- 모든 원시값과 문자열을 포장했는가?
- 콜렉션에 대해 일급 콜렉션을 적용했는가?
- 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- getter/setter 없이 구현했는가?
- 메소드의 인자 수를 제한했는가 (4개 이상의 인자 X, 3개도 가능하면 줄이기)
- 코드 한 줄에 점(.)을 하나만 허용했는가?
- 메소드가 한가지 일만 담당하도록 구현했는가?
- 클래스를 작게 유지하기 위해 노력했는가?
 */

package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = result(pobi, crong);
        return answer;
    }

    public static boolean validation(List<Integer> pages) { // 유효성 검사
        if ((pages.get(0) == 1) || (pages.get(1) == 400)) return false; // 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다
        if (pages.size() != 2) return false; // 펼친 페이지가 들어있는 리스트는 원소가 2개여야 함
        if ((pages.get(0) % 2 == 0) || (pages.get(1) % 2 == 1)) return false; // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수

        return (pages.get(0) + 1 == pages.get(1)); // 왼쪽 페이지 + 1 = 오른쪽 페이지
    }

    public static int maxNum(int page){ // 페이지의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수 구하기
        if ((page >= 1) && (page <= 9)) { // 페이지가 한 자리 수일 때
            return page;
        }
        if ((page >= 10) && (page <= 99)) { // 페이지가 두 자리 수일 때
            int plus = (page / 10) + (page % 10);
            int multi = (page / 10) * (page % 10);

            return Math.max(plus, multi);
        }
        if ((page >= 100) && (page <= 400)) { // 페이지가 세 자리 수일 때
            int plus = (page/ 100) + ((page % 100) / 10) + (page % 10);
            int multi = (page/ 100) * ((page % 100) / 10) * (page % 10);

            return Math.max(plus, multi);
        }
        throw new IllegalArgumentException();
    }
    public static int score(List<Integer> player) { // 왼쪽 페이지로 구한 수와 오른쪽 페이지로 구한 수 중 큰 수가 본인의 점수
        int left = maxNum(player.get(0));
        int right = maxNum(player.get(1));
        return Math.max(left, right);
    }
    public static int winner(List<Integer> player1, List<Integer> player2) { // player1 과 player2 중 점수가 높은 사람이 승자
        int player1Score = score(player1);
        int player2Score = score(player2);

        if (player1Score > player2Score) return 1;
        if (player1Score < player2Score) return 2;

        return 0;
    }
    public static int result(List<Integer> player1, List<Integer> player2) {
        if (validation(player1) && validation(player2)) {
            return winner(player1, player2);
        }
        return -1;  // 예외 사항은 -1 리턴
    }
}