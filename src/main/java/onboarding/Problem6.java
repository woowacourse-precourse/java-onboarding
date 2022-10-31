package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        Map<String, Integer> names = new HashMap<>();

        for(List<String> form : forms){
            for(int i=0; i<form.get(1).length()-1; i++){
                String twoLetters = form.get(1).substring(i, i+2);
                if(!names.containsKey(twoLetters)){
                    names.put(twoLetters, 1);
                }else{
                    names.put(twoLetters, names.get(twoLetters) + 1);
                }
            }
        }

        List<String> duplication = new ArrayList<>();

        for (Map.Entry<String, Integer> name : names.entrySet()) {
            if(name.getValue() > 1){
                duplication.add(name.getKey());
            }
        }

        for(List<String> form : forms){
            for(int i=0; i<duplication.size(); i++){
                if(form.get(1).contains(duplication.get(i))){
                    answer.add(form.get(0));
                    break;
                }
            }
        }

        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }
}
