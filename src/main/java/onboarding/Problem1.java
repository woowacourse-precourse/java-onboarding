package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int scorePobi;
        int scoreCrong;
        List<Integer> scoresListPobi;
        List<Integer> scoresListCrong;

        Integer x = checkCorrectPage(pobi, crong);
        if (x != null){
            return x;
        }

        scoresListPobi = getScoresList(pobi);
        scoresListCrong = getScoresList(crong);

        scorePobi = getMaxScore(scoresListPobi);
        scoreCrong = getMaxScore(scoresListCrong);

        if (scorePobi > scoreCrong) {
            answer = 1;
        } else if (scorePobi < scoreCrong) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static Integer checkCorrectPage(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) + 1 != pobi.get(1)) {
            return -1;
        } else if (crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }
        return null;
    }

    private static List<Integer> getScoresList(List<Integer> pages) {
        List<Integer> scoresList = new ArrayList<>();

        for (int page : pages) {
            int scoreAdd = 0;
            int scoreMul = 1;
            String strPage = Integer.toString(page);
            int[] arrPageNum = new int[strPage.length()];

            for (int i = 0; i < strPage.length(); i++) {
                arrPageNum[i] = strPage.charAt(i) - '0';
                scoreAdd = scoreAdd + arrPageNum[i];
                scoreMul = scoreMul * arrPageNum[i];
            }

            scoresList.add(scoreAdd);
            scoresList.add(scoreMul);
        }

        return scoresList;
    }

    private static int getMaxScore(List<Integer> scores) {
        int maxScore;

        scores.sort(Comparator.reverseOrder());
        maxScore = scores.get(0);

        return maxScore;
    }


}