package onboarding;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {

    static List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
    );
    static Set<String> emails = new HashSet<>();
    static Map<String, String> nameMap = new HashMap<>();

    // solution 테스트
    @Test
    void solution() {
        checkNicknames(forms);
        List<String> answer = new ArrayList<>(emails);
        answer.sort(Comparator.naturalOrder());
        System.out.println("end");
    }

    // 닉네임 2글자씩 나누어 중복 체크 함수 호출
    private void checkNicknames(List<List<String>> forms) {
        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);              // 닉네임

            for (int j=0; j<name.length()-1; j++){
                String nameSlice = name.substring(j,j+2);   // 닉네임 2글자씩 자르기
                checkNameMap(nameSlice, i);                 // 자른 이름 중복 체크
            }
        }
    }

    // 중복 체크
    private void checkNameMap(String nameSlice, int i) {
        if (nameMap.containsKey(nameSlice)) {       // 이름 2글자가 중복된다면
            emails.add(nameMap.get(nameSlice));     // answer 배열에 중복되는 이름 있는 메일 추가
            emails.add(forms.get(i).get(0));        // 체크하는 현재 메일도 추가
        }
        if (!nameMap.containsKey(nameSlice)) {      // 중복 이름이 없다면
            nameMap.put(nameSlice, forms.get(i).get(0)); // hashmap에 새로운 key 저장
        }
    }

}