package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // forms를 복사한 리스트
        List<List<String>> checkList = new ArrayList<>();
        checkList = forms;
        checkList.remove(0);
        System.out.println(checkList);
        // 전체 리스트를 나누는 for문 , 복사한 리스트를 for문에 돌리고 중복이 확인되면 삭제
        for (List<String> member : checkList) {
            String email = member.get(0);
            String aka = member.get(1);

            // 0부터 forms size - 1까지의 숫자가 잇는 배열
            int[] location = new int[forms.size()];
            Arrays.setAll(location, l -> l);

            // 안의 리스트의 닉네임을 2글자별로 나누기위한 for문
            for (int i = 1; i <= aka.length(); i++) {
                // 두글자
                String search = "";
                search += aka.charAt(i - 1);
                search += aka.charAt(i);

                // 2글자를 다른 닉네임과 비교하기위한 for문
                for (int s : location) {
                    // 단어 찾기, 같은 index의 값은 삭제 안함
                    if (forms.get(s).get(1).contains(search) && email != forms.get(s).get(0)) {
                        location = removeElement(location, s); // location 검색항목에서 재거
                        checkList.remove(s); // checkList 검색항목에도 제거
                    }
                }
            }
        }
        // for문이 끝나면 checkList에는 중복되지 않은 값만 남음
        for (List<String> ls : checkList) {
            forms.remove(ls);
        }
        for (int a = 0; a < forms.size(); a++) {
            answer.add(forms.get(a).get(0));
        }
        Collections.sort(answer);

        return answer;
    }

    // 요소 재거
    public static int[] removeElement(int[] arr, int item) {
        return Arrays.stream(arr)
                .filter(i -> i != item)
                .toArray();
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"));
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        System.out.println(solution(forms));
    }
}
