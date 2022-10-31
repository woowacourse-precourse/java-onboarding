package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);

            for (int j = 0; j < nickName.length() - 1; j++) {   //이름을 각 간격으로 쪼갠다.
                String subName = nickName.substring(j, j + 2);
                answer.addAll(findDuplicatedNickName(forms, subName, i));
            }

        }

        return answer;
    }

    /**
     * 중복된이름이 포함되는 부분을 찾아낸다.
     * @param forms
     * @param subName
     * @param index
     * @return
     */
    private static List<String> findDuplicatedNickName(List<List<String>> forms, String subName, int index) {
        List<String> list = new ArrayList<>();
        for (int i = index + 1; i < forms.size(); i++) {
            List<String> member = forms.get(i);

            if (member.get(1).contains(subName)){
                list.add(member.get(0));
            }
        }
        if (list.size() > 0){
            list.add(forms.get(index).get(0));
        }

        return list;
    }


}
