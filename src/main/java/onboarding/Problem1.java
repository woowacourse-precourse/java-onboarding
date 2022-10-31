package onboarding;

import onboarding.p1.Pages;
import onboarding.p1.Score;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pobiPages;
        Pages crongPages;
        try {
            pobiPages = new Pages(pobi);
            crongPages = new Pages(crong);
        } catch (Exception e) {
            return -1;
        }

        // 책 펼쳐서 점수 얻기
        int pobiScore = getScore(pobiPages);
        int crongScore = getScore(crongPages);

        // 점수 비교
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        if(pobiScore == crongScore) {
            return 0;
        }
        return -1;
    }

    // 각 플레이어의 점수를 가져오는 메소드
    public static int getScore(Pages pages) {
        Score score = new Score(pages);
        return score.getMaxScore();
    }

}

