package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        // 이메일 도메인 유효성 검사
        String emailDomain = "email.com";
        deleteInvalidEmailInList(forms, emailDomain);
        // 중복된 닉네임 식별
        for (int i = 0; i < forms.size(); i++) {
            // 특정 닉네임과 중복된 글자가 있는 닉네임들을 answer에 추가
            insertDuplicateNicknameToList(forms, answer, i);
        }
        // 중복제거. List -> Set -> List
        Set<String> answerSet = new HashSet<String>(answer);
        answer =new ArrayList<String>(answerSet);

        return answer;
    }

    /** 도메인이 유효하지 않은 이메일을 리스트에서 삭제하는 메서드 */
    private static void deleteInvalidEmailInList(List<List<String>> forms, String emailDomain) {
        Iterator<List<String>> formsIterator = forms.iterator();
        while(formsIterator.hasNext()) {
            String crewEmail = formsIterator.next().get(0);
            String crewEmailDomain = crewEmail.substring(crewEmail.length() - emailDomain.length());
            if (crewEmailDomain.equals(emailDomain) == false) {
                formsIterator.remove();
            }
        }
        return;
    }
    
    /** 닉네임들을 순회하며 특정 닉네임과 부분중복된 닉네임들을 확인하는 메서드 */
    private static void insertDuplicateNicknameToList(List<List<String>> forms, List<String> answer, int index) {
        for (int otherIndex = 0; otherIndex < forms.size(); otherIndex++) {
            if (index == otherIndex) {
                continue;
            }
            String nickname = forms.get(index).get(1);
            String otherNickname = forms.get(otherIndex).get(1);
            // 두 닉네임의 중복 여부 확인
            if (checkDuplicated(nickname, otherNickname) == true) {
                answer.add(forms.get(otherIndex).get(0));
            }
        }
        return;
    }

    /** 특정 닉네임 둘이 중복된 글자가 있는지 확인하는 메서드 */
    private static boolean checkDuplicated(String nickname, String otherNickname) {
        boolean isDuplicated = false;
        // 중복 확인 글자수를 2부터 nickname.length()까지 늘려가며 중복 식별. 한번이라도 중복 확인되면 return true
        for (int start = 0; start < nickname.length(); start++) {
            for (int end = start + 2; end < nickname.length()+1; end++) {   // 중복식별은 두 글자부터이므로 end = start + 2
                String letter = nickname.substring(start, end);
                if (otherNickname.contains(letter)) {    // 중복이 있다면
                    isDuplicated = true;
                    break;
                }
            }
        }
        return isDuplicated;
    }
}






















