package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (list.size() == 0) {
                list.add(cryptogram.charAt(i));
            }
            else if (list.get(list.size() - 1) == cryptogram.charAt(i)) {
                list.remove(list.size() - 1);
            }
            else {
                list.add(cryptogram.charAt(i));
            }
        }

        String answer = "";
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}
