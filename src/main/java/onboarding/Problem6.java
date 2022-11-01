package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        Collections.sort(answer);
        return answer;
    }

    private static boolean checkOverlap(List<String> stringUnit, boolean overlap, String otherNickName) {
        for(int n = 0; n< stringUnit.size(); n++){
            if(otherNickName.contains(stringUnit.get(n))){
                overlap =true;
                break;
            }
        }
        return overlap;
    }

}
