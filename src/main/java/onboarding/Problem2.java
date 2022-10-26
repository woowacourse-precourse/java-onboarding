package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        ArrayList<Character> list = new ArrayList<>();

        for (int i =0; i < cryptogram.length(); i++) {
            char next = cryptogram.charAt(i);
            if(list.isEmpty()) { //  첫 삽입 (range out 방지용)
                list.add(next);
            } else {
                if (next == list.get(list.size()-1)) { // 연속된 경우 pop
                    list.remove(list.size()-1);
                } else { // 연속이 아닌 경우 add
                    list.add(next);
                }
            }
        }

        String answer = "";
        for (Character item : list) {
            answer += item;
        }

        return answer;
    }
}
