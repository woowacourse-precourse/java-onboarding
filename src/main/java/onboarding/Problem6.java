package onboarding;

import java.util.*;

public class Problem6 {
    static Set<Integer> set = new HashSet<>();
    static Map<String, Integer> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++) {
            duplicatedName(forms.get(i).get(1), i);
        }

        for (Integer integer : set) {
            answer.add(forms.get(integer).get(0));
        }

        Collections.sort(answer);

        return answer;
    }
    private static void duplicatedName(String name, int index) {
        for(int i = 0; i < name.length() - 1; i++) { // 문자열을 두글자씩 잘라서 비교 제이슨 -> 제이, 이슨
            String duplicated = name.substring(i, i + 2);

            if(!map.containsKey(duplicated)) { // 키가 없으면 map에 삽입
                map.put(duplicated, index);
            }else{ // 키가 map에 이미 존재하면 set에 삽입
                set.add(index);
                set.add(map.get(duplicated)); // map에 이미 존재하는 키도 가져옴
            }
        }
    }
}
