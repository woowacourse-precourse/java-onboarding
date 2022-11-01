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
                //자른 닉네임 대로 HashMap에 맵핑
                //HashMap에 key값이 있을경우
                if(words.containsKey(s)){
                    //기존 values 리스트에 현재값을 추가
                    values = words.get(s);
                    values.add(email);
                    words.put(s,values);

                    //만약 values리스트의 개수가 2개 이상이라면 중복 리스트에 기존 이메일 추가
                    if(words.get(s).size() == 2){
                        answer.add(words.get(s).get(0));
                    }
                    //현재 이메일 추가
                    answer.add(form.get(0));
                //HashMap에 key값이 없을경우
                }else{
                    //현재 이메일을 value에 넣고 HashMap 업데이트
                    values.add(email);
                    words.put(s,values);
                }
            }
        }
        //오름차순으로 정렬
        Collections.sort(answer);
        //중복 제거
        Set<String> set = new HashSet<String>(answer);
        return answer;
    }
}
