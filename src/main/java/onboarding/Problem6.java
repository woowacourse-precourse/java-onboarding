package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, Integer> subNameMap = makeSubNameMap(forms);
        HashSet<String> dupSubName = extractDuplication(subNameMap);
        HashSet<String> crewEmailSet = extractCrewEmail(forms,dupSubName);

        List<String> answer = new ArrayList<>(crewEmailSet);
        Collections.sort(answer);
        return answer;
    }

    // 중복될 수 있는 모든 두글자가 몇회 반복되는지 확인한다.
    private static HashMap<String, Integer> makeSubNameMap(List<List<String>> forms) {
        HashMap<String, Integer> subNameMap = new HashMap<>();
        for (List<String> form : forms) {
            String name = form.get(1);
            saveAllSubName(name,subNameMap);
        }
        return subNameMap;
    }

    // 중복될 수 있는 두글자와 갯수를 함께 저장
    private static void saveAllSubName(String name, HashMap<String, Integer> subNameMap) {
        for (int i = 0; i < name.length() - 1; i++) {
            String subName = name.substring(i, i + 2);
            if (subNameMap.containsKey(subName)){
                int count = subNameMap.get(subName);
                subNameMap.put(subName,count+1);
            } else if (!subNameMap.containsKey(subName)) {
                subNameMap.put(subName, 0);
            }
        }
    }

    // 2회 이상 반복되는 두글자를 찾는다.
    private static HashSet<String> extractDuplication(HashMap<String, Integer> subNameMap) {
        HashSet<String> dupSubNames = new HashSet<>();
        for (String key : subNameMap.keySet()) {
            if (subNameMap.get(key) > 1) dupSubNames.add(key);
        }
        return dupSubNames;
    }

    // 2회 이상 반복되는 2글자를 가지고 있는 닉네임을 가진 크루의 이메일을 추출한다.
    private static HashSet<String> extractCrewEmail(List<List<String>> forms, HashSet<String> dupSubNames) {
        HashSet<String> crewEmails = new HashSet<>();
        for (List<String> form : forms) {
            String name = form.get(1);
            String email = form.get(0);
            for (int i = 0; i < name.length()-1; i++) {
                String subName = name.substring(i, i + 2);
                if (dupSubNames.contains(subName)) crewEmails.add(email);
            }
        }
        return crewEmails;
    }
}
