package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int SAME_SCORE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageNum(pobi) || !validatePageNum(crong)) return -1;

        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);

        return compareScore(pobiScore, crongScore);
    }

    private static Boolean validatePageNum(List<Integer> pageList) {
        int page = pageList.get(0);
        if (page < 1 || page > 399) return false; // 페이지 범위 체크 (왼쪽 페이지 유효 범위 : 1 ~ 399)
        if (pageList.get(1) != page + 1) return false; // 왼쪽 페이지와 오른쪽 페이지의 번호 차이가 1이 아닐 경우
        if (page % 2 != 1) return false; // 짝,홀 체크
        return true;
    }

    private static int getMaxScore(List<Integer> pageList) {
        ArrayList<Integer> scoreList = new ArrayList<>();
        calculateScore(Integer.toString(pageList.get(0)), scoreList);
        calculateScore(Integer.toString(pageList.get(1)), scoreList);
        return Collections.max(scoreList);
    }

    private static void calculateScore(String pageStr, ArrayList<Integer> scoreList) {
        int sum = 0;
        int multi = 1;
        for (int i = 0; i < pageStr.length(); i++) {
            int num = Integer.parseInt(pageStr.substring(i, i + 1));
            sum += num;
            multi *= num;
        }
        scoreList.add(sum);
        scoreList.add(multi);
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return POBI_WIN;
        else if (pobiScore < crongScore) return CRONG_WIN;
        else return SAME_SCORE;
    }

}