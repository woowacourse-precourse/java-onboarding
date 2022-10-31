package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuffer sb=new StringBuffer(word);
        HashMap<String,String> map= new HashMap<>();
        map.put("A","Z");
        map.put("B","Y");
        map.put("C","X");
        map.put("D","W");
        map.put("E","V");
        map.put("F","U");
        map.put("G","T");
        map.put("H","S");
        map.put("I","R");
        map.put("J","Q");
        map.put("K","P");
        map.put("L","O");
        map.put("M","N");
        map.put("N","M");
        map.put("O","L");
        map.put("P","K");
        map.put("Q","J");
        map.put("R","I");
        map.put("S","H");
        map.put("T","G");
        map.put("U","F");
        map.put("V","E");
        map.put("W","D");
        map.put("X","C");
        map.put("Y","B");
        map.put("Z","A");
        map.put("a","z");
        map.put("b","y");
        map.put("c","x");
        map.put("d","w");
        map.put("e","v");
        map.put("f","u");
        map.put("g","t");
        map.put("h","s");
        map.put("i","r");
        map.put("j","q");
        map.put("k","p");
        map.put("l","o");
        map.put("m","n");
        map.put("n","m");
        map.put("o","l");
        map.put("p","k");
        map.put("q","j");
        map.put("r","i");
        map.put("s","h");
        map.put("t","g");
        map.put("u","f");
        map.put("v","e");
        map.put("w","d");
        map.put("x","c");
        map.put("y","b");
        map.put("z","a");
        String tmp=null;
        char mod=0;

        for (int i = 0; i < sb.length(); i++) {
            mod=sb.charAt(i);

            tmp=String.valueOf(mod);

            if(map.containsKey(tmp)){
                sb.replace(i,i+1,map.get(tmp));
            }
        }
        answer= sb.toString();

        return answer;
    }
}
