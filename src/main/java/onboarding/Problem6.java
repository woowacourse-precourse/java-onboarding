package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // 메일이 중복되지 않게 담을 세트 생성
        HashSet<String> duplicated = new HashSet<String>();

        //리스트 순회

        for(int i = 0; i < forms.size()-1; i++){
            // 기준 단어
            String standard = forms.get(i).get(1);

            for(int k = 1; k < forms.size(); k++) {
                // 비교 단어
                String compare = forms.get(k).get(1);

                // 기준 단어와 비교 단어가 동일할 경우 pass
                if(standard == compare) {continue;}

                // 기준 단어에서 2글자 조합 추출하여 비교 단어에 중복된 값이 있는지 검사
                for (int j = 0; j < standard.length() - 1; j++) {
                    String comb = standard.substring(j, j + 2);

                    if (compare.contains(comb)) {
                        duplicated.add(forms.get(i).get(0));
                    }
                }
            }
        }

        // 해시셋 리스트로 변환후 오름차순 정렬하여 반환
        List<String> answer = new ArrayList<>(duplicated);
        Collections.sort(answer);
        return answer;
    }



}
