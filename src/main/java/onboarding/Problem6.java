package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> nameList = separateNames(forms);
        List<String> reduNameList = reduplicatedNames(nameList);
        List<String> emailList = findEmails(reduNameList, forms);

        return emailList;
    }

    /**
     * 닉네임을 두 글자씩 변환
     * @param forms
     * @return List<String>
     */
    private static List<String> separateNames(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                nameList.add(name.substring(j, j + 2));
            }
        }
        return nameList;
    }
}
