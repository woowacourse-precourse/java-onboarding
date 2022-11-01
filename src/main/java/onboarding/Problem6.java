package onboarding;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, String> convertToMap(List<List<String>> forms){
            
        Map<String, String> formsMap = forms.stream()
                .collect(Collectors.toMap(k->k.get(0), v->v.get(1)));

        return formsMap;
    }


    public static List<String> checkDuplicates(Map<String, String> formsMap){
        List<String> emailArray = new ArrayList<>();
        String email = "";
        String name = "";

        //이름이 겹치는 사용자 이메일 추가하기
        for(Map.Entry<String, String> cur_elem : formsMap.entrySet()){

            if(emailArray.contains(cur_elem.getKey())) continue;

            email = cur_elem.getKey();
            name = cur_elem.getValue();
            boolean duplChecked = false;

            //다른 이름과 비교
            for(Map.Entry<String, String> check_elem : formsMap.entrySet()){
                for(int i=0;i<name.length()-1;i++){
                    String compare_part = name.substring(i,i+2);

                    if(check_elem.getValue().contains(compare_part)
                            &&!email.equals(check_elem.getKey())){
                        emailArray.add(email);
                        if(!emailArray.contains(check_elem.getKey())){
                            emailArray.add(check_elem.getKey());
                        }
                        duplChecked = true;
                        break;
                    }
                }
                if(duplChecked ==true) break;
            }
        }

        return emailArray;
    }


}
