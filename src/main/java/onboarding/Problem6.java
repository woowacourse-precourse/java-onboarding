package onboarding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Map<String, String> listMap = new HashMap<>();
        // 리스트에 있는 닉네임과 이메일을 맵에 넣음
        Iterator<List<String>> listItr = forms.iterator();
        for(int i=0; i<forms.size(); i++){
            List<String> nowList = listItr.next();
            Iterator<String > nowListItr = nowList.iterator();
            String email = nowListItr.next();
            String nickname = nowListItr.next();

            listMap.put(nickname, email);
        }

        // 닉네임 중 같은 글자가 연속적으로 포함 되는 경우 찾기



        // 오름차순 정렬, 중복 제거

        return answer;
    }


}
