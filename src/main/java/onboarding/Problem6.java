package onboarding;

import java.util.*;

public class Problem6 {

    private static void combine(Map<String, Integer> totalCombination, String nickname){

        for (int i = 0; i < nickname.length()-1; i++) {
            String name = "";
            name += nickname.charAt(i);
            name += nickname.charAt(i+1);

            totalCombination.put(name, 0);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            // 본인 닉네임을 제외한 닉네임들로 조합 생성
            Map<String, Integer> totalCombination = new HashMap<>();
            for (int j = 0; j < forms.size(); j++) {
                if(j != i) {
                    combine(totalCombination, forms.get(j).get(1));
                }
            }

            Map<String, Integer> userCombination = new HashMap<>();
            combine(userCombination, forms.get(i).get(1));

            for (String key : userCombination.keySet()) {
                if (totalCombination.containsKey(key)) answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
