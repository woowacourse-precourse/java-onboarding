package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of();
        HashMap<String, List<String>> dupMap = new HashMap<String, List<String>>();
        HashSet<String> emailSet = new HashSet<String>();


        for(List<String> crew: forms){
            String email = crew.get(0);
            String name = crew.get(1);

            for(int i=0; i<name.length()-1; i++){
                String keyStr = name.substring(i, i+2);
                List<String> update = dupMap.get(keyStr);
                if(update == null){
                    update = new ArrayList<String>();
                }
                update.add(email);
                dupMap.put(name.substring(i, i+2), update);
            }
        }

        List<String> key = new ArrayList<String>(dupMap.keySet());

        for(String keyStr : key){
            List<String> email = dupMap.get(keyStr);
            if(dupMap.get(keyStr).size()>2){
                emailSet.addAll(email);
            }
        }

        answer = new ArrayList<String>(emailSet);

        answer.sort(Comparator.naturalOrder());


        return answer;
    }
}
