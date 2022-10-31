package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        //두 단어로 끊어서 해쉬맵에 저장하고, 해쉬맵에 이미 존재한다면, 중복을 허용하지 않는 셋에 추가해서 저장

        HashMap<String,String> checkDuplicate = new HashMap<>();
        HashSet<String> emailList = new HashSet<>();
        for (List<String> form : forms){
            String email =  form.get(0);
            String nickName = form.get(1);
            for (int i=0; i<nickName.length()-1; i++){
                String cutName = nickName.substring(i,i+2);
                boolean isDuplicate = checkDuplicate.containsKey(cutName);
                if(!isDuplicate)
                    checkDuplicate.put(cutName, email);
                else {
                    //추가
                    emailList.add(checkDuplicate.get(cutName));
                    emailList.add(email);
                }
            }

        }
        answer = new ArrayList<>(emailList);
        Collections.sort(answer);

        return answer;
    }
}
