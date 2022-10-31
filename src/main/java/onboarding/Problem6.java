package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> set = new HashSet<>(); // 이메일을 담을 set
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<forms.size()-1; i++){
            String name = forms.get(i).get(1);  //제이엠
            if(name.length() < 2){ // 한글자인 경우
                break;
            }
            for(int j=0; j<name.length()-1; j++){
                String sub_name = name.substring(j, j+2); // 이름의 substring을 설정
                if(map.containsKey(sub_name)){
                    String email = map.get(sub_name);
                    if(!email.equals(forms.get(i).get(0))){
                        set.add(email);
                        set.add(forms.get(i).get(0));   // 같은 sub_name을 가진 유저의 이메일 set에 add
                    }
                }
                map.put(sub_name, forms.get(i).get(0));
            }
        }

        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }
}
