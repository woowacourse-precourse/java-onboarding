package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> duplicate = new HashMap<>();

        for(int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);

            for(int j = 0; j < name.length()-1; j++){
                String temp = String.valueOf(name.charAt(j)) + String.valueOf(name.charAt(j+1));
                if(duplicate.containsKey(temp)) duplicate.put(temp, duplicate.get(temp)+1);
                else duplicate.put(temp, 1);
            }
        }

        for(int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            for(int j = 0; j < name.length()-1; j++){
                String temp = String.valueOf(name.charAt(j)) + String.valueOf(name.charAt(j+1));
                if(duplicate.get(temp) != 1){
                    answer.add(email);
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
