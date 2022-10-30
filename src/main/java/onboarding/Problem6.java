package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 기능 구현사항
 * 1. 한글 문자열을 2칸단위로 해쉬값에 저장하고 값을 늘리는 기능
 * 2. 문자열의 해쉬값에 대응되는 값이 1보다 큰지 판별
 * 3. 1보다 크다면 TreeSet에 담아 중복제거거와 정렬 수행
 * 4. 첫먼째 문자열을 다시 확인해서 해쉬값이 1보다 크다면 첫번째 문자열도 넣는 기능
 *
 * */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");
        return answer;
    }

    static void setHash(List<List<String>> forms) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                String s = String.valueOf((form.get(1).charAt(i))) + String.valueOf((form.get(1).charAt(i + 1)));
                if(hashMap.get(s) == null) hashMap.put(s, 1);
                else hashMap.put(s, hashMap.get(s) + 1);
            }
        }
    }

}
