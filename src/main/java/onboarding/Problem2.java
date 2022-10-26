package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    private static String decode(String cryptogram){
        var s = new Stack<Character>();
        for(var c : cryptogram.toCharArray()){
            if(!s.empty() && s.peek().equals(c))
                s.pop();
            else
                s.push(c);
        }
        return s.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
