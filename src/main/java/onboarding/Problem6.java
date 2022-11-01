package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // 예외 처리
        if (forms.size() < 1 || forms.size() > 10000) {
            return List.of("제한사항 위반");
        }

        // 중복 단어 체크용 (중복X)
        HashSet<String> checkSet = new HashSet<>();
        // 결과 크루원 저장용 (중복X)
        HashSet<Integer> resultSet = new HashSet<>();
        // 결과 이메일
        List<String> answer = new ArrayList<>();

        // 크루원 차례대로 검색
        for (int i=0; i<forms.size(); i++) {
            // 기준 닉네임 선정
            String nickname = forms.get(i).get(1);
            // 닉네임 체크
            if (!checkNickname(nickname)) {
                return List.of("제한사항 위반");
            }

            // 검색 키워드 추출
            for (int j=0; j<nickname.length()-1; j++) {
                // 2글자 뽑아서 체크셋에 없으면 검색
                // 있으면 다음 2글자 뽑기
                String keyword = nickname.substring(j, j+2);
                if (!checkSet.contains(keyword)) {
                    checkSet.add(keyword);
                    // 기준 닉네임 뒤로만 검색
                    for (int k=i+1; k<forms.size(); k++) {
                        // 중복 문자 포함한다면
                        if (forms.get(k).get(1).contains(keyword)) {

                            // 중복이므로 저장
                            if (!resultSet.contains(i)) {
                                // 이메일 체크
                                if(!checkEmail(forms.get(i).get(0))) {
                                    return List.of("제한사항 위반");
                                }

                                answer.add(forms.get(i).get(0));
                                resultSet.add(i);
                            }

                            // 결과 이메일 저장
                            if (!resultSet.contains(k)) {
                                // 이메일 체크
                                if(!checkEmail(forms.get(k).get(0))) {
                                    return List.of("제한사항 위반");
                                }

                                answer.add(forms.get(k).get(0));

                                // 중복된 크루원 번호 저장
                                resultSet.add(k);
                            }
                        }
                    }
                }
            }
        }
        // 오름차순 정렬
        answer.sort(String::compareTo);

        return answer;
    }

    // 닉네임 체크
    public static boolean checkNickname(String nickname) {
        if (!nickname.matches("^[ㄱ-ㅎ가-힣]*$")) {
            return false;
        } else if (nickname.length() < 1 || nickname.length() > 19) {
            return false;
        }
        return true;
    }

    // 이메일 체크
    public static boolean checkEmail(String email) {

        if (email.length() < 11 || email.length() > 19) {
            return false;
            // 이메일이 소문자 알파벳만 된다는 제한사항이 없어서
        } else if (email.split("@").length != 2) {
            return false;
        } else if (!Objects.equals(email.split("@")[1], "email.com")) {
            return false;
        }
        return true;
    }
}
