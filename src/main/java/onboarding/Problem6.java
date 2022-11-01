package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> dup_set = new HashSet<>(); // Set으로 중복 제거
        List<String> email_list = new ArrayList<>();
        List<String> nickname_list = new ArrayList<>();

        for (List<String> crew : forms) {
            if (check_email(crew.get(0)) && check_nickname(crew.get(1))) { // 이메일, 닉네임 형식 검사
                email_list.add(crew.get(0));
                nickname_list.add(crew.get(1));
            }
        }
        for (int i = 0; i < nickname_list.size() - 1; i++) {
            for (int j = i + 1; j < nickname_list.size(); j++) {
                if (is_dup(nickname_list.get(i), nickname_list.get(j))) { // 닉네임 중복이면 이메일 목록에 추가
                    dup_set.add(email_list.get(i));
                    dup_set.add(email_list.get(j));
                }
            }
        }
        answer = new ArrayList<>(dup_set);
        Collections.sort(answer); // 오름차순 정렬
        return answer;
    }

    /**
     * 이메일 형식 검사 함수
     *
     * @param email
     * @return
     */
    public static boolean check_email(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com$";
        if (email.length() < 11 || email.length() >= 20) return false; // 길이 예외처리
        return Pattern.matches(regex, email); // 도메인 예외처리
    }

    /**
     * 닉네임 형식 검사 함수
     *
     * @param nickname
     * @return
     */
    public static boolean check_nickname(String nickname) {
        String regex = "^[가-힣]*$";
        if (nickname.length() < 1 || nickname.length() >= 20) return false; // 길이 예외처리
        return Pattern.matches(regex, nickname); // 한글 예외처리
    }

    /**
     * 닉네임 중복 검사
     * @param crew1
     * @param crew2
     * @return 같으면 true 리턴
     */
    public static boolean is_dup(String crew1, String crew2) {
        String substr1, substr2;
        for(int i = 0; i < crew1.length()-1; i++) {
            substr1 = crew1.substring(i, i + 2);
            for (int j = 0; j < crew2.length() - 1; j++) {
                substr2 = crew2.substring(j, j + 2);
                if(substr1.equals(substr2)) return true;
            }
        }
        return false;
    }
}