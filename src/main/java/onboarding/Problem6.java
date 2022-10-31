package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> duplicationNames = new ArrayList<>();

        HashMap<String, List<String>> nameHashMap = new HashMap<>();

        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            nameHashMap = subNameList(nameHashMap, name);
        }

        nameHashMap.forEach((subName, names) -> {
            if (names.size() > 1) {
                duplicationNames.addAll(names);
            }
        });

        List<String> duplicationDistinctNames = duplicationNames.stream().distinct().collect(Collectors.toList());

        for(int i = 0; i < forms.size(); i++) {
            String formsName = forms.get(i).get(1);

            if(duplicationDistinctNames.contains(formsName)) {
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);

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
