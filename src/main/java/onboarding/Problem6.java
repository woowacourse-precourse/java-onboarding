package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        System.out.println("====solution====");
        System.out.println("forms: "+ Arrays.toString(forms.toArray()));

        String regex = null;
        TreeSet<String> result = new TreeSet<>();
        //만약 크루가 1명이라면 같은 글자가 연속된 닉네임 없음
        if(forms.size()==1) return null;

        String[] nicks = new String[forms.size()];
        String[] emails = new String[forms.size()];





        List<String> answer = List.of("answer");
        return answer;
    }
}
