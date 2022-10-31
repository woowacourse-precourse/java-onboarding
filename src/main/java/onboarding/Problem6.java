package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> map = new HashMap<>();          // k-v 매핑
        HashMap<String, Boolean> visited = new HashMap<>();     // 중복확인을 표시할 k-v 매핑
        List<String> answer = new ArrayList<>();
        doMapping(forms,map);
        doVisitedMapping(forms,visited);                        // 해시맵 초기화
        
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();                          // 이메일
            String v = entry.getValue();                        // 닉네임
            if (v.length() < 2) break;                          // 닉네임이 너무 짧으면

            for (int i = 0; i < v.length()-1; i++) {
                String sub = v.substring(i, i + 2);             // 두 글자 이상이 연속으로 겹치면 중복이므로 그 이상의 중복문자열은 굳이 확인 안해도 된다!! 만세!!!
                for (Map.Entry<String, String> entry1 : map.entrySet()) {
                    String k1 = entry1.getKey();                // 이메일
                    String v1 = entry1.getValue();              // 닉네임
                    chkEqualEmail(visited, answer, k, sub, k1, v1);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
    /**이메일이 서로 같은지 비교하고 다를 경우에만 중복 글자를 확인하도록 하는 메서드**/
    private static void chkEqualEmail(HashMap<String, Boolean> visited, List<String> answer, String k, String sub, String k1, String v1) {
        if (!k.equals(k1)) {                        // 두 이메일이 서로 다를 경우에만 비교
            isOverlapped(visited, answer, k, sub, k1, v1);
        }
    }
    /**중복되는 부분 문자열이 있는지 비교하고 참인경우에 정답행렬에 추가하는 연산으로 이동하는 메서드**/
    private static void isOverlapped(HashMap<String, Boolean> visited, List<String> answer, String k, String sub, String k1, String v1) {
        if (v1.contains(sub)) {                 // 중복이 있다면
            chk_addAnswer(visited, answer, k);
            chk_addAnswer(visited, answer, k1);
        }
    }

    /**중복체크가 이미 수행된 이메일인지 확인하고 아니라면 정답행렬에 추가**/
    private static void chk_addAnswer(HashMap<String, Boolean> visited, List<String> answer, String k) {
        if (!visited.get(k)) {               // 체크되지 않은 이메일이라면
            answer.add(k);                   // 정답행렬에 추가
            visited.replace(k, true);
        }
    }

    /**닉네임을 키로 하여 이메일을 값으로 매핑**/
    private static void doMapping(List<List<String>> forms,HashMap<String,String> map) {
        for (List<String> val : forms) { /*이메일을 k, 닉네임을 v로 저장; 이메일이 기본키이므로*/
            map.put(val.get(0), val.get(1));
        }
    }
    /**이메일을 k로 하여 중복 체크가 되었는지 여부를 v로 매핑**/
    private static void doVisitedMapping(List<List<String>> forms,HashMap<String,Boolean> map){
        for (List<String> val : forms) {
            map.putIfAbsent(val.get(0), false); /*이메일을 K, 체크 여부를 v로 저장; 거짓으로 초기화 */
        }
    }
}
