package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = check(forms);

        return answer;
    }

    private static List<String> check(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for (int userLen = 0; userLen < forms.size(); userLen++) {
            String nickName = forms.get(userLen).get(1);

            for (int nameLen = 0; nameLen < nickName.length() - 1; nameLen++) {
                String nameSub = nickName.substring(nameLen, nameLen + 2);

                for (int userLen2 = userLen + 1; userLen2 < forms.size(); userLen2++) {

                    if (forms.get(userLen2).get(1).contains(nameSub)) {
                        emailList.add(forms.get(userLen).get(0));
                        emailList.add(forms.get(userLen2).get(0));
                    }
                }
            }
        }

        List<String> newEm = emailList.stream().distinct().collect(Collectors.toList());
        Collections.sort(newEm);

        return newEm;
    }
}
