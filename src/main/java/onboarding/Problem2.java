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

    private static boolean isSameCharacter(char now, char after) {
        return now == after;
    }

    private static String setNewString(String cryptogram, PriorityQueue<Integer> PQ) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <cryptogram.length() ; i++) {
            char c = cryptogram.charAt(i);
            if(!isPriorityQueueCondition(i)) continue;
            sb.append(c);
        }

        return sb.toString();

    }

    private static boolean isPriorityQueueCondition(int i) {
        if (PQ.isEmpty()) { return true;}
        else if (PQ.peek() == i) {
            PQ.poll();
            return false;
        }
        return true;
    }

    private static String Deduplication(String cryptogram) {

        for (int i = 0; i <cryptogram.length()-1 ; i++) {
            addValuePriorityQueue(i, cryptogram);
        }

        return setNewString(cryptogram, PQ);
    }
    private static void addValuePriorityQueue(int index, String cryptogram)
    {
        if (isSameCharacter(cryptogram.charAt(index), cryptogram.charAt(index + 1))) {
            PQ.add(index);
            PQ.add(index + 1);
        }
    }


    static PriorityQueue<Integer> PQ;
    public static String solution(String cryptogram) {
        boolean checkDuplicate = true;
        while (checkDuplicate)
        {
            PQ = new PriorityQueue<>();
            String temp = cryptogram;
            cryptogram = Deduplication(cryptogram);
            if(cryptogram.equals(temp)) checkDuplicate = false;
        }
        return cryptogram;
    }


}
