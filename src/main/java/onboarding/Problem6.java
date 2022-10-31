package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 * - Map< keyword , keyword를 가지고 있는 크루의 parameter List indexes > 형식의 Map을 생성한다.
 * - 모든 크루의 닉네임을 탐색하면서
 *  _ 해당 키워드가 Map KEY에 존재시 VALUE에 add 해준다.
 *  _ 존재하지 않을 시 새로운 KEY - VALUE를 생성한다.
 * - Map이 완성되면 VALUE의 길이가 1이 아닌 VALUE들(List indexes)을 Set에 추가하고(중복 제거를 위해 Set으로 생성) 오름차순 정렬한다.
 *
 * */
public class Problem6 {

    private Map<String, List<Integer>> nickKeywordMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        Problem6 problem6 = new Problem6();

        // forms를 하나씩 순회하면서 keyword를 만들고 이를 Map에 저장
        for(int idx = 0; idx < forms.size(); idx++){
            problem6.makeKeyword(forms.get(idx).get(1),idx);
        }

        Set<Integer> overlapCrewIdxSet = problem6.sortOverlapCrew();

        // Set의 결과를 가지고 forms에서 중복에 해당하는 지원자 이메일 목록을 List화 한다.
        return overlapCrewIdxSet.stream()
                .map(o -> forms.get(o).get(0))
                .sorted()
                .collect(Collectors.toList());
    }

    // Map에서 VALUE의 size가 1이 아닌 VALUE들(List indexes)의 Set 생성(중복 제거를 위해 Set으로 생성)
    public Set<Integer> sortOverlapCrew(){

        return nickKeywordMap.entrySet()
                .stream()
                .filter(n -> n.getValue().size() > 1)
                .map(n -> n.getValue())
                .collect(Collectors.toList())
                .stream().flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    // 닉네임 두글자씩으로 쪼개 keyword를 만든후 Map에 집어넣음
    public void makeKeyword(String nickname, int index){
        char[] nicknameCharArray = nickname.toCharArray();

        for(int i = 0; i < (nicknameCharArray.length-1); i++){
            // keyword 생성후 Map에 추가
            addToMap(new String(Arrays.copyOfRange(nicknameCharArray,i,i+2)),index);
        }
    }

    // keyword가 Key에 존재하는지 확인후 있다면 VALUE에 add, 없다면 새로운 KEY - VALUE를 생성
    public int addToMap(String keyword, int index){
        // keyword가 이미 존재할 때
        if(nickKeywordMap.containsKey(keyword)){
            nickKeywordMap.get(keyword).add(index);
            return 1;
        }

        // keyword가 존재하지 않을 때
        nickKeywordMap.put(keyword,new ArrayList<>());
        nickKeywordMap.get(keyword).add(index);
        return 0;
    }

}
