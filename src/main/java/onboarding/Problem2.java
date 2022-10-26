package onboarding;

public class Problem2 {

    static class Cryptogram {
        private String origin;
        private String duplication;

        public Cryptogram(String origin) {
            this.origin = origin;
        }
        void init() {
            this.duplication = this.origin;
        }

        private boolean checkRepetition(int idx) {
            if(duplication.charAt(idx-1)==duplication.charAt(idx)) {
                duplication = duplication.substring(0, idx-1) + duplication.substring(idx+1);
                return true;
            }
            return false;
        }


    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
