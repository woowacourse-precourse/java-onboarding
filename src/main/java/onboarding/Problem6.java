package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> duplMap = new HashMap<>(); //key: 중복되는 2연속글자 / value: 이메일
        HashSet<String> emails = new HashSet<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            if(nickName.length() == 1) break;

            for (int i = 0; i < nickName.length() - 1; i++) {
                String chkTwoWords = nickName.substring(i, i+2);

                if(!duplMap.containsKey(chkTwoWords)) { //최초의 체크할 연속 2글자
                    duplMap.put(chkTwoWords, email); //map에 체크할 연속 2글자 추가
                } else { // map에 체크할 연속 2글자가 존재할 경우
                    emails.add(email); //해당 이메일
                    emails.add(duplMap.get(chkTwoWords)); //중복된 상대 이메일 set에 추가(중복제거)
                }
            }
        }

        //중복 제거(3개이상 중복일 경우 기준값 중복됨) & 정렬
        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }
}
