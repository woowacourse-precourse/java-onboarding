package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static List<String> extractNickName(List<List<String>> forms){
        List<String> nickNameList = new ArrayList<>();
        forms.forEach(form -> nickNameList.add(form.get(1)));
        return nickNameList;
    }
}
