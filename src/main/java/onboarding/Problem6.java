package onboarding;

import java.util.*;

public class Problem6 {

    private static void putTwoCharsAndEmailsByTraversingForms(Map<String, Set<String>> twoCharsAndEmails, List<List<String>> forms) {

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            Set<String> twoCharsSet = makeTwoCharsKeyUsingNickname(nickname);
            putTwoCharsAndEmails(twoCharsAndEmails, twoCharsSet, email);
        }
    }

    private static Set<String> makeTwoCharsKeyUsingNickname(String nickname) {
        Set<String> twoCharsFromNickname = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            twoCharsFromNickname.add(nickname.substring(i, i + 2));
        }

        return twoCharsFromNickname;
    }

    private static void putTwoCharsAndEmails(Map<String, Set<String>> twoCharsAndEmails, Set<String> twoCharsSet, String email) {

        for (String twoChars : twoCharsSet) {
            Set<String> emails = getOrCreateEmailSet(twoCharsAndEmails, email, twoChars);
            twoCharsAndEmails.put(twoChars, emails);
        }
    }

    private static Set<String> getOrCreateEmailSet(Map<String, Set<String>> twoCharsAndEmails, String email, String twoChars) {
        Set<String> emails = twoCharsAndEmails.getOrDefault(twoChars, new HashSet<>());
        emails.add(email);
        return emails;
    }

    private static void updateCrewEmailForDuplicateNicknames(Set<String> crewEmailForDuplicateNicknames, Map<String, Set<String>> twoCharsAndEmails) {

        for (Set<String> emails : twoCharsAndEmails.values()) {
            updateCrewEmailIfNicknameDuplicate(crewEmailForDuplicateNicknames, emails);
        }
    }

    private static void updateCrewEmailIfNicknameDuplicate(Set<String> crewEmailForDuplicateNicknames, Set<String> emails) {

        if (emails.size() > 1) {
            crewEmailForDuplicateNicknames.addAll(emails);
        }
    }

    /**
     * 신청받은 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
     *
     * @param forms 이메일, 닉네임
     * @return 닉네임 연속 글자 포함 목록, 이메일 오름차순, 중복제거
     */
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Set<String>> twoCharsAndEmails = new HashMap<>();
        putTwoCharsAndEmailsByTraversingForms(twoCharsAndEmails, forms);

        Set<String> crewEmailForDuplicateNicknames = new HashSet<>();
        updateCrewEmailForDuplicateNicknames(crewEmailForDuplicateNicknames, twoCharsAndEmails);
        List<String> answer = List.of("answer");
        return answer;
    }




}
