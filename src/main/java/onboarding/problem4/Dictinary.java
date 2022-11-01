package onboarding.problem4;

import java.util.HashMap;

public class Dictinary {

    // 청개구리 사전 저장소
    public static final HashMap<String, String> setDictionary(HashMap<String, String> map){

        final HashMap<String, String> dictionary = map;

        dictionary.put("a", "z");
        dictionary.put("b", "y");
        dictionary.put("c", "x");
        dictionary.put("d", "w");
        dictionary.put("e", "v");
        dictionary.put("f", "u");
        dictionary.put("g", "t");
        dictionary.put("h", "s");
        dictionary.put("i", "r");
        dictionary.put("j", "q");
        dictionary.put("k", "p");
        dictionary.put("l", "o");
        dictionary.put("m", "n");
        dictionary.put("n", "m");
        dictionary.put("o", "l");
        dictionary.put("p", "k");
        dictionary.put("q", "j");
        dictionary.put("r", "i");
        dictionary.put("s", "h");
        dictionary.put("t", "g");
        dictionary.put("u", "f");
        dictionary.put("v", "d");
        dictionary.put("w", "d");
        dictionary.put("x", "c");
        dictionary.put("y", "b");
        dictionary.put("z", "a");

        return dictionary;
    }

}
