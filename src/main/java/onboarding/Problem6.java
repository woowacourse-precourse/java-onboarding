package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class Problem6 {
    private static final int GET_EMAIL_INDEX = 0;
    private static final int GET_NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = new ArrayList<>();

        for (List<String> form : forms) {
            Email email = new Email(form.get(GET_EMAIL_INDEX));
            NickName nickName = new NickName(form.get(GET_NICKNAME_INDEX));
            crews.add(new Crew(email, nickName));
        }

        NickNameDuplicate nickNameDuplicate = new NickNameDuplicate();
        Set<Crew> crewWithDuplicatedNickName = nickNameDuplicate.findCrewWithDuplicatedNickName(crews);
        return crewWithDuplicatedNickName.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }
}


class Email {
    private static final String DOMAIN = "@email.com";
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 20;
    private static final String DOMAIN_FORM_ERROR = "도메인 형식이 잘못되었습니다.";
    private static final String NOT_ALLOWED_UNDER_MIN_LENGTH = "이메일은 최소 11자 입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_LENGTH = "이메일은 최대 20자 입니다.";
    private String email;

    public Email(String email) {
        validateEmailForm(email);
        validateEmailLength(email);
        this.email = email;
    }

    private void validateEmailForm(String email) {
        if (!email.contains(DOMAIN)) {
            throw new IllegalStateException(DOMAIN_FORM_ERROR);
        }
    }

    private void validateEmailLength(String email) {
        if (email.length() < MIN_EMAIL_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_LENGTH);
        }
        if (email.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_LENGTH);
        }
    }

    public String getEmail() {
        return email;
    }
}

class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }

    //두 글자씩 잘라서 저장함.
    public Set<String> duplicatedCases() {
        Set<String> duplicatedCasesSet = new HashSet<>();

        for (int i = 0; i < nickName.length() - 2; i++) {
            String nickNameSubString = nickName.substring(i, i + 2);
            duplicatedCasesSet.add(nickNameSubString);
        }
        return duplicatedCasesSet;
    }
}

class Crew {
    private final Email email;
    private final NickName nickName;

    public Crew(Email email, NickName nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public NickName getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email.getEmail();
    }
}

class NickNameDuplicate {
    private final Set<Crew> crewsByDuplicatedNickName;
    private final HashMap<String, Crew> nickNameAndEmail;

    public NickNameDuplicate() {
        crewsByDuplicatedNickName = new HashSet<>();
        nickNameAndEmail = new HashMap<>(); //두 글자랑 크루 연결해놓음
    }

    public Set<Crew> findCrewWithDuplicatedNickName(List<Crew> crews) {
        for (Crew crew : crews) {
            NickName nickName = crew.getNickName();
            Set<String> allCases = nickName.duplicatedCases();

            for (String subString : allCases) {
                if (!nickNameAndEmail.containsKey(subString)) {
                    nickNameAndEmail.put(subString, crew);
                    continue;
                }
                crewsByDuplicatedNickName.add(nickNameAndEmail.get(subString));
                crewsByDuplicatedNickName.add(crew);
            }
        }
        return crewsByDuplicatedNickName;
    }
}