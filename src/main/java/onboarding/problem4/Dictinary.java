package onboarding.problem4;

import java.util.HashMap;

public class Dictinary {

    // 청개구리 사전 저장소
    public static HashMap<String, String> setDictionary(HashMap<String, String>){

        final HashMap<String, String> hashMap = new HashMap<String, String>(26){{
            put("a", "z");
            put("b", "y");
            put("c", "x");
            put("d", "w");
            put("e", "v");
            put("f", "u");
            put("g", "t");
            put("h", "s");
            put("i", "r");
            put("j", "q");
            put("k", "p");
            put("l", "o");
            put("m", "n");
            put("n", "m");
            put("o", "l");
            put("p", "k");
            put("q", "j");
            put("r", "i");
            put("s", "h");
            put("t", "g");
            put("u", "f");
            put("v", "d");
            put("w", "d");
            put("x", "c");
            put("y", "b");
            put("z", "a");
        }};

        return hashMap;
    }

}
