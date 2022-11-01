package onboarding;

import java.util.Stack;

public class Problem2 {
    public static boolean isDuplicate(String cryptogram) {
        char prev = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if(prev == cryptogram.charAt(i)) {
                return true;
            }
            prev = cryptogram.charAt(i);
        }
        return false;
    }

    public static String delete(String crpytogram) {
        String ans = "";
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < crpytogram.length(); i++) {
            if (s.empty()) {
                s.push(crpytogram.charAt(i));
            }
            else {
                if (s.peek() == crpytogram.charAt(i)) {
                    s.pop();
                }
                else {
                    s.push(crpytogram.charAt(i));
                }
            }
        }

        while(!s.empty()) {
            ans = s.pop() + ans;
        }

        return ans;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        if(isDuplicate(cryptogram)) {
            answer = delete(cryptogram);
        }
        return answer;
    }
}
