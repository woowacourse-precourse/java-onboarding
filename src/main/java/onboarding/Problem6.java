package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();//key : 두글자 닉네임, value : 이메일

        for(int i = 0; i < forms.size(); i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(!isEmail(email) || !isNickname(nickname)){
                continue;
            }else{
                AddSameNickname(result, map, email, nickname);
            }
        }

        return result.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * 닉네임 중복시 리스트에 추가 기능
     */
    private static void AddSameNickname(List<String> result, Map<String, String> map, String email, String nickname) {
        for(int j = 0; j < nickname.length() - 1; j++){
            String twoWord = nickname.substring(j, j+2);
            if(!map.containsKey(twoWord)) {
                map.put(twoWord, email);
            } else{
                result.add(map.get(twoWord));
                result.add(email);
            }
        }
    }

    /**
     * 이메일 예외처리 기능
     */
    public static Boolean isEmail(String email){
        return email.length() >= 11 && email.length() < 20 && email.endsWith("email.com");
    }

    /**
     * 닉네임 예외처리 기능
     */
    public static Boolean isNickname(String nickname){
        return nickname.length() >= 1 && nickname.length() < 20 && nickname.matches("^[가-힣]*$");
    }
}
