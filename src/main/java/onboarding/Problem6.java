package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - 크루는 1명 이상 10,000명 이하이다.
 * - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
 * - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 * - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 *
 * 1. 접근 방식
 * - 모든 크루의 닉네임을 탐색하면서 닉네임을 2글자로 쪼갠다. 이를 'keyword'라고 부르겠다. (제이엠요 -> 제이 , 이엠 , 엠요)
 * - Map< keyword , keyword를 가지고 있는 크루의 parameter List indexs > 형식의 Map을 생성한다.
 * - 모든 크루의 닉네임을 탐색하면서
 *  _ 해당 키워드가 Map KEY에 존재시 VALUE에 add 해준다.
 *  _ 존재하지 않을 시 새로운 KEY - VALUE를 생성한다.
 * - Map이 완성되면 VALUE의 길이가 1이 아닌 아이들을 List에 추가하고 중복제거, 오름차순 정렬한다.
 *
 * */
public class Problem6 {

    private Map<String, ArrayList<Integer>> nickKeywordMap;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        return answer;
    }


    // 닉네임 두글자씩으로 쪼개 keyword를 만든후 Map에 집어넣음
    public void checkKeyExist(String nickname, int index){
        char[] nicknameCharArray = nickname.toCharArray();
        for(int i = 0; i < (nicknameCharArray.length-1); i++){
            // keyword 생성후 Map에 추가
            addToMap(String.valueOf(nicknameCharArray[i] + nicknameCharArray[i+1]),index);
        }
    }

    // keyword가 Key에 존재하는지 확인후 있다면 VALUE에 add, 없다면 새로운 KEY - VALUE를 생성
    public void addToMap(String keyword, int index){
        // keyword가 이미 존재할 때
        if(nickKeywordMap.containsKey(keyword)){
            nickKeywordMap.get(keyword).add(index);
        }

        // keyword가 존재하지 않을 때
        nickKeywordMap.put(keyword,new ArrayList<>() {{
            add(index);
        }});

    }

}
