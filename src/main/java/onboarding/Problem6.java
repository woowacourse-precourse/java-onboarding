package onboarding;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        for(int i=0;i<forms.size(); i++){
            if (vaildEmail(forms.get(i).get(0))){
                String name = forms.get(i).get(1);
                for(int j=0; j<name.length()-1; j++){
                    String w_2 = name.substring(j, j+2);
                    table.put(w_2, table.containsKey(w_2) ? table.get(w_2)+1 : 1);
                }
            }
        }
        Map<String,Integer> temp =  table.entrySet()
                .stream().filter(x->x.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<String> keyList = new ArrayList<String>(temp.keySet());
        List<String> answer = new ArrayList<String>();
        for(int i=0;i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            for (int k=0; k<keyList.size();k++){
                if (name.contains(keyList.get(k))){
                    answer.add(email);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static boolean vaildEmail(String email){
        String regx = "^(.+)@email.com";
        Pattern pattern = Pattern.compile(regx);
        Matcher result = pattern.matcher(email);
        return result.matches();
    }
}
