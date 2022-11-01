package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //중복을 제거하기 위해 set 사용
        Set<String> set = new HashSet<>();
        Map<String, String> subNameMap = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            String email = form.get(0);
            saveDuplicateName(set, subNameMap, name, email);
        }

        //List로 변환후 정렬
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    private static void saveDuplicateName(Set<String> set, Map<String, String> subNameMap, String name, String email) {
        int nameLength = name.length();
        for (int i = 0; i < nameLength-1; i++) {
            //연속된 2글자씩 끊어서 Map에 저장
            String subName = name.substring(i, i + 2);
            if (subNameMap.containsKey(subName)) {
                //Map에 연속된 동일한 글자가 있을시 set에 저장
                set.add(email);
                set.add(subNameMap.get(subName));
                continue;
            }
            subNameMap.put(subName, email);
        }
    }
}
