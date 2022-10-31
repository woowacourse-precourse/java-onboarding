package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }
    private static String decode(String str){
        String result = "";

        boolean check = true;

        String[] array = str.split("");
        List<String> list = Arrays.asList(array);

        while (check){
            check = false;
            List<String> cur_string = new ArrayList<>();
            cur_string.addAll(list);

            for(int i = 0; i < list.size() -1  ; i++){
                if(list.get(i).equals(list.get(i+1))){
                    cur_string.remove(i+1);
                    cur_string.remove(i);
                    list = cur_string;
                    check = true;
                    continue;

                }
            }
            list = cur_string;


        }
        StringBuilder sb = new StringBuilder();
        for (String s:list){
            sb.append(s);
        }
        result = sb.toString();
        System.out.println(result);
        return result;
    }
}

