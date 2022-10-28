package onboarding;

import java.util.*;
//SOL: HashMap을 만들어 아이디가 들어오면 2글자 단위로 나누어 HashMap에 저장시킨다.

//TODO:주의사항:

//TODO:인원제한 구현 -> 1 <= members <= 10,000  ||| 만약 10,000명을 넘었다면 선착순 10,000 자르기

//TODO:이메일 형식 email.com 만 가능? -> @ 다음 email.com이 아닐때 result 결과에 담는다.

//TODO:결과에 이메일이 중복되면 1개 제외 한개만 result에 담기

//TODO: 위의 형식에 어긋났을 경우 result에서 배제한다.

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Long> map = new HashMap<>();  //중복 아이디 사전


        for(List<String> list : forms){ //입력된 모든 아이디 사전을 만들어야함
            String email = list.get(0), id = list.get(1);
            for(int i = 0; i < id.length()-1; i++){ //먼저 유효한 id인지 확인
                String s = id.substring(i, i+2);
                map.put(s, map.getOrDefault(s, 0L) +1L);
            }
        }

        for(List<String> list: forms) {
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
    }

    public static void main(String[] args) {

        System.out.println(solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        )));
    }
}
