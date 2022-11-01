package onboarding;

import java.util.*;

public class Problem6 {
    /* email 정렬 메서드 */
    public static List<String> orderList(HashSet<String> emailSet) {
        List<String> emailList = new ArrayList<>(emailSet);
        emailList.sort(Comparator.naturalOrder());
        return emailList;
    }

    /* 중복되는 닉네임을 가진 이메일 목록 생성 메서드 */
    public static HashSet<String> getResult(HashMap<String, HashSet<String>> emailMap) {
        HashSet<String> emailSet = new HashSet<String>();
        for(HashSet<String> values : emailMap.values()) {
            if(values.size() > 1) {
                for(String email : values) {
                    emailSet.add(email);
                }
            }
        }
        return emailSet;
    }

    /* (닉네임, 이메일) 해시맵 생성 메서드 */
    public static HashMap<String, HashSet<String>> createEmailMap(List<List<String>> forms) {
        HashMap<String, HashSet<String>> emailMap = new HashMap<String, HashSet<String>>();
        for(List<String> crewInfo : forms) {
            String nickname = crewInfo.get(1);
            for(int i = 0; i < nickname.length() - 1; i++) {
                String key = Character.toString(nickname.charAt(i)) + Character.toString(nickname.charAt(i + 1));
                HashSet<String> values;
                if(emailMap.containsKey(key)) {
                    values = emailMap.get(key);
                } else {
                    values = new HashSet<String>();
                }
                values.add(crewInfo.get(0));
                emailMap.put(key, values);
            }
        }
        return emailMap;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, HashSet<String>> emailMap = createEmailMap(forms);
        HashSet<String> emailSet = getResult(emailMap);
        answer = orderList(emailSet);
        return answer;
    }
}
