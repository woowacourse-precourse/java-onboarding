package onboarding;

import java.util.*;

/**
 * 문제 분석
 * 1. 리스트 에는 각각 이메일, 닉네임이 들어가 있다.
 *      즉, .get(0) == 이메일, .get(1) == 닉네임 이다.
 * 2. 닉네임에서 2개의 일련의 문자열만 같아도 중복으로 간주하기 때문에 일반적인 전체 중복과는 다른방식으로 접근해야한다.
 * 3. 트라이 개념을 약간 응용하여 구현하도록 한다.
 *      1. 전체 문자열이 같음을 보는것이 아니기 때문에 트라이 연결을 문자 뒤에 어떤 문자가 올수있는지 확인하고 등장횟수를 저장한다.
 *            ex) "우테코" , "테크노마트" ,"우아한형제" 일경우
 *              우 ->테 ,아
 *              테 ->코 ,크
 *              코 -> x
 *              크 -> 노
 *              마 -> 트
 *              트 -> x
 *              아 -> 한
 *              한 -> 형
 *              형 -> 제
 *              제 -> x
 *              와 같은 방식으로 뒤에 오는 문자를 표시한다.
 *     2. 1번의 로직을 구현하기 위해 해쉬맵을 이용한다 .
 *             key == 문자
 *             value == 뒤에 오는 문자들 (HashMap<Character(문자), Integer(등장 횟수)>)
 *     3. 이메일의 중복을 제거하라는것이 실제 이메일이 중복해서 들어오는 경우도 있을수 있으므로 set 을 통해 중복 제거
 */


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer ;
        Set<String> set =new HashSet<>();
        HashMap<Character, HashMap<Character, Integer>> hs = new HashMap<>();
        HashMap<Character,Integer> preHs;
        for (List<String> users : forms) {
            preHs =null;
            for (char ch : users.get(1).toCharArray()) {
                if (preHs != null) {
                    preHs.put(ch, preHs.getOrDefault(ch, 0) + 1);
                }
                if (!hs.containsKey(ch)) {
                    hs.put(ch, new HashMap<>());
                }
                preHs = hs.get(ch);
            }
        }
        for (List<String> users : forms) {
            preHs =null;
            for (char ch : users.get(1).toCharArray()) {
                if (preHs != null) {
                    if (preHs.get(ch) > 1) {
                        set.add(users.get(0));
                        break;
                    }
                }
                preHs = hs.get(ch);
            }
        }
        answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
}
