package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int i = 0;
        boolean checkEnd = false;

        List<Character> list = cryptogram.chars().mapToObj(e->(char)e).collect(Collectors.toList());

        while(!checkEnd){
            checkEnd = true;
            i = 0;

            while(i < list.size()-1){
                if(list.get(i) == list.get(i+1)){
                    list.remove(i);
                    list.remove(i);
                    i -= 1;
                    checkEnd = false;
                }

                i+=1;
            }

        }

        answer = list.stream()
                  .map(e->e.toString())
                  .collect(Collectors.joining());
        return answer;
    }
}
