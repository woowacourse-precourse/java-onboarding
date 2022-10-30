package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,List<String>> checkMap = new HashMap<>();
        Set<String> duplicateRemoveMap = new HashSet<>();
        makeCheckMap(forms, checkMap);
        sendEmailTohaveDuplicatedNicknameMember(checkMap, duplicateRemoveMap);
        return sortEmailList(duplicateRemoveMap);
    }

    /**
     * 1. 닉네임 두글자로 자른다
     * 2. 자른 두글자 문자열을 키로 이메일 리스트를 생성
     */
    private static void makeCheckMap(List<List<String>> forms, Map<String, List<String>> checkMap) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            for(int i = 0; i < nickname.length()-1; i++) {
                String subNickname = nickname.substring(i, i + 2);
                if(!checkMap.containsKey(subNickname))
                    checkMap.put(subNickname, new ArrayList<>());
                checkMap.get(subNickname).add(form.get(0));
            }
        }
    }

    // 중복 닉네임을 가지고 있는 멤버의 이메일 리스트를 생성
    private static void sendEmailTohaveDuplicatedNicknameMember(Map<String, List<String>> checkMap, Set<String> duplicateRemoveMap) {
        for(String key : checkMap.keySet()) {
            List<String> emailList = checkMap.get(key);
            if(emailList.size() >= 2)
                duplicateRemoveMap.addAll(emailList);
        }
    }

    // 이메일 리스트를 오름차순으로 정렬
    private static List<String> sortEmailList(Set<String> duplicateRemoveMap) {
        List<String> result = new ArrayList<>();
        result.addAll(duplicateRemoveMap);
        Collections.sort(result);
        return result;
    }
}
