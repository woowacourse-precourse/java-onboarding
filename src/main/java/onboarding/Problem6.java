package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<Integer> divideAndCompareName(List<List<String>> forms) {
        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String firstPerson = forms.get(i).get(1);
            if (firstPerson.length() == 1) {
                continue;
            }
            for (int x = i + 1; x < forms.size(); x++) {
                String secondPerson = forms.get(x).get(1);
                if (secondPerson.length() == 1) {
                    continue;
                }
                for (int y = 0; y <= firstPerson.length() - 2; y++) {
                    for (int z = 0; z <= secondPerson.length() - 2; z++) {
                        if (firstPerson.substring(y, y + 2).equals(secondPerson.substring(z, z + 2))) {
                            index.add(i);
                            index.add(x);
                        }
                    }
                }
            }
        }
        return index;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of());
        // 1. 이름 2글자씩 나눈 후 비교. 중복되는 이름의 인덱스 리턴
        List<Integer> index = divideAndCompareName(forms);

        // 2. index 중복 제거
        // 3. index 로 이메일 값 가져옴
        // 4. 사전순 정렬

        return answer;
    }
}
