package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> nameDic = new HashMap<>();

        for(List<String> form: forms){
            nameDic.put(form.get(1), form.get(0));
        }

        List<String> values = new ArrayList<>(nameDic.keySet());
        Set<String> tmpAnswer = new HashSet<>();
        for(int i=0; i<values.size(); i++){
            String value = values.get(i);
            for(int charIdx=0; charIdx<value.length()-2; charIdx++){
                String sub = value.substring(charIdx, charIdx+2);

                for(int j=i+1; j<values.size(); j++){
                    if(tmpAnswer.contains(values.get(j)))
                        continue;

                    if(values.get(j).contains(sub)) {
                        tmpAnswer.add(values.get(i));
                        tmpAnswer.add(values.get(j));
                    }
                }
            }
        }

        Iterator<String> iter = tmpAnswer.iterator();
        while(iter.hasNext()){
            String nickname = iter.next();
            String email = nameDic.get(nickname);

            answer.add(email);
        }

        Collections.sort(answer);

        return answer;
    }
}
