package onboarding;

import java.util.*;

public class Problem6 {
    /**
     *  기능 명세
     *  1. 닉네임 간 중복된 문자 있는지 검사하기
     *  2. 중복된 닉네임의 이메일 출력하기
     */

    static Map<String, Integer> partOfNickList = new HashMap<String, Integer>();

    public static List<String> ListOfDuplicate(List<List<String>> forms) {
        ArrayList<String> emailOfDuplicateNickname = new ArrayList<>();
        for (List<String> crew : forms) { extractPartOfNick(crew.get(1)); }
        for (String key : partOfNickList.keySet()) {
            if (partOfNickList.get(key) >= 2) {
                for (List<String> crew : forms) {
                    if (crew.get(1).contains(key)) { emailOfDuplicateNickname.add(crew.get(0)); }
                }
            }
        }
        Collections.sort(emailOfDuplicateNickname);
        return emailOfDuplicateNickname;
    }
    
    public static void extractPartOfNick(String nickName) {
        for (int i=0; i < nickName.length()-2; i++) {
            String extract = nickName.substring(i, i+2);
            if (partOfNickList.containsKey(extract)) { partOfNickList.put(extract, partOfNickList.get(extract)+1); }
            else                                     { partOfNickList.put(extract, 1); }
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = ListOfDuplicate(forms);
        return answer;
    }
}
