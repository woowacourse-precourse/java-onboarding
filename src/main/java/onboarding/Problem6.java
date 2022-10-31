package onboarding;

import java.util.ArrayList;
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

        //같은 글자 연속 닉네임 -> result add
        for(int i=0; i<nicks.length-1; i++) {
            System.out.println("nicks[i]: "+nicks[i]);
            regex = nicks[i];
            for(int j=i+1; j<nicks.length; j++) {
                for(int k=0; k<regex.length()-1; k++) {
                    System.out.println("k: "+k+", k+2: "+(k+2)+", regex: "+regex);
                    System.out.println("regex.substring(k, k+1): "+regex.substring(k, k+2));
                    if(nicks[j].contains(regex.substring(k, k+2))) {
                        System.out.println("nicks[j]: "+nicks[j]+", emails[j]: "+emails[j]);
                        result.add(emails[j]);
                        result.add(emails[i]);
                    }
                }
            }
        }

        //정답
        List<String> answer = new ArrayList<>();
        answer.addAll(result);

        return answer;
    }
}
