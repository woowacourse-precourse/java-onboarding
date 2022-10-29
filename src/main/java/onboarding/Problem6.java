package onboarding;

import java.util.*;

/**
 * 풀이를 위한 생각 정리
 * hashMap을 자료구조로 쓰면 될 것 같다.
 * HashMap<String, Integer>
 * - 두글자 이상 -> 즉 두글자만 겹치면 뒷 경우는 생각하지 않아도 됨.
 *   - 각 닉네임의 두글자들을 모두 해시맵으로 저장한다.
 *     - getOrDefault를 활용해보자.
 *       - default 값 -1로 저장해놓고 default 값이 아니면 이미 존재하는 녀석이므로 두녀석은 겹친다.
 *       - 겹치는 녀석들은 boolean 배열에서 duplicate[idx]로 저장해보자.
 * - 최대 경우의 수는 각 19글자
 *   - HashMap의 탐색 시간은 O(1), put도 O(1)
 *     - 즉 19*10000이면 저장 및 탐색이 다 가능.
 * - 시간 복잡도도 충분하다.
 * - 다 끝나고 duplicate보고 answer 배열에 추가.
 *   - 이메일 기준으로 HashSet 만든다.
 * 기능명세
 * 1. hashmap 초기화 + 중복 체크
     - 초기화와 동시에 중복체크를 해주는 게 중요
     - 두글자씩 읽으면서 존재하지 않으면 추가
     - 존재하면 둘 다 중복되었다는 체크한다.
 * 2. 각 이메일 저장해놓은 문자열 초기화
 * 3. 중복체크된 녀석들을 제외하고 answer List에 추가
 *   - 이때 email 중복은 HashSet으로
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> substringsOfNickname = new HashMap<>();
        Set<String> emails = new TreeSet<>();
        List<String> answer = new ArrayList<>();
        boolean[] isDuplicate = new boolean[forms.size()];


        return answer;
    }

    public static void determineIsDuplicate(List<List<String>> forms, Map<String, Integer> substringsOfNickname,
                                            boolean[] isDuplicate, int idx) {
        String nickname = forms.get(idx).get(1);

        if(nickname.length()==1)
            return;

        for(int i=0; i<nickname.length()-1; i++){
            String substring = nickname.substring(i,i+2);
            Integer indexOfTwoChar = substringsOfNickname.getOrDefault(substring, -1);

            if(indexOfTwoChar==idx)
                continue;

            if(indexOfTwoChar==-1){
                 substringsOfNickname.put(substring, idx);
                 continue;
            }

            isDuplicate[idx] = true;
            isDuplicate[indexOfTwoChar] = true;
        }
    }

    public static void addEmail(Set<String> emails, String email,
                                boolean isDuplicate, List<String> answer){

        if(isDuplicate  && !emails.contains(email)){
            answer.add(email);
            emails.add(email);
        }
    }
}
