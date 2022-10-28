package onboarding;

import java.util.List;

class Player {
    private int maxNum;
    private int leftPageNum, rightPageNum;

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

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    //game 에서 player 마다 값 넣어줌
    // game 에서 값 넣어주기 전에 예외처리 검사

}