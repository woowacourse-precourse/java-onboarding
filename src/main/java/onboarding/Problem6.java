package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> subStrings(String s){
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            result.add(s.substring(i,i+1));
        }
        return result;
    }
}
