package onboarding;

import java.util.List;

public class Problem6 {
    public static List<List<String>> getValidList(List<List<String>> forms){
        String domain = "@email.com";
        for(int i = 0; i < forms.size(); i++ ) {
            if(!forms.get(i).get(0).substring(forms.get(i).get(0).length() - 10).equals(domain))
                forms.remove(i);
            if(forms.get(i).get(0).length() < 11 || forms.get(i).get(0).length() > 19)
                forms.remove(i);
            boolean koeanWord = forms.get(i).get(1).matches("^[가-힣]*$");
            if(!koeanWord)
                forms.remove(i);
            if(forms.get(i).get(1).length() < 1 || forms.get(i).get(1).length() > 19)
                forms.remove(i);
        }
        return forms;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
