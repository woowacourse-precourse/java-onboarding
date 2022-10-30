package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = findalp(word);
        return answer;
    }

    //    1.hashmap으로 key,value 저장하는 메서드(아스키코드 활용)
    public static Character dict(Character alp) {
        HashMap<Character, Character> save = new HashMap<>();
        save.put('A', 'Z');
        save.put('B', 'Y');
        save.put('C', 'X');
        save.put('D', 'W');
        save.put('E', 'V');
        save.put('F', 'U');
        save.put('G', 'T');
        save.put('H', 'S');
        save.put('I', 'R');
        save.put('J', 'Q');
        save.put('K', 'P');
        save.put('L', 'O');
        save.put('M', 'N');
        save.put('N', 'M');
        save.put('O', 'L');
        save.put('P', 'K');
        save.put('Q', 'J');
        save.put('R', 'I');
        save.put('S', 'H');
        save.put('T', 'G');
        save.put('U', 'F');
        save.put('V', 'E');
        save.put('W', 'D');
        save.put('X', 'C');
        save.put('Y', 'B');
        save.put('Z', 'A');

        return save.get(alp);
    }

}
