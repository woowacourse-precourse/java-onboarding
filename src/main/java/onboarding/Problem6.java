package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

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
        crewForms.stream()
                .forEach(crewInfo -> {
                    String crewNickname = crewInfo.get(1);
                    String crewEmail = crewInfo.get(0);
                    crewInfoMap.put(crewNickname, crewEmail);
                });
    }

    private static List<String> excludeLengthOneCrewNickname() {
        List<String> duplicableCrewNicknames = crewInfoMap.keySet().stream()
                .filter(crewNickname -> crewNickname.length() != 1)
                .collect(Collectors.toList());
        return duplicableCrewNicknames;
    }

    private static List<String> getSubstringCrewNicknames(List<String> duplicableCrewNicknames) {
        List<String> substringCrewNicknames = new ArrayList<>();
        duplicableCrewNicknames.forEach(
                duplicableCrewNickname -> {
                    for (int subStringIndex = 0; subStringIndex < duplicableCrewNickname.length() - 1; subStringIndex++) {
                        substringCrewNicknames.add(duplicableCrewNickname.substring(subStringIndex, subStringIndex + 2));
                    }
                }
        );
        return substringCrewNicknames;
    }

    private static Set<String> extractDuplicateSubstringCrewNicknames(List<String> substringCrewNicknames) {
        Set<String> DuplicateSubstringCrewNicknames = substringCrewNicknames.stream()
                .filter(substringCrewNickname ->
                        substringCrewNicknames.indexOf(substringCrewNickname) !=
                                substringCrewNicknames.lastIndexOf(substringCrewNickname))
                .collect(Collectors.toSet());
        return DuplicateSubstringCrewNicknames;
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
        List<String> duplicateCrewEmails = duplicateCrewNicknames.stream()
                .map(crewInfoMap::get)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return duplicateCrewEmails;
    }

    private static void validateCrewInfo(List<List<String>> crewForms) {
        if(!validateNumberOfCrew(crewForms)) {
            throw new IllegalArgumentException("[ERROR] : 크루는 1명 이상 10,000명 이하여야합니다.");
        }
        crewForms.stream()
                .forEach(crewForm -> {
                    String crewEmail = crewForm.get(0);
                    String crewNickname = crewForm.get(1);
                    if(!validateEmailType(crewEmail)) {
                        throw new IllegalArgumentException("[ERROR] : 이메일 형식에 부합해야 하며, 도메인은 email.com이어야합니다.");
                    }
                    if(!validateEmailLength(crewEmail)) {
                        throw new IllegalArgumentException("[ERROR] : 이메일 길이는 11자 이상 20자 미만이어야합니다.");
                    }
                    if(!validateNicknameType(crewNickname)) {
                        throw new IllegalArgumentException("[ERROR] : 닉네임은 한글만 가능합니다.");
                    }
                    if(!validateNicknameLength(crewNickname)) {
                        throw new IllegalArgumentException("[ERROR] : 닉네임의 전체 길이는 1자 이상 20자 미만이어야합니다.");
                    }
                });
    }

    private static boolean validateNumberOfCrew(List<List<String>> crewForms) {
        return (crewForms.size() >= 1 && crewForms.size() <= 10000);
    }

    private static boolean validateEmailType(String crewEmail) {
        return Pattern.compile("^[a-zA-Z0-9]+@email.com$").matcher(crewEmail).matches();
    }

    private static boolean validateEmailLength(String crewEmail) {
        return (crewEmail.length() >= 11 && crewEmail.length() < 20);
    }


    private static boolean validateNicknameType(String crewNickname) {
        return Pattern.compile("^[가-힣]+$").matcher(crewNickname).matches();
    }

    private static boolean validateNicknameLength(String crewNickname) {
        return (crewNickname.length() >= 1 && crewNickname.length() < 20);
    }
}
