package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms)  {
        try{
            valid(forms);
            List<String> answer = new ArrayList<>();
            Map<String, Long> map = new HashMap<>();  //중복 아이디 사전


            for(List<String> list : forms){ //입력된 모든 아이디 사전을 만들어야함
                String email = list.get(0), id = list.get(1);
                for(int i = 0; i < id.length()-1; i++){
                    String s = id.substring(i, i+2);
                    map.put(s, map.getOrDefault(s, 0L) +1L);
                }
            }

            for(List<String> list: forms) { //앞에 만든 사전을 이용해 사전에 있는 단어인지 확인한다.
                String email = list.get(0), id = list.get(1);
                for(int i = 0; i < id.length()-1; i++){
                    String s = id.substring(i, i+2);
                    if(map.get(s) >= 2 && !answer.contains(email)){
                        answer.add(email);
                        break;
                    }
                }
            }

            //이메일 정렬
            Collections.sort(answer);
            return answer;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }

    }
    public static void valid(List<List<String>> lists) throws Exception {
        if(lists.size() < 1 || lists.size() > 10000){
            throw new Exception("입력받은 인원의 수가 조건에 맞지 않습니다: size: "+ lists.size());
        }
        String p_email = "\\b\\S{1,10}(@email.com){1}$";
        String p_id = "^[가-힣]{1,19}$";
        for(int i = 0; i < lists.size(); i++){
            String email = lists.get(i).get(0);
            String id = lists.get(i).get(1);
            if(!Pattern.matches(p_email, email)){
                throw new Exception("입력받은 이메일이 조건에 맞지 않습니다. : "+ email);
            }
            if(!Pattern.matches(p_id, id)){
                throw new Exception("입력받은 아이디가 조건에 맞지 않습니다. : " + id);
            }
        }

    }
}
