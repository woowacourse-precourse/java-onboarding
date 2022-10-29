package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    private static final int EMAIL=0;
    private static final int NAME=1;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> subStrings(String s){
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            result.add(s.substring(i,i+2));
        }
        return result;
    }
    public static void add(HashSet<String> result, List<String> form, List<String> targets){
        for(String target:subStrings(targets.get(NAME))){
            if(form.get(NAME).contains(target)) {
                result.add(targets.get(EMAIL));
                result.add(form.get(EMAIL));
            }
        }
    }
}
