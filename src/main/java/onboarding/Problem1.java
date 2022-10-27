package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Pages pobiPages = new Pages(pobi);
        Pages crongPages = new Pages(crong);

        return answer;
    }

    public static class Pages {
        private static final int LEFT_INDEX = 0;
        private static final int RIGHT_INDEX = 1;

        private int leftNumber;
        private int rightNumber;

        public Pages(List<Integer> indexes) {
            this.leftNumber=indexes.get(LEFT_INDEX);
            this.rightNumber=indexes.get(RIGHT_INDEX);
        }


    }

}