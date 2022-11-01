package onboarding;

import java.util.List;

class Problem1 {

    static int getMaxNumber(int pageNum){
        int sum = 0, product = 1;   // 페이지 번호의 자릿수를 모두 더한 값, 곱한 값 변수
        String strPageNum = Integer.toString(pageNum);

        // 페이지 번호의 각 자리 숫자를 더한 값, 곱한 값을 연산
        for (int i = 0; i < strPageNum.length(); i++){
            sum += strPageNum.charAt(i) - '0';
            product *= strPageNum.charAt(i) - '0';
        }
        // 모두 더한 값과 곱한 값 중 더 큰 수를 반환
        return Math.max(sum, product);
    }

    // 만약 책에 인쇄오류가 있다면 -> 예외상황 발생, 최대한 처리해주기
    static boolean exceptionHandler(List<Integer> player1, List<Integer> player2){
        // 페이지가 2-399의 범위를 벗어남 (첫 페이지는 펼치지 않으므로 -> (1,2), (399, 400)은 제외 )
        if ((player1.get(0) < 3 || player1.get(0) > 397)
                || (player2.get(0) < 3 || player2.get(0) > 397)
                || (player1.get(1) < 4 || player1.get(1) > 398)
                || (player2.get(1) < 4 || player2.get(1) > 398))
            return true;
        // 페이지가 순차적으로 구성되어 있지 않는 예외
        else if (player1.get(0) + 1 != player1.get(1) || player2.get(0) + 1 != player2.get(1))
            return true;
        // 왼쪽 페이지가 짝수 또는 오른쪽 페이지가 홀수일 경우의 예외
        else if (player1.get(0) % 2 == 0 || player2.get(0) % 2 == 0
                || player1.get(1) % 2 != 0 || player1.get(1) % 2 != 0)
            return true;
        // 아무런 예외가 없을 경우
        else
            return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int scorePobi, scoreCrong;

        // 예외사항 처리
        if (exceptionHandler(pobi, crong))
            return -1;

        // 왼쪽 페이지와 오른쪽 페이지를 비교하여 더 큰 수를 본인의 점수로 가진다
        scorePobi = Math.max(getMaxNumber(pobi.get(0)), getMaxNumber(pobi.get(1)));
        scoreCrong = Math.max(getMaxNumber(crong.get(0)), getMaxNumber(crong.get(1)));

        if (scoreCrong > scorePobi)
            return 2;
        else if (scorePobi > scoreCrong)
            return 1;
        else
            return 0;
    }
}