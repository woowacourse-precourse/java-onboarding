package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean[] isOverlap;
    public static List<String>[] userForms;
    public static List<String> answer;

    public static List<String> solution(List<List<String>> forms) {

        answer = new ArrayList<>();
        isOverlap = new boolean[forms.size()];
        userForms = new List[forms.size()];
        setUserForms(forms);

        return answer;
    }
    public static void setUserForms(List<List<String>> forms){
        for(int i=0;i<forms.size();i++){
            userForms[i] = forms.get(i);
        }
    }
}
