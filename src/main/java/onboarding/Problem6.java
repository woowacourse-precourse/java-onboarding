package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FormManager {
    Map<String, Integer> wordOfNickname = new HashMap<String, Integer>();
    List<List<String>> forms;
    Boolean[] isOverlap = new Boolean[10001];

    FormManager(List<List<String>> forms) {
        this.forms = forms;
        Arrays.fill(isOverlap, false);
    }

    /**
     * nickname이 두 글자 이상 중복이 아니라면 wordOfNickname에 삽입, 중복된다면 중복되는 nickname의 index를 반환
     * @param nickname 중복을 검사할 nickname
     * @param index nickname의 index
     * @return nickname이 중복이 아니라면 -1, 중복이라면 중복되는 nickname의 index
     */
    int checkOverlapOfWord(String nickname, Integer index){
        for(int i = 0; i<nickname.length()-1; i++){
            String target = nickname.substring(i, i+2);
            if(wordOfNickname.containsKey(target) && wordOfNickname.get(target) != index){
                return wordOfNickname.get(target);
            }
            wordOfNickname.put(target, index);
        }
        return -1;
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
