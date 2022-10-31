package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        //String answer = cryptogram;
        StringBuilder ans = new StringBuilder(cryptogram);
        //List<String> ans = new ArrayList<>(Arrays.asList(cryptogram));
        boolean check = true;
        while(check){
            check = false;
            for(int i=0; i<ans.length(); i++){
                if(ans.charAt(i) == ans.charAt(i+1)){
                    for(int j=i+1; j<ans.length(); j++){
                        if(ans.charAt(i) == ans.charAt(j))
                            ans.deleteCharAt(j--);
                    }
                    ans.deleteCharAt(i);
                    check = true;
                }
            }
            if(!check) break;
        }
        String answer = ans.toString();
        return answer;
    }
}
