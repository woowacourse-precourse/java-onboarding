package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6 {
    // createToken 길이가 2인 부분 문자열 생성하는 메소드
    public static List<String> createToken(String nickname) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            result.add(nickname.substring(i, i + 2));
        }

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        // TODO email.com 인 경우만 처리

        // forms 필터링
        forms = new ArrayList<>(forms);
        forms.removeIf(n -> (!n.get(0).split("@")[1].equals("email.com")));

        TreeSet<String> treeSet = new TreeSet<>();

        // 같은 글자가 연속으로 포함되는지 체크
        // 2글자 이상이 부분 문자열로 들어가는지 체크
        // 한 사람 당 [0,1], [1,2], ..., [18,19] 19개의 연속 부분 단어 생성 가능.
        // 길이가 2인 부분 문자열이므로, 부분 문자열 알고리즘을 사용할 필요 X

        // 한 사람 당 19개, 전체 길이 최대 19글자, 포함되는지 10_000 - 1 명에게 확인 20 * 10_000 * 19
        for (int i = 0; i < forms.size(); i++) {
            // 토큰(부분 문자열) 생성
            List<String> token = createToken(forms.get(i).get(1));

            for (int j = 0; j < forms.size(); j++) {
                if (i == j) {
                    continue;
                }
                // 토큰 마다 반복
                for (int k = 0; k < token.size(); k++) {
                    // 만약 들어간다면..추가
                    if (forms.get(j).get(1).contains(token.get(k))) {
                        treeSet.add(forms.get(i).get(0));
                        treeSet.add(forms.get(j).get(0));
                        break;
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(treeSet);

        // 오름차 순으로 정렬 -> 중복 제거
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠"),
                List.of("nowm@naver.com", "이제엠오")
        );
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        System.out.println(result);
        assertThat(Problem6.solution(forms)).isEqualTo(result);
    }
}
