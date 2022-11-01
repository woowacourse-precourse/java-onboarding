package onboarding;

import java.util.*;

public class Problem6 {

    /*
    * 이름을 2글자씩 분리하여 중복된 닉네임이 있는지 검사한 후 중복된 지원자의 이메일 목록을 반환한다.
    * parameter : List<List<String>> (지원자(이메일-닉네임) 리스트)
    * return : List<String> (중복된 닉네임을 가진 이메일 리스트)*/
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Map<String, String> nameDuplication = new HashMap<>();

        // forms 를 하나씩 순회하면서 닉네임을 2글자씩 분리하여 중복 검사
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subset = nickname.substring(i, i+2);

                // 닉네임이 중복될 시
                if (nameDuplication.containsKey(subset) && !nameDuplication.get(subset).equals(email)) {
                    result.add(email);

                    // 중복되는 상대방도 List 에 추가
                    if (!result.contains(nameDuplication.get(subset)))
                        result.add(nameDuplication.get(subset));
                    break;
                }
                // 2글자 중복이 아닐 시
                else {
                    nameDuplication.put(subset, email);
                }
            }
        }
        // 이메일 오름차순으로 정렬
        Collections.sort(result);

        return result;
    }
}
