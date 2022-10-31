package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> formMap = converToHashMap(forms);   // { key : email, value : nickname }
        List<String> keyList = sortToDes(formMap);    // 오름차순으로 정렬된 Email List

        String mainNick, subNick;
        List<String> result = new ArrayList<>();

        for (int i=0;i<keyList.size();i++) {
            mainNick = formMap.get(keyList.get(i));
            for (int j=1;j<keyList.size();j++) {
                subNick = formMap.get(keyList.get(j));
                if (!(keyList.get(i).equals(keyList.get(j)))) {
                    // 같은 key(이메일)이 아닐 경우
                    if (search(mainNick, subNick)) {
                        result.add(keyList.get(i));
                        result.add(keyList.get(j));
                    }
                }
            }
        }

        result = removeDups(result);
        answer = result;

        return answer;
    }

    // List(forms) -> HashMap
    public static HashMap<String, String> converToHashMap(List<List<String>> forms) {
        HashMap<String, String> formMap = new HashMap<>();
        for(List<String> form : forms) {
            formMap.put(form.get(0), form.get(1));
        }
        return formMap;
    }

    // 이메일(Key) 기준 오름차순으로 정렬
    public static List<String> sortToDes(HashMap<String, String> formMap) {
        List<String> keyList = new ArrayList<>(formMap.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        return keyList;
    }

    // 중복되는 닉네임 탐색
    public static Boolean search(String mainNick, String subNick){
        String mainword, subword;
        for (int i=0;i<mainNick.length()-1;i++) {
            mainword = mainNick.substring(i, i+2);
            for (int j=0;j<subNick.length()-1;j++) {
                subword = subNick.substring(j, j+2);
                if (mainword.equals(subword))
                    return true;
            }
        }
        return false;
    }

    public static List<String> removeDups(List<String> result) {
        return result.stream().distinct().collect(Collectors.toList());
    }
}
