package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i=0;i<forms.size();i++){
            if (forms.get(i).get(1).length() < 2){
                continue;
            }
            for (int j=0;j<forms.get(i).get(1).length()-1;j++){
                String subword = forms.get(i).get(1).substring(j,j+2);
                if (set.contains(subword)){
                    map.get(subword).add(forms.get(i).get(0));
                }
                else {
                    set.add(subword);
                    List <String> emailList = new ArrayList<>();
                    emailList.add(forms.get(i).get(0));
                    map.put(subword, emailList);
                }
            }
        }
        HashSet<String> notOrderAnswer = new HashSet<>();
        for (List<String> s: map.values()){
            if (s.size() >= 2){
                notOrderAnswer.addAll(s);
            }
        }
        List<String> answer = new ArrayList<>(notOrderAnswer);
        Collections.sort(answer);
        return answer;
    }
}
