package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return whoIsWinner(pobi, crong);
    }

    static int whoIsWinner(List<Integer> pobi, List<Integer> crong) {
        IsValiPage pobi_vali = new IsValiPage(pobi);
        IsValiPage crong_vali = new IsValiPage(crong);
        PlayerScore pobi_score = new PlayerScore(pobi);
        PlayerScore crong_score = new PlayerScore(crong);

        if (!pobi_vali.IsVali() || !crong_vali.IsVali())
            return EXCEPTION; // 예외사항 처리

        else {
            int pobi_max_score = pobi_score.maxScore();
            int crong_max_score = crong_score.maxScore();

            if (pobi_max_score > crong_max_score)
                return WIN_POBI;
            else if (crong_max_score > pobi_max_score)
                return WIN_CRONG;
            else
                return DRAW;
        }
    }

    private static class IsValiPage {
        private int leftpage;
        private int rightpage;

        public IsValiPage(List<Integer> player) {
            this.leftpage = player.get(0);
            this.rightpage = player.get(1);
        }

        public boolean IsVali() {
            return validPageRange() && validPageOddEven() && validPageSection();
        }

        public boolean validPageRange() {
            int min_page = 1;
            int max_page = 400;

            return (leftpage > min_page && leftpage < max_page) && (rightpage > min_page && rightpage < max_page);
        }

        public boolean validPageOddEven() {
            return leftpage % 2 != 0 && rightpage % 2 == 0;
        }

        public boolean validPageSection() {
            return rightpage == leftpage + 1;
        }
    }

    private static class PlayerScore {
        private int leftpage;
        private int rightpage;

        public PlayerScore(List<Integer> player) {
            this.leftpage = player.get(0);
            this.rightpage = player.get(1);
        }

        public int maxScore() {
            int sum_score = Math.max(sumPage(leftpage), mulPage(leftpage));
            int mul_score = Math.max(sumPage(rightpage), mulPage(rightpage));
            return Math.max(sum_score, mul_score); // 플레이어의 최고 점수 반환
        }

        public int sumPage(int page) {
            int sum = 0;
            while (page != 0) {
                sum += (page % 10);
                page /= 10;
            }
            return sum;
        }

        public int mulPage(int page) {
            int mul = 1;
            while (page != 0) {
                mul *= (page % 10);
                page /= 10;
            }
            return mul;
        }
    }
}