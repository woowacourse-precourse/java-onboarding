package onboarding;

import java.util.HashMap;

public class Problem4 {
    //엄마의 알파벳을 청개구리의 알파벳으로 매핑해주는 hashmap
    private static HashMap<Character,Character> map = new HashMap<Character,Character>(){{
        for(int i = 97; i<=122; i++){
            put((char)i, (char)(219-i));
        }
    }};
    
    //주어진 엄마의 알파벳을 청개구리의 알파벳으로 변환해 반환해주는 함수
    private static Character mapping(Character c){
        if (Character.isAlphabetic(c)){
            char mom = Character.toLowerCase(c);
            char son = (Character.isUpperCase(c)) ? Character.toUpperCase(map.get(mom)): map.get(mom);
            return son;
        }
        else return c;
    }

    public static String solution(String word) {
        StringBuffer ans = new StringBuffer();

        //엄마 말씀 word를 알파벳 단위로 청개구리의 word로 변환한다.
        for(int i = 0; i<word.length(); i++){
            ans.append(mapping(word.charAt(i)));
        }

        return ans.toString();
    }
}
