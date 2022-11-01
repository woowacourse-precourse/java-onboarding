package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        //{"제이":["jason@email.com", "jm@email.com", "mj@email.com"]}과 같은 형태를 만들고자 HashMap 선언
        HashMap<String,List<String>> words = new HashMap<>();

        //주어진 forms 이차원 배열 반복문
        for (List<String> form : forms) {

            //첫번째값은 이메일, 두번재값은 인덱스로 지정
            String email = form.get(0);
            String nickname = form.get(1);

            //2글자 간격으로 닉네임 자르기
            for(int i=0; i<nickname.length()-1; i++){
                String s = nickname.substring(i,i+2);
                //value값에 들어갈 리스트 선언
                List<String> values = new ArrayList<>();
                //
                if(words.containsKey(s)){
                    values = words.get(s);
                    values.add(email);
                    words.put(s,values);

                    if(words.get(s).size() == 2){
                        answer.add(words.get(s).get(0));
                    }
                    answer.add(form.get(0));
                }else{
                    values.add(email);
                    words.put(s,values);
                }
            }
        }
        Collections.sort(answer);
        Set<String> set = new HashSet<String>(answer);
        return answer;
    }
}
