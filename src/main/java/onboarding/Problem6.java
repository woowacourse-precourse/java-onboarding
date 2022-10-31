package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> form;
        String currentEmail;
        String currentNickName;
        for (int index = 0; index< forms.size(); index++){
            form = forms.get(index);
            currentEmail = form.get(0);
            currentNickName = form.get(1);
            splitTwiceList(currentNickName);
        }

        return answer;
    }

    public static List<String> splitTwiceList(String nickName){
        List<String> twiceList = new ArrayList<>();
        String subNickName;

        for (int index = 0; index < nickName.length()-1; index++){
            subNickName = nickName.substring(index, index + 2);
            twiceList.add(subNickName);
        }

        return twiceList;
    }
}
