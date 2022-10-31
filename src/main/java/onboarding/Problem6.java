package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하는 solution method
     * @param forms 이메일, 닉네임 리스트
     * @return 중복되는 닉네임을 사용하는 교육생의 이메일
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicatedNicknames = new ArrayList<>(getDuplicated(getNicknameList(forms)));
        List<String> answer = new ArrayList<>(matchEmailWithNicknames(forms, duplicatedNicknames));
        Collections.sort(answer);
        return answer;
    }

    /**
     * form에서 닉네임만 추출
     * @param forms 이메일, 닉네임 리스트
     * @return 닉네임 리스트
     */
    public static List<String> getNicknameList(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();
        for (List<String> form: forms) {
            nicknames.add(form.get(1));
        }
        return nicknames;
    }

    /**
     * 같은 글자가 연속적으로 나타나는 닉네임을 찾는 method
     * @param nicknames 교육생의 닉네임
     * @return 같은 글자가 연속적으로 포함되는 닉네임들의 리스트
     */
    public static List<String> getDuplicated(List<String> nicknames) {
        List<String> duplicatedNicknameSubstring = new ArrayList<>();
        for (String nickname: nicknames) {
            for (int i = 0; i < nickname.length()-1; i++) {
                String subString = nickname.substring(i, i+2);
                if(isDuplicateSub(nicknames, nickname, subString)) duplicatedNicknameSubstring.add(nickname);
            }
        }
        return duplicatedNicknameSubstring;
    }

    /**
     * 닉네임에 중복되는 부분이 있는지 확인하는 method
     * @param nicknames 전체 교육생의 닉네임 리스트
     * @param name 중복을 확인하는 교육생의 닉네임
     * @param subString name 에서의 연속적인 문자
     * @return 중복되는 부분이 있는 경우 true, 없는 경우 false
     */
    public static boolean isDuplicateSub(List<String> nicknames, String name, String subString) {
        for (String nickname: nicknames) {
            if (name.equals(nickname)) continue;
            if (nickname.contains(subString)) return true;
        }
        return false;
    }

    public static List<String> matchEmailWithNicknames(List<List<String>> forms, List<String> nicknames) {
        List<String> emails = new ArrayList<>();

        for (List<String> form: forms) {
            for (String nickname: nicknames) {
                if (form.get(1).equals(nickname)) emails.add(form.get(0));
            }
        }
        return emails;
    }
}
