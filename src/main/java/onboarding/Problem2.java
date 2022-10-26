package onboarding;

import java.util.ArrayList;

class validationSamethings{
    public static boolean validation(ArrayList<String> list){
        String pivot;
        for(int i=0;i<list.size()-1;i++){
            pivot=list.get(i);
            if(pivot.equals(list.get(i+1))){
                return false;
            }
        }
        return true;
    }
}

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
