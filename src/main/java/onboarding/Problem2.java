package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    //
    public static ArrayList removeDuplicate(ArrayList<String> s){
        int i = 0;
        while(i + 1 < s.size()) {
            String num1 = s.get(i);
            String num2 = s.get(i+1);
            if (num1.equals(num2)) {
                s.remove(i);
                s.remove(i);
                i = 0;
            } else i++;
        }
        return s;
    }


    public static String solution(String cryptogram) {
        ArrayList<String> list;
        list = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        removeDuplicate(list);

        String str = "";
        for(String item : list){
            str += item;
        }

        String answer = str;
        return answer;
    }
}
