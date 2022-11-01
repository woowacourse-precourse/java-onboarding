package onboarding;

import onboarding.pkgProblem6.service.CrewAccountManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 두 글자 이상의 중복된 단어를 포함한 닉네임을 신청한 크루들을 나타내는 메소드
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewAccountManageService accountService = new CrewAccountManageService();

        accountService.addAccountByDuplicateWord(forms);

        TreeSet<String> ts = accountService.getDuplicateAccount();
        return new ArrayList<>(ts);
    }
}
