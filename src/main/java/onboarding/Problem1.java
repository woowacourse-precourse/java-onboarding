package onboarding;

import java.util.*;

class Problem1 {
    public static int pageSum(int page) {
        int res = (int)(page/100) + (int)(page/10) + ((page%100)%10);
        return res;
    }
    public static int pageMul(int page) {
        int res = (int)(page/100) * (int)(page/10) * ((page%100)%10);
        return res;
    }
    public static int setScore(int score1, int score2) {
        int res = score1 >= score2 ? score1 : score2;
        return res;
    }
    public static int setError(int page1, int page2) {
        if(page1 - page2 != 1) { return -1; }
        else if(page1 > 400 || page2 > 400) { return -1; }
        else if(page1 < 1 || page2 < 1) { return -1; }
        else if(page1 == page2) { return -1; }
        else if(page1 % 2 == 0) { return -1; }
        else if(page2 % 2 == 1) { return -1; }
        else { return 0;}
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int error = 0;
        // 포비 왼쪽 오른쪽 페이지 저장
        int p_left = pobi.get(0);
        int p_right = pobi.get(1);

        // 크롱 왼쪽 오른쪽 페이지 저장
        int c_left = crong.get(0);
        int c_right = crong.get(1);

        // 예외 처리
        error = setError(p_left, p_right);
        if (error == -1) { return error; }
        error = setError(c_left,c_right);
        if (error == -1) { return error; }

        // 포비 점수 구하기
        int pSum = pageSum(p_left);
        int pMul = pageMul(p_left);
        int pScore = setScore(pSum, pMul);

        // 크롱 점수 구하기
        int cSum = pageSum(c_left);
        int cMul = pageMul(c_left);
        int cScore = setScore(cSum, cMul);

        // 결과 처리
        if (pScore == cScore) { return 0; }
        else if (pScore > cScore) { return 1; }
        else { return 2; }
    }
}