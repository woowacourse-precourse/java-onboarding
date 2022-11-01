package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> email_list = new HashSet<>();
        HashMap<String,String> map = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            String name = forms.get(i).get(1);

            for(int j=0;j<name.length()-1;j++){
                String sub_name = name.substring(j,j+2);
                if(map.containsKey(sub_name)){
                    email_list.add(map.get(sub_name));
                    email_list.add(forms.get(i).get(0));
                }else{
                    map.put(sub_name,forms.get(i).get(0));
                }
            }
        }

        List<String> answer = new ArrayList<>(email_list);
        Collections.sort(answer);

        return answer;
    }
}
