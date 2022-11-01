package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        solution(forms);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> emailSet = new HashSet<>();
        HashSet<String> duplicatedWordsSet = new HashSet<>();
        String[] arrayEmail = new String[forms.size()];
        String[] arrayName = new String[forms.size()];

        // 배열로 이메일, 이름 따로 분류
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).size(); j++) {
                arrayEmail[i] = forms.get(i).get(0);
                arrayName[i] = forms.get(i).get(1);
            }
        }

        // 이름마다 두 글자씩 분리해서 HashSet에 저장
        for (int i = 0; i < arrayName.length; i++) {
            String name = arrayName[i];
            for (int j = 0, x = 2; j < name.length() - 1; j++) {
                String duplicatedWord = name.substring(j, x++);
                duplicatedWordsSet.add(duplicatedWord);
            }
        }

        // 이름 하나씩 비교하면서 중복된 글자가 2개 이상 있으면 이메일을 저장
        Iterator it = duplicatedWordsSet.iterator();
        while (it.hasNext()) {
            int i = 0;
            String part = (String) it.next();
            ArrayList<Integer> arrayListIdx = new ArrayList<>();
            for (i = 0; i < arrayName.length; i++) {
                if (arrayName[i].contains(part)) {
                    arrayListIdx.add(i);
                }
            }
            if (arrayListIdx.size() >= 2) {
                for (int j = 0; j < arrayListIdx.size(); j++) {
                    emailSet.add(arrayEmail[j]);
                }
            }
            arrayListIdx.clear();
        }

        // 중복된 닉네임의 이메일을 정렬하기 위해서 ArrayList로 이동
        Iterator it2 = emailSet.iterator();
        while (it2.hasNext()) {
            String part = (String) it.next();
            answer.add(part);
        }


        return answer;
    }

}
