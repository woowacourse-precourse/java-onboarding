package onboarding.p1;

import java.util.List;

public class Judge {
    PageHandler pageHandler;
    List<Integer> pobi;
    List<Integer> crong;

    public Judge(List<Integer> pobi, List<Integer> crong) {
        this.pobi = pobi;
        this.crong = crong;
        this.pageHandler = new PageHandler();
    }

    /*
     * 예외 처리
     * 조건 1. - List size 가 2가 아닐 경우
     * 조건 2. - 연속된 값이 아니거나 오른쪽 페이지 값이 더 작은 경우
     * 조건 3. - 왼쪽 페이지가 홀수가 아니거나 오른쪽 페이지가 짝수가 아닐 때
     * 조건 4. - 시작 면이나 마지막 면이 포함되어 있으면 안됨
     * */
    private boolean isException() {
        boolean exceptionFlag = false;
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobi.size() != 2 || crong.size() != 2 ) {
            exceptionFlag = true;
        } else if (pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1) {
            exceptionFlag = true;
        } else if ((pobiLeft + crongLeft) % 2 != 0 || pobiLeft % 2 == 0) {
            exceptionFlag = true;
        } else if (pobiLeft == 1 || crongLeft == 1 || pobiRight == 400 || crongRight == 400) {
            exceptionFlag = true;
        }
        return exceptionFlag;
    }

    // 승부를 판별하여 int 값을 리턴
    public int getAnswer() {
        if (isException()) return -1;
        int answer;
        int pobiScore = pageHandler.getScore(pobi);
        int crongScore = pageHandler.getScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (crongScore > pobiScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}
