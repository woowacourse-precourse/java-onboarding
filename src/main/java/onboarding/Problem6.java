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
            String email = info.get(0);
            String nickname = info.get(1);

            if(nickname.length() > 1) {
                for(int j=0; j<nickname.length()-1; j++) {
                    String twoWords = nickname.substring(j, j+2);

                    if (existNicknameMap.containsKey(twoWords)) {
                        emailSet.add(email);

                        Integer infoIndex = existNicknameMap.get(twoWords);
                        email = forms.get(infoIndex).get(0);
                        emailSet.add(email);
                    }
                    else
                        existNicknameMap.put(twoWords, i);
                }
            }
        }
        answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
