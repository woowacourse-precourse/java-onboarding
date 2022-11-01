package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

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
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            int prev = 0;

            if(duplication.length()==2) {
                duplication = (isCharRepeated(0, 1)) ? "" : duplication;
                return flag;
            }

            for(int i=0 ; i<duplication.length() ; i++) {
                if(stack.empty() || ! isCharRepeated(prev, i)) {
                    stack.push(duplication.charAt(i));
                    prev = i;
                    continue;
                }

                while(isCharRepeated(prev, i)){
                    i++;
                }
                i--;
                stack.pop();
                flag=true;
            }

            duplication = stack.stream().map(String::valueOf).collect(Collectors.joining());
            return flag;
        }

        private boolean isCharRepeated(int i, int j) {
            return duplication.charAt(i) == duplication.charAt(j);
        }
    }
    public static String solution(String cryptogram) {
        Cryptogram c = new Cryptogram(cryptogram);
        return c.decode();
    }
}
