package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> temp_answer = new HashSet<>();

        for(List<String> user : forms) {
            List<String> word_combi = createWordCombi(user.get(1));
            Set<String> dup_member = checkDuplicateNickname(forms, word_combi, forms.indexOf(user));
            temp_answer.addAll(dup_member);
        }

        List<String> answer = new ArrayList<>(temp_answer);
        Collections.sort(answer);
        return answer;
    }

    public static Set<String> checkDuplicateNickname(List<List<String>> forms, List<String> word_combi, int iter) {
        Set<String> dup_member = new HashSet<>();

        for(int i = iter+1; i < forms.size(); i++) {
            for(String word : word_combi) {
                if(forms.get(i).get(1).contains(word)) {
                    dup_member.add(forms.get(iter).get(0));
                    dup_member.add(forms.get(i).get(0));
                }
            }
        }
        return dup_member;
    }

    public static List<String> createWordCombi(String nickname) {
        List<String> word_combi = new ArrayList<>();

        word_combi.add(nickname);
        for(int i = 0; i < nickname.length() - 1; i++) {
            word_combi.add(nickname.substring(i,i+2));
        }

        return word_combi;
    }
}
