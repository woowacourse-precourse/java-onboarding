package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        // hash 구조로 이름:{파싱한 이름} ex: 제이엠: {제이, 이엠}
        // 파싱한 이름은 전부 한 배열에 넣고 배열 for문 돌려서 중첩 원소있는거 찾고 그 원소로 hash 구조에서 검색
        // 그리고 중첩 원소는 지우고 for문 계속

        HashMap<String, List<String>> nameHashMap = new HashMap<>();
        List<String> totalSubName = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            List<String> sl = subNameList(name);
            nameHashMap.put(name, sl);
            totalSubName.addAll(sl);
        }

        return answer;
    }

    public static List<String> subNameList(String name) {
        String[] nameArray = name.split("");

        List<String> subNameList = new ArrayList<>();

        int index = 1;
        while (index < nameArray.length) {
            subNameList.add(nameArray[index - 1] + nameArray[index]);
            index += 1;
        }

        return subNameList;
    }
}
