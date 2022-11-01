package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}


class Email {
    private static final String DOMAIN = "@email.com";
    private static final String DOMAIN_FORM_ERROR = "도메인 형식이 잘못되었습니다.";
    private String email;

    public Email(String email) {
        validateEmailForm(email);
        this.email = email;
    }

    private void validateEmailForm(String email) {
        if (!email.contains(DOMAIN)) {
            throw new IllegalStateException(DOMAIN_FORM_ERROR);
        }
    }
}

class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<String> duplicatedCases() {
        Set<String> duplicatedCasesSet = new HashSet<>();

        for (int i = 0; i < nickName.length() - 2; i++) {
            String nickNameSubString = nickName.substring(i, i + 2);
            duplicatedCasesSet.add(nickNameSubString);
        }
        return duplicatedCasesSet;
    }

    public String getNickName() {
        return nickName;
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

    public Email getEmail(){
        return email;
    }
}

class NickNameDuplicate {
    public Set<Crew> findCrewWithDuplicatedNickName(List<Crew> crews) {

        Set<Crew> crewsByDuplicatedNickName = new HashSet<>();
        HashMap<String, Crew> nickNameAndEmail = new HashMap<>();

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