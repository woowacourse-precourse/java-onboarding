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

            for(int i=0 ; i<duplication.length() ; i++) {
                if(duplication.length()==2) {
                    duplication=(duplication.charAt(0)==duplication.charAt(1))? "" : duplication;
                    break;
                }
                if(stack.empty() || duplication.charAt(prev)!=duplication.charAt(i)) {
                    stack.push(duplication.charAt(i));
                    prev = i;
                    continue;
                }
                while(duplication.charAt(prev)==duplication.charAt(i)){
                    i++;
                }
                i--;
                stack.pop();
                flag=true;
            }

            duplication = stack.stream().map(String::valueOf).collect(Collectors.joining());
            return flag;
        }
    }
    public static String solution(String cryptogram) {
        Cryptogram c = new Cryptogram(cryptogram);
        return c.decode();
    }
}
