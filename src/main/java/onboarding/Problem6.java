package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = Collections.emptyList();

        if(forms.size() == 1)
            return answer;

        Map<String, Integer> existNicknameMap = new HashMap<>();
        Set<String> emailSet = new HashSet<>();

        for(int i=0; i<forms.size(); i++) {
            List<String> info = forms.get(i);
            String nickname = info.get(1);

            for(int j=0; j<nickname.length()-1; j++) {
                String twoWords = nickname.substring(j, j+2);
                int index = getIndexOfExistNickname(existNicknameMap, twoWords);

                if(index == -1)
                    existNicknameMap.put(twoWords, i);

                if(index != -1) {
                    emailSet.add(getEmailByIndex(forms, i));
                    emailSet.add(getEmailByIndex(forms, index));
                }
            }
        }

        answer = setToArrayList(emailSet);

        return answer;
    }

    public static int getIndexOfExistNickname(Map<String, Integer> existNicknameMap, String twoWords) {

        if(existNicknameMap.containsKey(twoWords))
            return existNicknameMap.get(twoWords);

        return -1;
    }

    public static String getEmailByIndex(List<List<String>> forms, int index) {
        return forms.get(index).get(0);
    }

    public static List<String> setToArrayList(Set<String> emailSet) {

        List<String> emailList = new ArrayList<>(emailSet);
        emailList.sort(Comparator.naturalOrder());

        return emailList;
    }
}
