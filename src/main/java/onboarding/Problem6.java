package onboarding;

import onboarding.problem6.domain.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    private List<String> sortRemoveEmail(List<String> duplicateEmailList) {
        List<String> sortedRemovedEmailList = new ArrayList<>();
        Collections.sort(duplicateEmailList);
        for (String email : duplicateEmailList) {
            if (!sortedRemovedEmailList.contains(email)) sortedRemovedEmailList.add(email);
        }
        return sortedRemovedEmailList;
    }

    public static List<String> solution(List<List<String>> forms) {

        Problem6 problem6 = new Problem6();

        List<Member> memberList = new ArrayList<>();

        for (List<String> form : forms) {
            memberList.add(new Member(form.get(0), form.get(1), 0));
        }

        HashMap<String, Integer> duplicateNicknameCheckedMap = new HashMap<>();

        for (Member member : memberList) {
            member.checkNickname(duplicateNicknameCheckedMap);
        }

        for (Member member : memberList) {
            member.setDuplicateStatus(duplicateNicknameCheckedMap);
        }

        List<String> duplicatedNicknameEmailList = new ArrayList<>();

        for (Member member : memberList) {
            if (member.getDuplicateStatus() == 1) duplicatedNicknameEmailList.add(member.getEmail());
        }

        return problem6.sortRemoveEmail(duplicatedNicknameEmailList);
    }
}
