package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkDuplication(String fistNickname, String SecondNickname){
        for (int i =0 ; i<fistNickname.length()-2 ; i++){
            if (SecondNickname.contains(fistNickname.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }

}
