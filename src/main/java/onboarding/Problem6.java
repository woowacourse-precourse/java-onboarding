package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> seperatedNicknameMap = new HashMap<>();
        Set<String> emails = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            makeMap(seperatedNicknameMap, emails, email, nickname);
        }

        List<String> emailsList = new ArrayList<>(emails);
        return emailsList;
    }

    private static void makeMap(Map<String, String> map, Set<String> emails, String email, String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = 1; j < nickname.length(); j++) {
                String seperatedNickname = nickname.substring(i, j+1); // 닉네임 분리

                if(!map.containsKey(seperatedNickname) ){ // 분리된 닉네임이 같은게 없고,
                    if(seperatedNickname.length() > 1){ // 분리된 닉네임이 2글자 이상이면
                        map.put(seperatedNickname, email); // map에 분리된 닉네임과 이메일 넣기
                    }
                }
                else{
                    emails.add(map.get(seperatedNickname)); // map에 있는 닉네임의 사람의 이메일 추가
                    emails.add(email); // 새로 중복된 닉네임을 가진 사람의 이메일 추가
//                    System.out.println(seperatedNickname + " : " + emails);
                }
            }
        }
    }
}