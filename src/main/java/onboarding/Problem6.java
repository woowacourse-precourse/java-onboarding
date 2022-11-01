package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String key = getKey(forms);
        if(key == null){
            return answer;
        }
        answer = keyCheck(answer, forms, key);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    // 중복되는 문자 찾아내기 => key 찾는 과정
    private static String getKey(List<List<String>> forms){
        for(int i = 0; i < forms.size(); i++){
            String key = forms.get(i).get(1).substring(0, 2);
            for(int j = i + 1; j < forms.size(); j++){
                if(forms.get(j).get(1).contains(key)){
                    return key;
                }
            }
        }
        return null;
    }

    private static List<String> keyCheck(List<String> answer, List<List<String>> forms, String key){
        for(int i = 0; i < forms.size(); i++){
            if(forms.get(i).get(1).contains(key)){
                answer = overlapCheck(answer, forms.get(i).get(0));
            }
        }
        return answer;
    }

    private static List<String> overlapCheck(List<String> emailList, String email){
        if(emailList.size() == 0) {
            emailList.add(email);
        }
        if(emailList.size() != 0) {
            for (int i = 0; i < emailList.size(); i++) {
                if (emailList.get(i) == email) {
                    return emailList;
                }
            }
            emailList.add(email);
        }
        return emailList;
    }
}
