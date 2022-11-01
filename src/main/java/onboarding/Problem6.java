package onboarding;
import java.util.*;


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Set<String> alarm = new HashSet<>(Collections.emptySet());

        HashMap<String, Set<String>> checkRedundant = new HashMap<>();
        for(var form : forms){
            String[] name = form.get(1).split("");
            String prev = "";
            for(int i = 0; i<name.length; i++){
                if(i!=0){
                    String word = prev + name[i];
                    if(!checkRedundant.containsKey(word))
                        checkRedundant.put(word, Set.of(form.get(0)));
                    else{
                        Set<String> set = new HashSet<>(Collections.emptySet());
                        set.addAll(checkRedundant.get(word));
                        set.add(form.get(0));
                        checkRedundant.put(word, set);
                        alarm.addAll(set);
                    }
                }
                prev = name[i];
            }
        }
        answer.addAll(alarm);
        Collections.sort(answer);
        return answer;
    }
}