package onboarding;

import java.util.Arrays;
import java.util.List;
/*
* 1. 페이지 넘버 값을 필드로 가지는 Page 클래스 생성
* 2. 왼쪽 페이지와 오른쪽 페이지를 필드로 가지는 Gamer 클래스 생성
* 3. Page class methods
*   3-1. Page(int num): 페이지 값을 파라미터로 받는 생성자 메소드
*   3-2. getScore(): 페이지의 최대 점수를 얻는 메소드
* 4. Gamer class methods
*   4-1. Gamer(int left, int right): 왼쪽 페이지와 오른쪽 페이지를 파라미터로 받는 생성자 메소드
*   4-2. getMaxScore(): Gamer 의 최대 점수를 얻는 메소드
*   4-3. getWinner(Gamer opponent): 다른 게이머의 최대 점수와 비교해 승패 결과를 int 값으로 얻는 메소드
* ※ 예외처리
*   1. 페이지의 범위가 1 ~ 400 인지 검사
*   2. 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 검사
*   3. 연속된 페이지 인지 검사
*/

class Page {
    private int num;
    private int score;

    public Page(int num) {
        this.num = num;
        this.score = 0;
    }

    public int getScore() {
        // 최초 1번 score 를 저장하고 추후에는 저장된 score 를 리턴
        if (score != 0)
            return score;

        int[] nums = Arrays.stream(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(nums).sum();
        int mul = Arrays.stream(nums).reduce(1,(a, b) -> a * b );

        score = Math.max(sum, mul);

        return score;
    }
}

class Gamer {
    private Page left;
    private Page right;

    public Gamer(int leftNum, int rightNum) {
        this.left = new Page(leftNum);
        this.right = new Page(rightNum);
    }

    public int getMaxScore() {
        return Math.max(left.getScore(), right.getScore());
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}