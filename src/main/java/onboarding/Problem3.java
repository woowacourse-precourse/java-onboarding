package onboarding;

public class Problem3 {

    public static class GameNumber {
        private int number;
        private final static char THREE = '3';
        private final static char SIX = '6';
        private final static char NINE = '9';
        private int count = 0;

        public GameNumber(int number) {
            validNumber(number);
            this.number = number;
        }

        private void validNumber(int number) {
            if (!(number >= 1) && !(number <= 10000)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        public int getClapCount() {
            String appendNumber = appendNumber(number);
            for (int i = 0; i < appendNumber.length(); i++) {
                if (appendNumber.charAt(i) == THREE || appendNumber.charAt(i) == SIX || appendNumber.charAt(i) == NINE) {
                    count++;
                }
            }
            return count;
        }
        public String appendNumber(int number) {
            String result = "";
            for (int i = 1; i <= number; i++) {
                result = result + i;
            }
            return result;
        }
    }
    public static int solution(int number) {
        return new GameNumber(number).getClapCount();
    }
}
