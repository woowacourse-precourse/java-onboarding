package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            // 닉네임이 한글자인 경우
            if(forms.get(i).get(1).length() == 1){
                break;
            }
            // 닉네임이 두글자 이상인 경우
            else{
                char[] arr = forms.get(i).get(1).toCharArray();
                for(int j=0; j<forms.get(i).get(1).length() - 1; j++){
                    Pattern pattern = Pattern.compile(".*" + arr[j] + arr[j+1] + ".*");
                    for(int k=0; k<forms.size(); k++){
                        if(i != k){
                            Matcher matcher = pattern.matcher(forms.get(k).get(1));
                            if(matcher.find()){
                                answer.add(forms.get(k).get(0));
                            }
                        }
                    }
                }
            }
        }
        List<String> answerWithoutDuplicates = answer
                .stream()
                .distinct()
                .collect(Collectors.toList());
        Collections.sort(answerWithoutDuplicates);
    return answerWithoutDuplicates;
    }
}
