package onboarding;

public class Problem3 {
    static final int MAX_SIZE = 10001;

    static class ClapCount {
        private int[] count = new int[MAX_SIZE];
        private int target;

        public ClapCount(int target) {
            this.target = target;
        }

        int getResult() {
            calculate();
            return count[target];
        }

        private void calculate() {
            for(int i=1 ; i<=target ; i++) {
                count[i] = count[i - 1] + countThreeSixNineFrom(i);
            }
        }


        private int countThreeSixNineFrom(int num) {
            int cnt = 0;
            String tmp = String.valueOf(num);

            for(int i=0 ; i<tmp.length() ; i++) {
                char c = tmp.charAt(i);
                cnt += (isThreeSixNine(c)) ? 1 : 0;
            }
            return cnt;
        }

        private boolean isThreeSixNine(char c) {
            return c == '3' || c == '6' || c == '9';
        }

    }


    public static int solution(int number) {
        ClapCount cc = new ClapCount(number);
        return cc.getResult();
    }
}
