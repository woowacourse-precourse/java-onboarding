package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, List<String>> nameHashMap = new HashMap<>();

        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            nameHashMap = subNameList(nameHashMap, name);
        }

        return answer;
    }

    public static HashMap<String, List<String>> subNameList(HashMap<String, List<String>> nameHashMap, String name) {
        String[] nameArray = name.split("");

        int index = 1;
        while (index < nameArray.length) {
            String subName = nameArray[index - 1] + nameArray[index];
            if(nameHashMap.containsKey(subName)) {
                // subName의 hashMap value에 name이 이미 존재하지 않으면
                if (!(nameHashMap.get(subName).contains(name))) {
                    List<String> containSubName = nameHashMap.get(subName);
                    containSubName.add(name);
                    nameHashMap.put(subName, containSubName);
                }
            }
            else {
                // subName이 없으면 새로운 key, value 생성해서 hashMap에 추가
                List<String> containSubName = new ArrayList<>();
                containSubName.add(name);
                nameHashMap.put(subName, containSubName);
            }

            index += 1;
        }

        return nameHashMap;
    }
}
