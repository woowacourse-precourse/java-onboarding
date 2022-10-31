package onboarding;

import java.util.*;


//기능목록
//1.해쉬맵에 모든 닉네임에서 연속되는 두 글자 씩을 잘라 키를 지정하고 값으로 1을 넣는다. 만약 키값이 이미 있다면 1을 더한다.
//2.해쉬맵의 키값으로 반복문을 돌아 키의 값이 1을 넘어선다면 입력값으로 반복문을 돌아 해쉬맵의 키와 같은 이름을 가진 배열의 이메일을 정답에 집어넣는다
//3.정렬한다. 끝!
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        //연속되는 단어 두 글자 씩 해쉬맵 추가
        HashMap<String,Integer> userData = new HashMap<>();
        for(List<String> form :forms){
            String[] name = form.get(1).split("");
            for(int i = 0 ; i<name.length - 1 ; i++){
                String n = name[i] + name[i+1];
                userData.put(n,userData.containsKey(n) ? userData.get(n) + 1 : 1);
            }
        }

        for (String k: userData.keySet()){
            //키값이 1이 넘으면 반복문을 돌림
            if(userData.get(k) > 1){
                //키값을 가지고 있으면 email add
                for(List<String> form : forms){
                    if(form.get(1).contains(k)){
                        answer.add(form.get(0));
                    }
                }
            }
        }
        //정렬
        Collections.sort(answer);
        return answer;
    }
}
