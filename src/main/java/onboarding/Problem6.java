package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<String> GetPosibleExample(String nickname){
        List<String> ret_variable = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++){
            String truncated = nickname.substring(i,i+2);
            ret_variable.add(truncated);
        }
        return ret_variable;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(List<String> obj:forms) {
            List<String> truncated = GetPosibleExample(obj.get(1));

            System.out.println(truncated);
        }
        return answer;
    }
}
