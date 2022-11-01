package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // Hashmap 이용해서 두 글자씩 value값에 저장하고 다시 반복문 돌아보기
        // 딕셔너리처럼 돌아가겠...지? 중복제거는 set으로
        HashMap<String, Set<String>> nickName = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String nick = forms.get(i).get(1);
            String mail = forms.get(i).get(0);
            for (int j = 0; j < nick.length()-1; j++) {
                String temp = nick.substring(j,j+2);
                if (nickName.containsKey(temp)) {
                    nickName.get(temp).add(mail);
                } else {
                    Set<String> email = new HashSet<>();
                    email.add(mail);
                    // set아니면 여기 못들어감
                    nickName.put(temp,email);
                }
            }
        }

        Set<String> forAnswer = new HashSet<>();
        for (Set<String> value : nickName.values()) {
            if (value.size() >= 2) {
                for (String email : value) {
                    forAnswer.add(email);
                }
            }
        }
        List<String> answer = new ArrayList<>(forAnswer);
        return answer;
    }
}
