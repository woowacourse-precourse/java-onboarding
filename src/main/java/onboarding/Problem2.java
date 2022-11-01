package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        List<Integer> index = new ArrayList<>();
        List<String> array2 = new ArrayList<>();
        String[] array = cryptogram.split("");
        boolean check = false;

        while(!check){
            check = true;
            for(int i=0;i< array.length-1;i++){
                if(array[i].equals(array[i+1])){
                    index.add(i);
                    index.add(i+1);
                    i++;
                    check = false;
                }
            }
            for(int i=0;i< array.length;i++){
                if(!index.contains(i)){
                    array2.add(array[i]);
                }
            }
            array = array2.toArray(new String[array2.size()]);
            index.clear();
            array2.clear();
        }

        for(String data : array){
            answer += data;
        }
        return answer;
    }
}
