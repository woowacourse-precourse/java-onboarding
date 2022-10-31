package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> s = new Stack<>();

        boolean running = false;
        boolean isChanged= false;
        while(true) {
            for (int i = 0; i < cryptogram.length(); i++) {
                Character c = cryptogram.charAt(i);
                if (!s.isEmpty() && s.peek().equals(c)) {
                    isChanged = true;
                    running = true;
                    if(i == cryptogram.length()-1){
                        isChanged = false;
                        s.pop();
                    }
                    continue;
                } else {
                    if (isChanged) {
                        s.pop();
                        isChanged = false;
                    }
                    s.push(c);
                }
            }
            if (running) {
                cryptogram = convertCryptogram(s);
                running = false;
            } else {
                break;
            }
        }
        answer = convertCryptogram(s);

        return answer;
    }
    static String convertCryptogram(Stack<Character> s){
        String converted = "";
        while(!s.isEmpty()){
            converted = s.pop() + converted;
        }

        return converted;
    }
}
