package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String key = getKey(forms);
        if(key == null){
            return answer;
        }
        answer = keyCheck(answer, forms, key);
        return answer;
    }

    // 중복되는 문자 찾아내기 => key 찾는 과정
    private static String getKey(List<List<String>> forms){
        for(int i = 0; i < forms.size(); i++){
            String keyName = forms.get(i).get(1);
            for(int j = 2; j < keyName.length() + 1; j++){
                String key = keyName.substring(0, j);
                for(int k = i + 1; k < forms.size(); k++){
                    if(forms.get(k).get(1).contains(key)){
                        return key;
                    }
                }
            }
        }
        return null;
    }

    private static List<String> keyCheck(List<String> answer, List<List<String>> forms, String key){
        for(int i = 0; i < forms.size(); i++){
            if(forms.get(i).get(1).contains(key)){
                answer.add(forms.get(i).get(0));
            }
        }
        return answer;
    }
}
