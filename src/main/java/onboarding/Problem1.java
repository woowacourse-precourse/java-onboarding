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

        if (!pobi_vali.IsVali() || !crong_vali.IsVali())
            return EXCEPTION; // 예외사항 처리

        else {
                return DRAW; // 기능 단위 커밋을 위해 임시로 return값 지정
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


}