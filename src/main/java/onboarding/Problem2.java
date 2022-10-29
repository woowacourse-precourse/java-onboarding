package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = checkAfterChar(cryptogram);
        return answer;
    }

    public static String checkAfterChar(String cryptogram) {


        ArrayList<String> deleteList = new ArrayList<>();
        while (true){

         for (int i = 0; i < cryptogram.length() - 1; i++) {
             if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                 String deleteString = cryptogram.charAt(i) + "" + cryptogram.charAt(i + 1);
                 deleteList.add(deleteString);
             }
         }
        if(cryptogram==""||deleteList.isEmpty()){
            return cryptogram;
        }
            for (int i = 0; i < deleteList.size(); i++) {
                cryptogram =cryptogram.replace(deleteList.get(i),"");
                System.out.println(cryptogram);
            };
            deleteList.clear();
        }
    }
}
