package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        boolean check = true;

        String[] array = cryptogram.split("");
        List<String> list = Arrays.asList(array);

        while(check){
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for(int i = 0; list.size() -1 > i; i++){
                if(list.get(i).equals(list.get(i+1))){
                    cur_string.remove(i+1);
                    cur_string.remove(i);
                    list = cur_string;
                    check=true;
                    continue;
                }
            }
            list = cur_string;
        }

        return answer;
    }
}
