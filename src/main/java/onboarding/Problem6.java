package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        List<String> nicknameList = new ArrayList<>();


        makeNickNameList(forms,nicknameList);


        return answer;
    }
    public static void makeNickNameList(List<List<String>> originList,List <String> nickname){
        for(int i = 0 ; i < originList.size(); i++){
            nickname.add(originList.get(i).get(1));
        }
    }
}
