package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++){
            List<String> member = forms.get(i);
            String nickname = member.get(1);
            for(int j = 1; j < nickname.length(); j++){
                String tmp = nickname.substring(j - 1, j + 1);
                for(int k = i + 1; k < forms.size(); k++){
                    List<String> tmpMember = forms.get(k);
                    String tmpNickname = tmpMember.get(1);
                    if(tmpNickname.contains(tmp)){
                        answer.add(member.get(0));
                        answer.add(tmpMember.get(0));
                    }
                }
            }
        }

        Set<String> set = new HashSet<String>(answer);
        answer = new ArrayList<>(set);

        Collections.sort(answer);
        return answer;
    }
}
