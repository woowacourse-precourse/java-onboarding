package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String[] strArr = cryptogram.split("");
        ArrayList<String> strArrLi = new ArrayList<String>(Arrays.asList(strArr));

        for (int i=0; i<strArrLi.size()-1; i++){
            String now = strArrLi.get(i);
            String next = strArrLi.get(i+1);

            if(now.equals(next)){
                strArrLi.remove(i);
                strArrLi.remove(i);
                i=0;
            }
        }
        String now = strArrLi.get(0);
        String next = strArrLi.get(1);

        if(now.equals(next)){
            strArrLi.remove(0);
            strArrLi.remove(0);
        }
        String result = String.join("",strArrLi);
        //System.out.println(result);
        return result;
    }
}
