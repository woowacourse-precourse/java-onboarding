package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int CREW_EMAIL_INDEX = 0;
    private static final int CREW_NICKNAME_INDEX = 1;
    private static final int SUBSTRING_START_INDEX = 0;
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String WRONG_NUMBER_OF_CREW_EXCEPTION_MESSAGE = "크루는 1명 이상 10,000명 이하여야합니다.";
    private static final String WRONG_CREW_EMAIL_TYPE_EXCEPTION_MESSAGE = "이메일 형식에 부합해야 하며, 도메인은 email.com이어야합니다.";
    private static final String WRONG_CREW_EMAIL_LENGTH_EXCEPTION_MESSAGE = "이메일 길이는 11자 이상 20자 미만이어야합니다.";
    private static final String WRONG_CREW_NICKNAME_TYPE_EXCEPTION_MESSAGE = "닉네임은 한글만 가능합니다.";
    private static final String WRONG_CREW_NICKNAME_LENGTH_EXCEPTION_MESSAGE = "닉네임의 전체 길이는 1자 이상 20자 미만이어야합니다.";
    private static final int MIN_NUMBER_OF_CREW = 1;
    private static final int MAX_NUMBER_OF_CREW = 10000;
    private static final String CREW_EMAIL_REGEX = "^[a-zA-Z0-9]+@email.com$";
    private static final int MIN_CREW_EMAIL_LENGTH = 11;
    private static final int MAX_CREW_EMAIL_LENGTH = 20;
    private static final String CREW_NICKNAME_REGEX = "^[ㄱ-ㅎㅏ-ㅣ가-힣]+$";
    private static final int MIN_CREW_NICKNAME_LENGTH = 1;
    private static final int MAX_CREW_NICKNAME_LENGTH = 20;

    private static final Map<String, String> crewInfoMap = new HashMap<>();

    public static List<String> solution(List<List<String>> crewInfoForms) {
        validateCrewInfo(crewInfoForms);
        initCrewInfoMap(crewInfoForms);
        List<String> duplicableCrewNicknames = excludeLengthOneCrewNickname();
        List<String> substringCrewNicknames = getSubstringCrewNicknames(duplicableCrewNicknames);
        Set<String> duplicateSubstringCrewNicknames = extractDuplicateSubstringCrewNicknames(substringCrewNicknames);
        List<String> duplicateCrewNicknames = getDuplicateCrewNicknames(duplicableCrewNicknames, duplicateSubstringCrewNicknames);
        return getDuplicateCrewEmails(duplicateCrewNicknames);
    }

    private static void initCrewInfoMap(List<List<String>> crewForms) {
        crewForms.forEach(crewInfo -> {
                    String crewNickname = crewInfo.get(CREW_NICKNAME_INDEX);
                    String crewEmail = crewInfo.get(CREW_EMAIL_INDEX);
                    crewInfoMap.put(crewNickname, crewEmail);
                });
    }

    private static List<String> excludeLengthOneCrewNickname() {
        return crewInfoMap.keySet().stream()
                .filter(crewNickname -> crewNickname.length() != 1)
                .collect(Collectors.toList());
    }

    private static List<String> getSubstringCrewNicknames(List<String> duplicableCrewNicknames) {
        List<String> substringCrewNicknames = new ArrayList<>();
        duplicableCrewNicknames.forEach(
                duplicableCrewNickname -> {
                    for (int substringIndex = SUBSTRING_START_INDEX; substringIndex < duplicableCrewNickname.length() - 1; substringIndex++) {
                        substringCrewNicknames.add(duplicableCrewNickname.substring(substringIndex, substringIndex + 2));
                    }
                }
        );
        return substringCrewNicknames;
    }

    private static Set<String> extractDuplicateSubstringCrewNicknames(List<String> substringCrewNicknames) {
        return substringCrewNicknames.stream()
                .filter(substringCrewNickname ->
                        substringCrewNicknames.indexOf(substringCrewNickname) !=
                                substringCrewNicknames.lastIndexOf(substringCrewNickname))
                .collect(Collectors.toSet());
    }

    private static List<String> getDuplicateCrewNicknames(List<String> duplicableCrewNicknames, Set<String> duplicateSubstringCrewNicknames) {
        List<String> duplicateCrewNicknames = new ArrayList<>();
        duplicableCrewNicknames.forEach(duplicableCrewNickname -> {
            duplicateSubstringCrewNicknames.forEach(
                    duplicateSubstringCrewNickname -> {
                        if(duplicableCrewNickname.contains(duplicateSubstringCrewNickname)) {
                            duplicateCrewNicknames.add(duplicableCrewNickname);
                        }
                    }
            );
        });
        return duplicateCrewNicknames;
    }

    private static List<String> getDuplicateCrewEmails(List<String> duplicateCrewNicknames) {
        return duplicateCrewNicknames.stream()
                .map(crewInfoMap::get)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateCrewInfo(List<List<String>> crewForms) {
        if(validateNumberOfCrewFail(crewForms)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_NUMBER_OF_CREW_EXCEPTION_MESSAGE);
        }
        crewForms.forEach(crewForm -> {
                    String crewEmail = crewForm.get(0);
                    String crewNickname = crewForm.get(1);
                    if(validateEmailTypeFail(crewEmail)) {
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_CREW_EMAIL_TYPE_EXCEPTION_MESSAGE);
                    }
                    if(validateEmailLengthFail(crewEmail)) {
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_CREW_EMAIL_LENGTH_EXCEPTION_MESSAGE);
                    }
                    if(validateNicknameTypeFail(crewNickname)) {
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_CREW_NICKNAME_TYPE_EXCEPTION_MESSAGE);
                    }
                    if(validateNicknameLengthFail(crewNickname)) {
                        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + WRONG_CREW_NICKNAME_LENGTH_EXCEPTION_MESSAGE);
                    }
                });
    }

    private static boolean validateNumberOfCrewFail(List<List<String>> crewForms) {
        return (crewForms.size() < MIN_NUMBER_OF_CREW || crewForms.size() > MAX_NUMBER_OF_CREW);
    }

    private static boolean validateEmailTypeFail(String crewEmail) {
        return !Pattern.compile(CREW_EMAIL_REGEX).matcher(crewEmail).matches();
    }

    private static boolean validateEmailLengthFail(String crewEmail) {
        return (crewEmail.length() < MIN_CREW_EMAIL_LENGTH || crewEmail.length() >= MAX_CREW_EMAIL_LENGTH);
    }


    private static boolean validateNicknameTypeFail(String crewNickname) {
        return !Pattern.compile(CREW_NICKNAME_REGEX).matcher(crewNickname).matches();
    }

    private static boolean validateNicknameLengthFail(String crewNickname) {
        return (crewNickname.length() < MIN_CREW_NICKNAME_LENGTH || crewNickname.length() >= MAX_CREW_NICKNAME_LENGTH);
    }
}
