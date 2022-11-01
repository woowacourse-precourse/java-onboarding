package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        for (int i = 0; i<forms.size(); i++) {
            List<String> name = forms.get(i);
            for(int j = i + 1; j<forms.size(); j++) {

                List<String> target = forms.get(j);

                // 중복 검사
                if (name.get(1) != target.get(1) && isDuplicate(name.get(1),target.get(1))) {
                    addUnique(answer, name.get(0));
                    addUnique(answer, target.get(0));
                }
            }
        }
        // 정렬
        answer.sort(String.CASE_INSENSITIVE_ORDER);
        return answer;
    }

    private static boolean isDuplicate(String name, String target) {
        for(int i = 0; i < name.length() - 1; i++) {
            for (int j = 0; j < target.length() - 1; j++) {
                if (name.substring(i,i+2).equals(target.substring(j,j+2)))
                    return true;
            }
        }
        return false;
    }

    private static void addUnique(List<String> emailList, String email) {
        if (!emailList.contains(email))
            emailList.add(email);
    }

}
