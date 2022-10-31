package onboarding;

import java.util.*;

/**
 * 기능명세
 * 1. hashmap 초기화 + 중복 체크
     - 초기화와 동시에 중복체크를 해주는 게 중요
     - 두글자씩 읽으면서 존재하지 않으면 추가
     - 존재하면 둘 다 중복되었다는 체크한다.
 * 2. 각 이메일 저장해놓은 문자열 초기화
 * 3. 중복체크된 녀석들을 제외하고 answer List에 추가
 *   - 이때 email 중복은 HashSet으로
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> substringsOfNickname = new HashMap<>();
        Set<String> emails = new TreeSet<>();
        List<String> answer = new ArrayList<>();
        boolean[] isDuplicate = new boolean[forms.size()];

        for(int i=0; i<forms.size(); i++){
            determineIsDuplicate(forms, substringsOfNickname, isDuplicate, i);
        }

        for(int i=0; i<forms.size(); i++){
            addEmail(emails, forms.get(i).get(0), isDuplicate[i], answer);
        }

        Collections.sort(answer);

        return answer;
    }

    public static void determineIsDuplicate(List<List<String>> forms, Map<String, Integer> substringsOfNickname,
                                            boolean[] isDuplicate, int idx) {
        String nickname = forms.get(idx).get(1);

        if(nickname.length()==1)
            return;

        for(int i=0; i<nickname.length()-1; i++){
            String substring = nickname.substring(i,i+2);
            Integer indexOfTwoChar = substringsOfNickname.getOrDefault(substring, -1);
            checkIfSubStringISDuplicate(substringsOfNickname,isDuplicate,indexOfTwoChar,substring,idx);
        }
    }

    public static void checkIfSubStringISDuplicate(Map<String, Integer> substringsOfNickname, boolean[] isDuplicate,
                                                    Integer indexOfTwoChar,String substring,int idx) {
        if(indexOfTwoChar==idx)
            return;

        if(indexOfTwoChar==-1){
            substringsOfNickname.put(substring, idx);
            return;
        }

        isDuplicate[idx] = true;
        isDuplicate[indexOfTwoChar] = true;
    }

    public static void addEmail(Set<String> emails, String email,
                                boolean isDuplicate, List<String> answer){

        if(isDuplicate && !emails.contains(email)){
            answer.add(email);
            emails.add(email);
        }
    }
}
