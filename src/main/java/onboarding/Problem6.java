package onboarding;

import java.util.*;

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

    /**
     * form에 있는 nickname들이 중복인지 아닌지를 체크
     */
    void checkOverlap(){
        for(int i = 0; i<forms.size(); i++){
            List<String> form = forms.get(i);
            String nickname = form.get(1);
            int overlapIndex = checkOverlapOfWord(nickname,i);
            if(overlapIndex != -1){
                isOverlap[overlapIndex] = true;
                isOverlap[i] = true;
            }
        }
    }

    /**
     * 두 글자 이상 중복되는 nickname들의 리스트를 반환
     */
    List<String> getOverlapNicknames(){
        List<String> overlapNicnames = new ArrayList<String>();
        for(int i = 0; i< forms.size(); i++){
            if(isOverlap[i]){
                overlapNicnames.add(forms.get(i).get(0));
            }
        }
        Collections.sort(overlapNicnames);
        return overlapNicnames;
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        FormManager formManager = new FormManager(forms);
        formManager.checkOverlap();
        answer = formManager.getOverlapNicknames();
        return answer;
    }
}
