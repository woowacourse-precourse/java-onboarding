package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p = new Problem6();
        List<String> answer = new ArrayList<>();

        // 닉네임 중 같은 글자가 연속적으로 포함 될 경우 닉네임 사용 제한
        // 같은 글자가 연속적으로 포함되는 닉네임 지원자의 이메일을 리턴.

        // 해시맵에 key - 이름, value - 이메일로 한다음에
        Map<String, String> formMaps = p.insertMap(forms);

        // 어레이리스트에 이름만 저장
        String[] names = p.seperateName(forms);
        Set<String> overlapName = p.overlap(names);
        for (String s : overlapName) {
            answer.add(formMaps.get(s));
        }
        answer.sort(Comparator.naturalOrder());

        // 반복문 돌리면서 해보자.
        return answer;
    }

    // List<List<String>>을 HashMap으로 변환.
    public Map<String, String> insertMap(List<List<String>> forms) {
        Map<String, String> formMaps = new HashMap<>();
        for (List<String> form : forms) {
            formMaps.put(form.get(1), form.get(0));
        }
        return formMaps;
    }

    // 범위를 알고있으니 array에 반환
    public String[] seperateName(List<List<String>> forms) {
        String[] names = new String[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            names[i] = forms.get(i).get(1);
        }
        return names;
    }

    // 중복 이름 찾기
    public Set<String> overlap(String[] names) {
        Set<String> overlap = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            char[] charname = names[i].toCharArray();
            for (int j = i + 1; j < names.length; j++) {
                for (int k = 0; k < names[i].length() - 1; k++) {
                    String compareWord = Character.toString(charname[k]) + Character.toString(charname[k + 1]);
                    if (names[j].contains(compareWord)) {
                        overlap.add(names[i]);
                        overlap.add(names[j]);
                    }
                }
            }
        }
        return overlap;
    }
}
