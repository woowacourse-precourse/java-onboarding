package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            Pages pobiPages = new Pages(pobi);
            Pages crongPages = new Pages(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }

        return answer;
    }

    public static class Pages {
        private static final int LEFT_INDEX = 0;
        private static final int RIGHT_INDEX = 1;

        private int leftNumber;
        private int rightNumber;

        private void validate(List<Integer> indexes) throws IllegalArgumentException {
            hasNullValue(indexes);
            int leftNo = indexes.get(LEFT_INDEX);
            int rightNo = indexes.get(RIGHT_INDEX);

            isContinuousNumbers(leftNo, rightNo);
            isInProperRange(leftNo, rightNo);
        }

        private void hasNullValue(List<Integer> indexes) {
            for (Integer idx : indexes) {
                if(idx == null){
                    throw new IllegalArgumentException();
                }
            }
        }

        private void isContinuousNumbers(int leftNumber, int rightNumber) {
            if (rightNumber - leftNumber != 1)
                throw new IllegalArgumentException();
        }

        private void isInProperRange(int leftNumber, int rightNumber) {
            if (1 < leftNumber && leftNumber < rightNumber && rightNumber < 400) {
                return;
            }
            throw new IllegalArgumentException();
        }

        public Pages(List<Integer> indexes) {
            validate(indexes);
            this.leftNumber = indexes.get(LEFT_INDEX);
            this.rightNumber = indexes.get(RIGHT_INDEX);
        }


    }

}