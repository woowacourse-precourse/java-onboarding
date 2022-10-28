package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        ArrayList<String> separateName = new ArrayList<String>();
        System.out.println(forms.get(0));
        System.out.println(forms.get(0).size());
        System.out.println(forms.get(0).get(1).charAt(0));
        System.out.println(forms.get(0).get(1).charAt(1));
        System.out.println(forms.get(0).get(1).length());
        for ( int s=0;forms.size()>s;s++){
            for (int k=0;forms.get(s).size()-1>k;k++){
                String A = String.valueOf(forms.get(s).get(1).charAt(k));
                String B = String.valueOf(forms.get(s).get(1).charAt(k+1));
               separateName.add(A+B);
            }
// 두번째 for문에서 size() 가 아니라 size()-1로 수정함.
        }

        System.out.println("나눠짐"+separateName);

        List<String> answer = List.of("answer");
        return answer;
    }
}
