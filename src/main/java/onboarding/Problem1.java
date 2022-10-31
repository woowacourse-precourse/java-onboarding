package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pages pobiPages;
        Pages crongPages;
        try {
            pobiPages = new Pages(pobi);
            crongPages = new Pages(crong);
        } catch (Exception e) {
            //e.printStackTrace();
            return -1;
        }

        // 책 펼쳐서 점수 얻기
        int pobiScore = getScore(pobiPages);
        int crongScore = getScore(crongPages);

        return getResult(pobiScore, crongScore);
    }

    // 각 플레이어의 점수를 가져오는 메소드
    private static int getScore(Pages pages) {
        Score score = new Score(pages);
        return score.getMaxScore();
    }

    private static int getResult(int pobiScore, int crongScore) {
        // 점수 비교
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

}


class Pages {

    private final List<Integer> pageList;

    public Pages(List<Integer> list) {
        validateLength(list);
        validateStartEnd(list);
        validateContinuity(list);
        this.pageList = list;
    }

    private void validateLength(List<Integer> list) {
        int length = list.size();
        if (length != 2) {
            throw new IllegalArgumentException("페이지 수는 2개여야 합니다.");
        }
    }

    private void validateStartEnd(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        if (left <= 1) {
            throw new IllegalArgumentException("첫 페이지는 펼 수 없습니다.");
        }
        if (right >= 400) {
            throw new IllegalArgumentException("마지막 페이지는 펼 수 없습니다.");
        }
    }

    private void validateContinuity(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        if (left != right - 1) {
            throw new IllegalArgumentException("책에는 연속된 페이지만 있을 수 있습니다.");
        }
    }

    public int findPage(int left_right) {
        return this.pageList
                .get(left_right);
    }

}


class Score {

    private final int score;

    public Score(Pages pages) {
        int maxScore = 0;
        for (int i = 0; i < 2; i++) {
            List<Integer> nums = getNum(pages.findPage(i));
            int plusScore = plus(nums);
            if (plusScore > maxScore) {
                maxScore = plusScore;
            }
            int multipleScore = multiple(nums);
            if (multipleScore > maxScore) {
                maxScore = multipleScore;
            }
        }
        this.score = maxScore;
    }

    //더하기
    private int plus(List<Integer> nums) {
        int score = 0;
        for (Integer num : nums) {
            score += num;
        }
        return score;
    }

    //곱하기
    public int multiple(List<Integer> nums) {
        int score = 1;
        for (Integer num : nums) {
            score *= num;
        }
        return score;
    }

    // 자리수 나누는 메소드
    private List<Integer> getNum (int page) {
        int n;
        List<Integer> nums = new ArrayList<>();
        while (page > 0) {
            n = page % 10;
            page /= 10;
            nums.add(n);
        }
        return nums;
    }

    public int getMaxScore() {
        return this.score;
    }
}
