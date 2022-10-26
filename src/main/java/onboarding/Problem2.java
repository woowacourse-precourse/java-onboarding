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

        String decode() {
            init();
            boolean flag = true;
            while(flag) {
                flag = hasRepetition();
            }
            return this.duplication;
        }

        private boolean hasRepetition() {
            for(int i=1 ; i<duplication.length() ; i++) {
                if (checkRepetition(i)) return true;
            }
            return false;
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
        Cryptogram c = new Cryptogram(cryptogram);
        return c.decode();
    }
}
