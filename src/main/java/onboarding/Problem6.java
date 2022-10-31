package onboarding;

import java.util.*;

public class Problem6 {

    private static void combine(Set<String> totalCombination, String nickname){

        for (int i = 0; i < nickname.length()-1; i++) {
            String name = "";
            name += nickname.charAt(i);
            name += nickname.charAt(i+1);

            totalCombination.add(name);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer1 = new HashSet<>(); // 중복을 제거하기 위해 set 사용

        for (int i = 0; i < forms.size(); i++) {
            // 본인 닉네임을 제외한 닉네임들로 조합 생성
            Set<String> totalCombination = new HashSet<>();
            for (int j = 0; j < forms.size(); j++) {
                if(j != i) {
                    combine(totalCombination, forms.get(j).get(1));
                }
            }

            Set<String> userCombination = new HashSet<>();
            combine(userCombination, forms.get(i).get(1));

            for (String key : userCombination) {
                if (totalCombination.contains(key)) answer1.add(forms.get(i).get(0));
            }
        }

        // Set을 List로 변경
        List<String> answer2 =new ArrayList<String>(answer1);
        // 정렬
        Collections.sort(answer2);

        return answer2;
    }
}
