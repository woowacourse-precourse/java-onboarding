package onboarding;

import java.util.HashMap;
import java.util.Locale;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        HashMap<String,String> map = new HashMap<String,String>(){{//초기값 지정
            put("a","z");
            put("b","y");
            put("c","x");
            put("d","w");
            put("e","v");
            put("f","u");
            put("g","t");
            put("h","s");
            put("i","r");
            put("j","q");
            put("k","p");
            put("l","o");
            put("m","n");
            put("n","m");
            put("o","l");
            put("p","k");
            put("q","j");
            put("r","i");
            put("s","h");
            put("t","g");
            put("u","f");
            put("v","e");
            put("w","d");
            put("x","c");
            put("y","b");
            put("z","a");

        }};

        String[] temp=word.split("");
        for (String s : temp) {
            if (s.equals(" ")) {
                answer += " ";
            } else if (map.containsKey(s)) {
                answer += map.get(s);
            } else {
                answer += map.get(s.toLowerCase(Locale.ROOT)).toUpperCase(Locale.ROOT);
            }
        }



        return answer;

    }
}
