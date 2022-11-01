package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = searchDuplicate(forms);
        return answer;
    }

    static List<String> searchDuplicate(List<List<String>> forms) {
        HashMap<String, Integer> allNicknameElements = new HashMap<String, Integer>();
        String nickname;
        HashSet<String> nicknameElements;
        for (int i = 0; i < forms.size(); i++) {
            nicknameElements = new HashSet<>();
            nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                nicknameElements.add(nickname.substring(j, j+2));
            }
            // hashmap에 이미 key값이 있으면 +=1, 없으면 추가하고 value값 1로 지정
            for (String nicknameElement : nicknameElements) {
                if (allNicknameElements.containsKey(nicknameElement)) {
                    allNicknameElements.put(nicknameElement,allNicknameElements.get(nicknameElement) + 1);
                } else {
                    allNicknameElements.put(nicknameElement, 1);
                }
            }
        }
        // 여기까지 오면, 닉네임의 부분 문자열은 모두 hashmap에 담긴 상태
        // 그러면 각각의 닉네임이 1인 value값을 가지는지, 그렇지 않은지 확인해주면 됨
        // 만약 1이라면 문제가 없지만, 2 이상이라면 문제가 있기 때문에 새로운 arrayList에 넣어줘서 출력해야 함
        ArrayList<String> emails = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            for (int j = 0; j < nickname.length() - 1; j++) {
                if (allNicknameElements.get(nickname.substring(j, j+2)) != 1) {
                    emails.add(email);
                    break;
                }
            }
        }
        Collections.sort(emails);
        return emails;
    }

}
