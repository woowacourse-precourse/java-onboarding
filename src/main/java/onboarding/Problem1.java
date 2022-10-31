package onboarding;

import java.util.List;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION_CASE = -1;

    /**
     * 좌,우측 페이지가 올바른 페이지 인지 확인하는 함수
     * @param pages 좌, 우 페이지 번호가 적힌 리스트
     * @return 유효한 페이지인지 검사값 (true/false)
     */
    public static boolean checkPage(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage + 1 != rightPage) {
            return false;
        }
        if(leftPage%2 !=1 || rightPage%2!=0){
            return false;
        }
        if (leftPage==1 || rightPage == 400){
            return false;
        }
        return true;
    }

    /**
     * 규칙에 따라 구할 수 있는 가장 큰 값을 구하는 함수
     * @param num : 페이지 번호
     * @return 페이지 번호로 부터 구할 수 있는 가장 큰 수
     */
    public static int pageMaxNum(int num) {
        int add_result = 0;
        int max_result = 1;
        while (num != 0) {
            add_result += num % 10;
            max_result *= num % 10;
            num /= 10;
        }
        return Math.max(add_result, max_result);
    }

    /**
     * 게임의 승자를 확인하는 함수
     * @param pobiMaxNum : 포비가 가진 가장 큰 값
     * @param crongMaxNum : 크롱이 가진 가장 큰값
     * @return : 게임 결과
     */
    public static int checkWinner(int pobiMaxNum, int crongMaxNum){
        if (pobiMaxNum > crongMaxNum) {
            return POBI_WIN;
        }
        if (pobiMaxNum == crongMaxNum) {
            return DRAW;
        }
        if (pobiMaxNum < crongMaxNum) {
            return CRONG_WIN;
        }
        return EXCEPTION_CASE;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(checkPage(pobi) && checkPage(crong))) {
            return -1;
        }
        int pobiMaxNum = Math.max(pageMaxNum(pobi.get(0)), pageMaxNum(pobi.get(1)));
        int crongMaxNum = Math.max(pageMaxNum(crong.get(0)), pageMaxNum(crong.get(1)));

        answer = checkWinner(pobiMaxNum, crongMaxNum);
        return answer;
    }
}

