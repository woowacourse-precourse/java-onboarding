package onboarding;

import java.util.*;

public class Problem6 {
    private static final int EMAIL=0;
    private static final int NAME=1;
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> answer=new HashSet<>();


        return sortResult(answer);
    }

    public static List<String> sortResult(HashSet<String> answer){
        ArrayList<String> result=new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }

    public static List<String> subStrings(String s){
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            result.add(s.substring(i,i+2));
        }
        return result;
    }
    public static void contain(HashSet<String> result, List<List<String>> forms, List<String> targets){
        for(List<String> form:forms){
            add(result,form,targets);
        }
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
