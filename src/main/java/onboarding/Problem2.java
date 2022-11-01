package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean whileCheck = true;
        String[] array = cryptogram.split("");
        List<String> list = Arrays.asList(array);


        while(whileCheck){
            whileCheck = false;

            List<String> str = new ArrayList<>();
            str.addAll(list);
            for(int i =0; list.size()-1>i;i++){
                if(list.get(i).equals(list.get(i+1))){
                    str.remove(i+1);
                    str.remove(i);
                    list = str;
                    whileCheck = true;
                }
            }
            list = str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : list){
            stringBuilder.append(str2);
        }
        answer = stringBuilder.toString();
        return answer;
    }
}
