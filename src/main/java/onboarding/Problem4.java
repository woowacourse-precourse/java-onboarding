package onboarding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Problem4 {
    static class change{
        static int sa = 'a';
        static int sz = 'z';
        static int ba = 'A';
        static int bz = 'Z';

        public static char exchange(char c){
            char answer;
            int ascii = c;
            if ( ascii >= sa && ascii <= sz){
                answer = (char)(sz - (ascii - sa));
            } else if ( ascii >= ba && ascii <= bz){
                answer = (char)(bz - (ascii - ba));
            } else {
                answer = c;
            }
            return answer;
        }

        public static String makeString(String word){
            ArrayList<Character> answer =  new ArrayList<>();
            for (int i = 0; i < word.length(); i++){
                answer.add(exchange(word.charAt(i)));
            }
            return answer.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }
    public static String solution(String word) {
        return change.makeString(word);
    }
}
