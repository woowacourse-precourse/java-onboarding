package onboarding.problem4;

import java.util.HashMap;

public class Dictinary {

    // 청개구리 사전 저장소
    public static final HashMap<String, String> setDictionary(HashMap<String, String> map){

        final HashMap<String, String> dictionary = map;

        dictionary.put(" ", " ");
        dictionary.put("a", "z"); dictionary.put("","");
        dictionary.put("b", "y");  dictionary.put("A","Z");
        dictionary.put("c", "x");  dictionary.put("B","Y");
        dictionary.put("d", "w");  dictionary.put("C","X");
        dictionary.put("e", "v");  dictionary.put("D","W");
        dictionary.put("f", "u");  dictionary.put("E","V");
        dictionary.put("g", "t");  dictionary.put("F","U");
        dictionary.put("h", "s");  dictionary.put("G","T");
        dictionary.put("i", "r");  dictionary.put("H","S");
        dictionary.put("j", "q");  dictionary.put("I","R");
        dictionary.put("k", "p");  dictionary.put("J","Q");
        dictionary.put("l", "o");  dictionary.put("K","P");
        dictionary.put("m", "n");  dictionary.put("L","O");
        dictionary.put("n", "m");  dictionary.put("M","N");
        dictionary.put("o", "l");  dictionary.put("N","M");
        dictionary.put("p", "k");  dictionary.put("O","L");
        dictionary.put("q", "j");  dictionary.put("P","K");
        dictionary.put("r", "i");  dictionary.put("Q","J");
        dictionary.put("s", "h");  dictionary.put("R","I");
        dictionary.put("t", "g");  dictionary.put("S","H");
        dictionary.put("u", "f");  dictionary.put("T","G");
        dictionary.put("v", "e");  dictionary.put("U","F");
        dictionary.put("w", "d");  dictionary.put("V","E");
        dictionary.put("x", "c");  dictionary.put("W","D");
        dictionary.put("y", "b");  dictionary.put("X","C");
        dictionary.put("z", "a");  dictionary.put("Y","B");
                                   dictionary.put("Z","A");

        return dictionary;
    }

}
