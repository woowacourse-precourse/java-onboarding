package onboarding;

import java.util.*;

public class Problem6 {
    public TreeSet<String> solution2(List<List<String>> form){
        Map<String, String> map = new HashMap<>();
        TreeSet<String> result = new TreeSet<>();

        for(List<String> name : form){
            for(int i=0; i <= name.get(1).length()-2; i++){
                String matchName = name.get(1).substring(i,i+2);
                if(map.get(matchName) != null){
                    result.add(name.get(0));
                    result.add(map.get(matchName));
                } else {
                    map.put(matchName, name.get(0));
                }
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p = new Problem6();
        List<String> answer = new ArrayList<>();

        TreeSet<String> list = p.solution2(forms);
        for(String item : list) answer.add(item);

        return answer;
    }
}
