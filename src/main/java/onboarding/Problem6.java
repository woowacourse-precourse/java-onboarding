package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    HashMap<String, ArrayList<Integer>> charToIndices = new HashMap<String, ArrayList<Integer>>();  // charToIndices 생성 : {두 글자 : [닉네임 인덱스]}

    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem = new Problem6();

        /* 제한 사항 처리 */
        forms = except(forms);

        for (int i = 0; i < forms.size(); i++) {
            problem.updateEvery2SequentialChar(i, forms.get(i).get(1)); // 닉네임에서 2글자씩 분절해  charToIndices에 추가
        }

        /* 길이가 2이상인 Index 배열 반환 */
        List<Integer> answerIndices = problem.charToIndices.values()
                .stream()
                .filter(intList -> intList.size() > 1)
                .findFirst()
                .orElse(new ArrayList<>());
        if (answerIndices.size() == 0) { // 중복 닉네임이 없는 경우 빈 리스트 return
            return Collections.emptyList();
        }

        /* 중복 닉네임 크루의 email 리스트 */
        List<List<String>> finalForms = forms;
        List<String> emails = answerIndices.stream()
                .map(i -> finalForms.get(i).get(0)) //
                .collect(Collectors.toList());

        /* email 중복 제거 & 오름차순 정렬 */
        TreeSet<String> distinceAnswer = new TreeSet<>(emails);
        emails = new ArrayList(distinceAnswer);
        return emails;
    }

    static List<List<String>> except(List<List<String>> forms) {
        return forms.stream()
                .filter(form -> getEmailDomain(form.get(0)).equals("email.com"))
                .collect(Collectors.toList());
    }

    static String getEmailDomain(String email) {
        return email.split("@")[1];
    }

    void updateEvery2SequentialChar(int formIdx, String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String key = nickname.substring(i, i + 2);
            ArrayList<Integer> formIndices = new ArrayList<>();
            if (this.charToIndices.containsKey(key)) {
                formIndices = this.charToIndices.get(key);
            }
            formIndices.add(formIdx);
            this.charToIndices.put(key, formIndices);
        }
    }
}
