package onboarding;

// 엄마 말씀 word가 매개변수로 주어질 때,                       변수 스트링을 받아서
// 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록     청개구리 사전을 등록
//                                                          사전과 입력값을 비교하여 사전에 등록된 단어 교체.
// solution 메서드를 완성하라.                                반환



import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {

        String answer = make_answer(word);

        return answer;
    }

    public static String make_answer(String word){
        HashMap<String,String> dic = new HashMap<String,String>();
        set_hashmap(dic);

        StringBuilder temp = new StringBuilder();

        for(int i =0;i<word.length();i++){
            if(dic.get(Character.toString(word.charAt(i))) != null){
                temp.append(dic.get(Character.toString(word.charAt(i))));
            }
            else{
                temp.append(Character.toString(word.charAt(i)));
            }
        }
        
        return temp.toString();
    }

    public static HashMap<String,String> set_hashmap(HashMap<String,String> dic)
    {
        //ASCII A = 65 Z = 90 a = 97 z = 122

        dic.put("A", "Z");
        dic.put("B", "Y");
        dic.put("C", "X");
        dic.put("D", "W");
        dic.put("E", "V");
        dic.put("F", "U");
        dic.put("G", "T");
        dic.put("H", "S");
        dic.put("I", "R");
        dic.put("J", "Q");
        dic.put("K", "P");
        dic.put("L", "O");
        dic.put("M", "N");
        dic.put("N", "M");
        dic.put("O", "L");
        dic.put("P", "K");
        dic.put("Q", "J");
        dic.put("R", "I");
        dic.put("S", "H");
        dic.put("T", "G");
        dic.put("U", "F");
        dic.put("V", "E");
        dic.put("W", "D");
        dic.put("X", "C");
        dic.put("Y", "B");
        dic.put("Z", "A");


        dic.put("a", "z");
        dic.put("b", "y");
        dic.put("c", "x");
        dic.put("d", "w");
        dic.put("e", "v");
        dic.put("f", "u");
        dic.put("g", "t");
        dic.put("h", "s");
        dic.put("i", "r");
        dic.put("j", "q");
        dic.put("k", "p");
        dic.put("l", "o");
        dic.put("m", "n");
        dic.put("n", "m");
        dic.put("o", "l");
        dic.put("p", "k");
        dic.put("q", "j");
        dic.put("r", "i");
        dic.put("s", "h");
        dic.put("t", "g");
        dic.put("u", "f");
        dic.put("v", "e");
        dic.put("w", "d");
        dic.put("x", "c");
        dic.put("y", "b");
        dic.put("z", "a");
        
        return dic;
    }


}
