package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
	
    public static List<String> solution(List<List<String>> forms) {

    	List<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        //(키워드 닉네임, 이메일) 형식으로 map에 저장
        
        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for(int i=0;i<nickname.length()-1;i++) {
                String keyword = nickname.substring(i,i+2);
                //중복을 검사할 닉네임 2글자를 키워드에 순차적으로 저장 
                if(map.containsKey(keyword)) {
                    answer.add(email);
                    //중복 닉네임 설정된 이메일 저장
                    if(!answer.contains(map.get(keyword))) {
                        answer.add(map.get(keyword));
                        //이미 중복 닉네임으로 지장된 이메일인지 확인
                    }
                    break;
                }
                map.put(keyword, email);
            }
        }
        return answer;
    }
}
