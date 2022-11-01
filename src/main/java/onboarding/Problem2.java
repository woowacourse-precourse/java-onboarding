package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] arr = cryptogram.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char a : arr)
            list.add(a);

        while(true) {
            boolean check = false;
            for(int i = 1 ; i < list.size(); i++) {
                char c = list.get(i-1);
                if(list.get(i).equals(c)) {
                    list.remove(i);
                    list.remove(i-1);
                    check = true;
                }
            }
            if(!check)
                break;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String answer = sb.toString();
        return answer;
    }
}
