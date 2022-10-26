package onboarding;

public class Problem3 {
    static final int MAX_SIZE = 10001;

    static class ClapCount {
        private int[] count = new int[MAX_SIZE];
        private int target;

        public ClapCount(int target) {
            this.target = target;
        }

        private boolean isThreeSixNine(char c) {
            if(c =='3'|| c =='6'|| c =='9'){
                return true;
            }
            return false;
        }

    }


    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
