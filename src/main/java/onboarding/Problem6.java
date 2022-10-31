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

        //닉네임과 이메일 배열
        String[] nicks = new String[forms.size()];
        String[] emails = new String[forms.size()];

        int index = 0;
        for(List<String> list : forms) {
            nicks[index] = list.get(1);
            emails[index] = list.get(0);
            index++;
        }

        System.out.println("nicks: "+ Arrays.toString(nicks));
        System.out.println("emails: "+ Arrays.toString(emails));



        List<String> answer = List.of("answer");
        return answer;
    }
}
