package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem6 {
    // HashMap<String, ArrayList<Integer>> charToIndices 생성 : {두 글자 : [닉네임 인덱스]}
    HashMap<String, ArrayList<Integer>> charToIndices = new HashMap<String, ArrayList<Integer>>();
    public static List<String> solution(List<List<String>> forms) {
        /* 제한 사항 처리 */
        forms = except(forms);

        Problem6 problem = new Problem6();
        for (int i = 0; i < forms.size(); i++) {
            problem.updateEvery2SequentialChar(i, forms.get(i).get(1)); // 닉네임에서 2글자씩 분절해  charToIndices에 추가
        }
        
        List<Integer> answerIndices = problem.getDuplicateIndices();

        // answer 배열 생성
        List<String> answer = new ArrayList<>();
        // Index 배열을 이용해 answer에 email add
        for (int i : answerIndices) {
            answer.add(forms.get(i).get(0));
        }
        // 중복 제거 & 오름차순 정렬
        TreeSet<String> distinceAnswer = new TreeSet<>(answer);
        answer = new ArrayList<String>(distinceAnswer);
        return answer;
    }

    static List<List<String>> except(List<List<String>> forms) {
        List<List<String>> newForms = new ArrayList<>();
        for (List<String> form : forms) {
            if (getEmailDomain(form.get(0)).equals("email.com")) {
                newForms.add(form);
            }
        }
        return newForms;
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

    List<Integer> getDuplicateIndices() {
        return this.charToIndices.values().stream()
                    .filter(intList -> intList.size() > 1)  // 길이가 2이상인 Index 배열 반환
                    .findFirst()
                    .orElse(new ArrayList<>());
    }

}
