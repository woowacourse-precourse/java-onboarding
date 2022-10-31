package onboarding.p1;

import java.util.ArrayList;
import java.util.List;

public class Score {

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
