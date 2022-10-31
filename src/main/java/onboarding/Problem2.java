package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        ArrayList<Character> list = new ArrayList<>();
        list.add(cryptogram.charAt(0));
        for(int i = 1; i < cryptogram.length(); i++) {
            if(list.size() == 0) {
                list.add(cryptogram.charAt(i));
                continue;
            }
            if(cryptogram.charAt(i) == list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                continue;
            }
            list.add(cryptogram.charAt(i));
        }

        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}
