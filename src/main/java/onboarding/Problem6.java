package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 예외 처리
        if (checkInvalid(forms)) {
            return null;
        }

        // 중복 제거를 위해 set 으로 설정
        Set<String> answer = new HashSet<>();

        // 크루들 순서대로 나를 제외한 크루들과 닉네임 비교
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            List<String> dup = new ArrayList<>();

            // Edge case: 닉네임이 1자인 경우
            if (nickname.length() == 1) {
                // 중복될 가능성 없음
                continue;
            }
            dup.add(email);

            // 닉네임 두 글자씩 쪼개기
            List<String> separateName = twoWordName(nickname);

            // 나를 제외한 크루들과 중복이 있는지 확인
            List<Integer> idxList = checkOthers(i, separateName, forms);
            for (int idx : idxList) {
                dup.add(forms.get(idx).get(0));
            }

            // 중복 닉네임 멤버 추가
            if (dup.size() > 1) {
                for (String member : dup) {
                    answer.add(member);
                }
            }
        }

        // 문자열 오름차순으로 정렬, 중복 제거
        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);
        return result;
    }

    // 예외 처리
    private static boolean checkInvalid(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        // 초기화
        for (int i = 0; i < forms.size();i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            String[] domain = email.split("@");

            // 예외 처리: 이메일, 닉네임 길이와 형식
            if (checkFormatLength(email, nickname, domain)) return true;

            emails.add(email);
            nicknames.add(nickname);
        }

        // 크루는 1명 이상 10000명 이하
        if (nicknames.size() < 1 || nicknames.size() > 10000) {
            return true;
        }
        return false;
    }

    private static boolean checkFormatLength(String email, String nickname, String[] domain) {
        // 이메일, 닉네임 길이 체크
        if (email.length() < 11 || email.length() >= 20) {
            return true;
        }
        if (nickname.length() < 1 || nickname.length() >= 20) {
            return true;
        }
        // 이메일, 닉네임 형식 체크
        if (!domain[1].equals("email.com")) {
            return true;
        }
        if (!nickname.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]+")) {
            // 한글 이외의 닉네임
            return true;
        }
        return false;
    }

    // 나를 제외한 크루들과 중복이 있는 멤버의 인덱스를 반환
    private static List<Integer> checkOthers(int idx, List<String> checkList, List<List<String>> forms) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (i == idx) {continue;}
            String name = forms.get(i).get(1);

            if (checkDuplicate(checkList, name)) {
                result.add(i);
            }
        }
        return result;
    }

    // 두 글자씩 나눈 checkList 에 중복된 단어가 있는지 확인
    private static boolean checkDuplicate(List<String> checkList, String name) {
        for (String str : checkList) {
            if (name.contains(str)) {
                return true;
            }
        }
        return false;
    }

    // 닉네임을 연속된 두 글자씩 끊어 반환하는 함수
    private static List<String> twoWordName(String nickname) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            result.add(nickname.substring(i, i + 2));
        }
        return result;
    }
}
