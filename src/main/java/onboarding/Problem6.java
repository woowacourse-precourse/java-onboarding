package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Problem6 {

    static HashMap<String, List<String>> fragmentMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        makeMap(forms);

        for (String fragment : fragmentMap.keySet()) {
            List<String> emailList = fragmentMap.get(fragment);
            if (emailList.size() >= 2) {
                answer.addAll(emailList);
            }
        }

        Collections.sort(answer);
        return answer;
    }

    /**
     * 이름에서 중복되는 이름 조각을 key로 이메일을 value 로 가지는 fragmentMap 을 생성하는 메서드
     *
     * @param forms 이름과 이메일이 담긴 리스트
     */
    public static void makeMap(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {

            String currentName = forms.get(i).get(1);
            String currentEmail = forms.get(i).get(0);

            for (int j = 1; j < currentName.length(); j++) {
                String fragment = String.valueOf(currentName.charAt(j - 1)) + currentName.charAt(j);
                if (fragmentMap.containsKey(fragment)) {
                    fragmentMap.get(fragment).add(currentEmail);
                } else{
                    List<String> emailList = new ArrayList<>();
                    emailList.add(currentEmail);
                    fragmentMap.put(fragment, emailList);
                }
            }
        }

    }
}
