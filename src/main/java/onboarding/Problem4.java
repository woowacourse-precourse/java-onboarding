package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 청개구리 말에 상응하는 map 생성
        HashMap<String, String> frogWord = new HashMap<>();
        frogWord.put("A","Z");
        frogWord.put("B","Y");
        frogWord.put("C","X");
        frogWord.put("D","W");
        frogWord.put("E","V");
        frogWord.put("F","U");
        frogWord.put("G","T");
        frogWord.put("H","S");
        frogWord.put("I","R");
        frogWord.put("J","Q");
        frogWord.put("K","P");
        frogWord.put("L","O");
        frogWord.put("M","N");
        frogWord.put("N","M");
        frogWord.put("O","L");
        frogWord.put("P","K");
        frogWord.put("Q","J");
        frogWord.put("R","I");
        frogWord.put("S","H");
        frogWord.put("T","G");
        frogWord.put("U","F");
        frogWord.put("V","E");
        frogWord.put("W","D");
        frogWord.put("X","C");
        frogWord.put("Y","B");
        frogWord.put("Z","A");

        frogWord.put("a","z");
        frogWord.put("b","y");
        frogWord.put("c","x");
        frogWord.put("d","w");
        frogWord.put("e","v");
        frogWord.put("f","u");
        frogWord.put("g","t");
        frogWord.put("h","s");
        frogWord.put("i","r");
        frogWord.put("j","q");
        frogWord.put("k","p");
        frogWord.put("l","o");
        frogWord.put("m","n");
        frogWord.put("n","m");
        frogWord.put("o","l");
        frogWord.put("p","k");
        frogWord.put("q","j");
        frogWord.put("r","i");
        frogWord.put("s","h");
        frogWord.put("t","g");
        frogWord.put("u","f");
        frogWord.put("v","e");
        frogWord.put("w","d");
        frogWord.put("x","c");
        frogWord.put("y","b");
        frogWord.put("z","a");

        // 공백은 공백으로 반환
        frogWord.put(" "," ");


        // 각 글자에 상응하는 값을 map 조회하여 대입
        for (int i=0; i<word.length(); i++){
            answer += frogWord.get(Character.toString(word.charAt(i)));
        }

        return answer;

    }

}
