package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = getEmailSet(forms); // 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 계산

        Collections.sort(answer); // 최종적으로 얻은 지원자의 이메일 목록을 오름차순으로 정렬

        return answer;
    }

    public static List<String> getEmailSet(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>(); // 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일을 저장
        Map<String, String> subNicknameMap = new HashMap<>(); // 연속하는 두 글자와 그 지원자의 이메일을 저장

        for (List<String> form : forms) {
            String userEmail = form.get(0); // 지원자의 이메일
            String userName = form.get(1); // 지원자의 닉네임

            for (int j = 0; j < userName.length() - 1; j++) {
                String subNickname = userName.substring(j, j + 2); // 닉네임의 부분 문자열로 연속하는 두 글자
                boolean continueFlag = saveIfValidate(userEmail, subNickname, emailSet, subNicknameMap);
                if (continueFlag) {
                    continue;
                }
                subNicknameMap.put(subNickname, userEmail);
            }
        }

        return new ArrayList<>(emailSet);
    }

    public static boolean saveIfValidate(String userEmail, String pattern, Set<String> emailSet, Map<String, String> subNicknameMap){
        if(subNicknameMap.containsKey(pattern)){
            emailSet.add(subNicknameMap.get(pattern));
            emailSet.add(userEmail);
            return true;
        }
        return false;
    }
}
