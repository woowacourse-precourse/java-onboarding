package onboarding;

import java.util.PriorityQueue;

public class Problem2 {
    static class Password {
        String cryptogram;

        public Password(String cryptogram) throws Exception {
            if (!isValidGram(cryptogram)) throw new Exception("Wrong String");
            this.cryptogram = cryptogram;
        }

        private boolean isValidGram(String cryptogram) {
            if(!isValidLength(cryptogram.length())) return false;
            for (int i = 0; i <cryptogram.length() ; i++) {
                if(!isSmallLetter(cryptogram.charAt(i))) return false;
            }
            return true;
        }

        private boolean isValidLength(int cryptogramLength) {
            return cryptogramLength>0 &&cryptogramLength<=1000;
        }

        private boolean isSmallLetter(char c){
            return c >= 97 && c <= 122;
        }


    }

    static boolean isSameCharacter(char now, char after) {
        return now == after;
    }

    static String setNewString(String cryptogram, PriorityQueue<Integer> PQ) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PQ.size(); i++) {
            int index = PQ.poll();
            sb.append(cryptogram.charAt(index));
        }

        return sb.toString();
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
