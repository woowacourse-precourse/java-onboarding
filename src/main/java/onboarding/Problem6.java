package onboarding;

import java.util.List;

public class Problem6 {

    /*
    기능 목록
    1. 닉네임의 두글자씩 자른 것을 key로 갖는 HashMap을 만든다. value는 그 값을 가지는 개수로 작성한다.
    2. value가 1이 아닌 Key들을 불러와, 그 글자들을 가지는 사람들의 이메일을 Set에 저장한다.
    3. Set을 List로 변경 후 Collections.sort(List)해 솔루션에 리턴한다.
    */

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void putPersonToHashMap(List<String> person){
        String nickname = person.get(NICKNAME_INDEX);
        for(int i=0; i<nickname.length()-1; i++){
            putWordsInHashMap(nickname.substring(i, i+2));
        }
    }
}
