package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Set<String> answer_set = new HashSet<>(Collections.emptySet());

        HashMap<String, Set<String>> seq_hash = new HashMap<>();
        for(var form : forms){
            String[] cha_list = form.get(1).split("");
            String prev = "";
            for(int i = 0; i<cha_list.length; i++){
                if(i!=0){
                    String word = prev + cha_list[i];
                    if(!seq_hash.containsKey(word))
                        seq_hash.put(word, Set.of(form.get(0)));
                    else{
                        Set<String> set = new HashSet<>(Collections.emptySet());
                        set.addAll(seq_hash.get(word));
                        set.add(form.get(0));
                        seq_hash.put(word, set);
                        answer_set.addAll(set);
                    }
                }
                prev = cha_list[i];
            }
        }
        answer.addAll(answer_set);
        Collections.sort(answer);
        return answer;
    }
}
