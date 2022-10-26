package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int pobiScore = getPageNumGameScore(pobi.get(0), pobi.get(1));
            int crongScore = getPageNumGameScore(crong.get(0), crong.get(1));
            return getAnswer(pobiScore, crongScore);
        } catch (Exception e) {
            return -1;
        }
    }

    private static int getPageNumGameScore(Integer leftPageNum, Integer rightPageNum) throws Exception {
        if(!isValidPageNum(leftPageNum, rightPageNum)) throw new Exception("유효한 페이지 번호가 아닙니다.");

        int maxScoreOfLeftPageNum = getMaxScore(leftPageNum);
        int maxScoreOfRightPageNum = getMaxScore(rightPageNum);
        return (maxScoreOfLeftPageNum > maxScoreOfRightPageNum) ? maxScoreOfLeftPageNum : maxScoreOfRightPageNum;
    }

    private static boolean isValidPageNum(Integer leftPageNum, Integer rightPageNum) {
        return (leftPageNum % 2 == 1) && (rightPageNum % 2 == 0) && (leftPageNum + 1 == rightPageNum);
    }

    private static int getMaxScore(Integer pageNum) {
        int plusScore = 0, multiplyScore = 1;

        while (pageNum > 0) {
            plusScore += pageNum % 10;
            multiplyScore *= pageNum % 10;
            pageNum /= 10;
        }

        return (plusScore > multiplyScore) ? plusScore : multiplyScore;
    }

    private static int getAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }
}