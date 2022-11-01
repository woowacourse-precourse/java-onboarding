package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        return decode(cryptogram);
    }
    private static String decode(String str){
        String reuslt = "";

        boolean check = true;

        String [] array = str.split("");

        List<String> list = Arrays.asList(array);

    while (check){
        check = false;
        List<String> word = new ArrayList<>();
        word.addAll(list);

        for(int i = 0; list.size() -1 > i; i++){

            if(list.get(i).equals(list.get(i+1))){
                System.out.println(word);
                word.remove(i+1);
                word.remove(i);
                list=word;
                check=true;
            }
        }
    }
        StringBuilder wo = new StringBuilder();
        for(String v :list){
            wo.append(v);
        }
        reuslt = wo.toString();
        System.out.println(reuslt);
        return reuslt;
    }

}
