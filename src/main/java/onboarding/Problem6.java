package onboarding;

import java.util.*;

public class Problem6 {

    static Set<String> emails;
    static Map<String, String> nameMap;

    public static List<String> solution(List<List<String>> forms) {
        emails = new HashSet<>();            // 중복 체크된 메일 저장
        nameMap = new HashMap<>();           // 닉네임 중복 체크용 데이터 저장
        checkNicknames(forms);

        List<String> answer = new ArrayList<>(emails);
        answer.sort(Comparator.naturalOrder()); // answer 배열 정렬

        return answer;
    }

    private static void checkNicknames(List<List<String>> forms) {
        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);      // 닉네임
            String email = forms.get(i).get(0);     // 메일

            for (int j=0; j<name.length()-1; j++){
                String nameSlice = name.substring(j,j+2);       // 닉네임 2글자씩 자르기
                checkNameMap(nameSlice, email);                  // 자른 이름 중복 체크 함수 호출
            }
        }
    }

    private static void checkNameMap(String nameSlice, String email) {
        if (nameMap.containsKey(nameSlice)) {       // 이름 2글자가 중복된다면,
            emails.add(nameMap.get(nameSlice));         // answer 배열에 중복되는 이름 있는 메일 추가
            emails.add(email);                           // 체크하는 현재 메일도 추가
        }
        if (!nameMap.containsKey(nameSlice)) {      // 중복 이름이 없다면
            nameMap.put(nameSlice, email);              // hashmap에 새로운 key 저장
        }
    }
}
