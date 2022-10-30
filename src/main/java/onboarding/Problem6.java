package onboarding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
    기능 목록
    1. 모든 닉네임에 대해 연속적인 두 글자 조합을 찾는다.
    2. HashMap을 통해 key : 연속된 두 글자, value : 중복 개수
    3. value가 1초과인 key를 기준으로 메일주소를 찾는다.
 */
public class Problem6 {
    // key -> 중복된 두 글자
    // value -> 중복 카운트
    static HashMap<String, Integer> nick = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // Step 1. 입력 파라미터에 닉네임을 char 배열로 만들어 함수에 넘겨준다.
        for(int i = 0; i < forms.size(); i++) {
            search(forms.get(i).get(1).toCharArray());
        }

        // Step 2. 중복 제거와 정렬 -> nick 에 key와 forms의 닉네임을 비교
        answer = distinctAndSort(forms);
        return answer;
    }

    // 연속된 두 글자 찾기 함수
    public static void search(char[] nickname){
        for(int i = 0; i < nickname.length-1; i++){
            // 연속된 두 글자를 만들어 준다.
            StringBuilder joinName = new StringBuilder();
            joinName.append(nickname[i]);
            joinName.append(nickname[i+1]);
            // hashmap에서 key로 가지고 있는지 없는지 판단해 중복 카운트 한다.
            if(!nick.containsKey(joinName.toString())){
                nick.put(joinName.toString(), 1);
            }else{
                nick.put(joinName.toString(), nick.get(joinName.toString())+1);
            }
        }
    }

    // 중복 제거와 정렬을 진행하고 반환
    public static List<String> distinctAndSort(List<List<String>> forms){
        List<String> tmp = new LinkedList<>();
        for(int i = 0; i < forms.size(); i++){
            for(String key : nick.keySet()){
                if(nick.get(key)>1) {
                    if (forms.get(i).get(1).contains(key)) {
                        // 이메일 저장
                        tmp.add(forms.get(i).get(0));
                    }
                }
            }
        }
        // 중복제거 및 정렬 -> Stream()을 List로 반환
        return tmp.stream().distinct().sorted().collect(Collectors.toList());
    }
}
