package onboarding;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<Set<String>> user_word = new ArrayList<Set<String>>();
        Set<Integer> answer_adressSet = new HashSet<Integer>();
        List<String> answer_adressList = new ArrayList<String>();

        for (List<String> ls : forms) {
            String name = ls.get(1);
                Set<String> tempSet = new HashSet<String>();
            for (int i = 0; i < name.length() - 1; i++) {
                String two = name.substring(i, i + 2);
                tempSet.add(two);
            }
            user_word.add(tempSet);
        }

        int user_word_length=user_word.size();

        for (int i = 0; i < user_word_length - 1; i++) {
            for (int j = i+1; j < user_word_length; j++) {
                Set<String> intersection_set = new HashSet<String>(user_word.get(j));
                intersection_set.retainAll(user_word.get(i));
                if (!intersection_set.isEmpty()) {
                    answer_adressSet.add(i);
                    answer_adressSet.add(j);
                }
            }
        }

        for (int adress : answer_adressSet) {
            answer_adressList.add(forms.get(adress).get(0));
        }

        Collections.sort(answer_adressList);

        answer = answer_adressList;

        return answer;
    }
}
