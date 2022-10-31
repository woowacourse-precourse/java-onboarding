package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 신청받은 닉네임 중 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
     *
     * @param forms 이메일, 닉네임
     * @return 닉네임 연속 글자 포함 목록, 이메일 오름차순, 중복제거
     */
    public static List<String> solution(List<List<String>> forms) {
        CrewNickname crewNickname = new CrewNickname();
        return crewNickname.upload(forms);
    }

}

class CrewNickname {
    private Map<String, Set<String>> twoCharsAndEmails;
    private Set<String> duplicateCrewEmail;

    public List<String> upload(List<List<String>> forms) {
        twoCharsAndEmails = new HashMap<>();
        createTwoCharsAndEmails(forms);

        duplicateCrewEmail = new HashSet<>();
        updateDuplicateCrewEmail();

        return createAnswer();
    }

    private void createTwoCharsAndEmails(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            Set<String> twoCharsKey = makeTwoCharsKey(nickname);
            putTwoCharsAndEmails(twoCharsKey, email);
        }
    }

    private Set<String> makeTwoCharsKey(String nickname) {
        Set<String> twoCharsFromNickname = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            twoCharsFromNickname.add(nickname.substring(i, i + 2));
        }

        return twoCharsFromNickname;
    }

    private void putTwoCharsAndEmails(Set<String> twoCharsKey, String email) {

        for (String twoChars : twoCharsKey) {
            Set<String> emails = getOrCreateEmailSet(email, twoChars);
            twoCharsAndEmails.put(twoChars, emails);
        }
    }

    private Set<String> getOrCreateEmailSet(String email, String twoChars) {
        Set<String> emails = twoCharsAndEmails.getOrDefault(twoChars, new HashSet<>());
        emails.add(email);
        return emails;
    }

    private void updateDuplicateCrewEmail() {

        for (Set<String> emails : twoCharsAndEmails.values()) {
            updateCrewEmailIfNicknameDuplicate(emails);
        }
    }

    private void updateCrewEmailIfNicknameDuplicate(Set<String> emails) {

        if (emails.size() > 1) {
            duplicateCrewEmail.addAll(emails);
        }
    }

    private List<String> createAnswer() {
        List<String> answer = new ArrayList<>(duplicateCrewEmail);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
