package onboarding;

import java.util.HashMap;
import java.util.List;

/**
 * 기능 목록
 * 1. 초기화 과정.
 * 2. 닉네임을 중복확인. (즉 연속적인 문자가 있는 것들을 인지 할 수 있어야한다.)
 * 3. 각각의 닉네임들을 모두 잘라서 후보로 두어야한다.
 * 4. HashMap<email,name> , HashMap<email,boolean>
 * 5.
 */
//닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> nameMap;
        HashMap<String, Boolean> answerMap;

        return answer;
    }

//    public HashMap<String, String> initAMap(List<List<String>> forms) {
//        HashMap<String, String> nameMap = new HashMap<>();
//        for (List<String> s : forms) {
//            nameMap = addMapIterList(nameMap, s);
//        }
//        return nameMap;
//    }

    public HashMap<String, String> initNameMap(List<List<String>> forms) {
        HashMap<String, String> nameMap = new HashMap<>();
        for (List<String> s : forms) {
            nameMap.put(s.get(0), s.get(1));
        }
        return nameMap;
    }

}
