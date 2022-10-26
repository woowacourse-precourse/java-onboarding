package onboarding;

public class Problem3 {
    static final int MAX_SIZE = 10001;

    static class ClapCount {
        private int[] count = new int[MAX_SIZE];
        private int target;

        public ClapCount(int target) {
            this.target = target;
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
