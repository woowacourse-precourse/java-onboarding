package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emails = new HashSet<>();
        List<String> nameList = new ArrayList<>();

        //이름을 2글자로 나눈 리스트 생성
        for (int i = 0; i < forms.size(); i++) {
            nameList = MakeTwoWordList(nameList, forms.get(i).get(1));
        }
        return answer;
    }

    //이름을 2글자로 나눠서 리스트에 저장
    public static List<String> MakeTwoWordList(List<String> nameList, String name) {
        for (int j = 0; j < name.length() - 1; j++) {
            String key = name.substring(j, j+2);
            nameList.add(key);
        }
        return nameList;
    }
}
