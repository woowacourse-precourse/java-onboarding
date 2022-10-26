package onboarding;

import java.util.*;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean count = true;
        String[] array = cryptogram.split("");
        List<String> list = Arrays.asList(array);
        while (count){
            count = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);
            for (int i = 0; list.size() -1>i;i++){
                if (list.get(i).equals(list.get(i+1))){
                    cur_string.remove(i+1);
                    cur_string.remove(i);
                    list = cur_string;
                    count = true;
                    continue;
                }
            }
            list = cur_string;
        }
        StringBuilder bo = new StringBuilder();
        for (String s : list){
            bo.append(s);
        }
        answer = bo.toString();
        return answer;
    }
}
