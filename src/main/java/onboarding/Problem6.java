package onboarding;

import java.util.*;

public class Problem6 {
    private static final int EMAIL=0;
    private static final int NAME=1;
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> result=new HashSet<>();
        for(int i=0;i<forms.size()-1;i++){
            contain(result,forms.subList(i+1,forms.size()),forms.get(i));
        }
        return sortResult(result);
    }

    public static List<String> sortResult(HashSet<String> result){
        ArrayList<String> answer=new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
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
