package onboarding;

import onboarding.problem6.NicknameChecker;

import java.util.List;


public class Problem6 {
    /*
    NicknameChecker 기능 목록
    1. 닉네임을 2글자 단위로 검사해서 부분 닉네임 목록에 없다면 저장하고 있다면 중복 닉네임 목록에 추가하는 기능
    2. 이메일 리스트를 오름차순 정렬하는 기능
     */

    public static List<String> solution(List<List<String>> forms) {
        NicknameChecker nicknameChecker = new NicknameChecker();

        nicknameChecker.check(forms);

        return nicknameChecker.getDuplicatedEmailList();
    }
}
