package onboarding;

import java.util.List;

class Player {
    private int maxNum;
    private int leftPageNum, rightPageNum;

    public void calMaxNum() {// 양쪽 페이지 모두 합쳐 가장 큰 수 구해서 max_num에 저장
        int leftPageMaxNum, rightPageMaxNum;
        int sumNum, mulNum;

        sumNum = sumEachNum(this.leftPageNum);
        mulNum = mulEachNum(this.leftPageNum);
        leftPageMaxNum = Math.max(sumNum, mulNum);

        sumNum = sumEachNum(this.rightPageNum);
        mulNum = mulEachNum(this.rightPageNum);
        rightPageMaxNum = Math.max(sumNum, mulNum);

        this.maxNum = Math.max(leftPageMaxNum, rightPageMaxNum);
    }

    protected int sumEachNum(int num) {// 정수의 각 자리수를 더함
        int sum;// 각 자리수의 합을 저장할 변수
        sum = 0;
        while (num > 0) {// 반복
            sum = sum + (num % 10); // 맨 뒷자리 하나씩을 더함
            num /= 10; //맨 뒷자리를 없애줌
        }
        return sum;
    }

    protected int mulEachNum(int num) {// 정수의 각 자리수를 곱함
        int mul;
        mul = 1;
        while (num > 0) {// 반복
            mul = mul * (num % 10); // 일의 자리를 기존 곱한 결과에 곱한값을 저장
            num /= 10; //맨 뒷자리를 없애줌
        }
        return mul;
    }

    public void setLeftPageNum(int leftPageNum) {
        this.leftPageNum = leftPageNum;
    }

    public void setRightPageNum(int rightPageNum) {
        this.rightPageNum = rightPageNum;
    }

    public int getMaxNum() {
        return maxNum;
    }
}

class PageException extends RuntimeException {
}

class Game{
    public int playGame(List<Integer> player1Page, List<Integer> player2Page) {
        int result;
        try {
            // 입력받은 page 번호가 적절한지 검사
            pageException(player1Page);
            pageException(player2Page);

            onboarding.Player player1 = new onboarding.Player();
            onboarding.Player player2 = new onboarding.Player();

            player1.setLeftPageNum(player1Page.get(0));
            player1.setRightPageNum(player1Page.get(1));
            player2.setLeftPageNum(player2Page.get(0));
            player2.setRightPageNum(player2Page.get(1));

            player1.calMaxNum();// max값 계산해 저장
            player2.calMaxNum();
            result = winner(player1, player2);
            return result;
        } catch (onboarding.PageException e) {
            return -1;
        }
    }

    private int winner(onboarding.Player player1, onboarding.Player player2) {// 두 플레이어중 승자 여부에 따른 값을 반환
        if (player1.getMaxNum() > player2.getMaxNum()) {
            return 1;
        } else if (player1.getMaxNum() < player2.getMaxNum()) {
            return 2;
        } else if (player1.getMaxNum() == player2.getMaxNum()) {
            return 0;
        } else {
            return -1;
        }
    }

    private void pageException(List<Integer> playerPage) {// 입력받은 왼쪽, 오른쪽페이지의 번호가 적절한지 검증
        int left, right;
        left = playerPage.get(0);
        right = playerPage.get(1);
        if ((right - left) != 1) { // 오른족 페이지가 왼쪽페이지보다 1큰 경우가 아니면 예외
            throw new onboarding.PageException();
        }
        if (left % 2 == 0) {// 왼쪽페이지가 짝수인 경우
            throw new onboarding.PageException();
        }
        if (right % 2 != 0) {// 오른쪽페이지가 홀수인 경우
            throw new onboarding.PageException();
        }
        if (!(1 < left && left < right && right < 400)) {//페이지가 2~399사이가 아닌경우 (시작,마지막 면은 펼치지 않기 때문에 2~399)
            throw new onboarding.PageException();
        }
    }
}
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Game game = new Game();
        int answer = game.playGame(pobi, crong);
        return answer;
    }
    //game 에서 player 마다 값 넣어줌
    // game 에서 값 넣어주기 전에 예외처리 검사

}