package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<Integer> delete_list = new ArrayList<Integer>();

        while (true){
            for (int i=0; i<cryptogram.length()-1; i++){
                if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                    delete_list.add(i);
                    delete_list.add(i+1);
                    i+=1;
                }
            }
            String tmp = "";

            for (int i=0; i<cryptogram.length(); i++) {
                if (!delete_list.contains(i))
                    tmp += cryptogram.charAt(i);
            }
            cryptogram = tmp;
            if (delete_list.isEmpty())
                break;

            delete_list.clear();
        }

        return cryptogram;
    }
}

/*
"browoanoommnaon"
"browoannaon"
"browoaaon"
"browoon"
"brown"
 */