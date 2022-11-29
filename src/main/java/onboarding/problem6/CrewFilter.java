package onboarding.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CrewFilter {

    private static final int MIN_FORMS_SIZE = 1;
    private static final int MAX_FORMS_SIZE = 10000;

    private static CrewFilter INSTANCE;

    private final Set<Crew> crews = new HashSet<>();
    private final Set<String> crewEmails = new HashSet<>();

    private CrewFilter() {
    }

    public static CrewFilter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CrewFilter();
        }
        return INSTANCE;
    }

    public void inputForms(List<List<String>> forms) {
        validateFormsSize(forms);

        for (List<String> form : forms) {
            inputForm(form);
        }
    }

    private void validateFormsSize(List<List<String>> forms) {
        if (forms.size() < MIN_FORMS_SIZE || forms.size() > MAX_FORMS_SIZE) {
            throw new IllegalArgumentException("입력 가능한 폼 범위를 벗어났습니다.");
        }
    }

    private void inputForm(List<String> form) {
        validateForm(form);

        String email = form.get(0);
        String nickname = form.get(1);

        duplicatedEmailCheck(email);
        crewEmails.add(email);

        crews.add(new Crew(email, nickname));
    }

    private void validateForm(List<String> form) {
        if (form.size() != 2) {
            throw new IllegalArgumentException("입력 폼이 옳지 않습니다.");
        }
    }

    private void duplicatedEmailCheck(String email) {
        if (crewEmails.contains(email)) {
            throw new IllegalArgumentException("이미 등록된 이메일입니다.");
        }
    }

    public List<String> filtering() {
        Set<String> filteredCrewEmails = new HashSet<>();

        for (Crew crew : crews) {
            for (Crew anotherCrew : crews) {
                if (crew.equals(anotherCrew)) {
                    continue;
                }

                if (crew.hasDuplicatePattern(anotherCrew)) {
                    filteredCrewEmails.add(crew.getEmail());
                    filteredCrewEmails.add(anotherCrew.getEmail());
                }
            }
        }
        return filteredCrewEmails.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public void clear() {
        crews.clear();
        crewEmails.clear();
    }
}
