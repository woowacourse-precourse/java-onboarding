package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    static List<Boolean> checkDuplication; // LinkedList가 더 좋나?
    static List<String> str = new ArrayList<>();
    static List<String> saveEmailForDuplicatedName = new ArrayList<>();
    static List<String> saveEmailCheckedByEmailRegex = new ArrayList<>();
    private static final String NAME_REG = "^[가-힣]*$";

    public static List<String> solution(List<List<String>> forms) {
        if (checkExceptionList(forms)) {
            str.clear();
            return str;
        }
        initializeDuplication(forms);
        nameDeduplicationMethod(forms);
        checkEmailRegex();
        return saveEmailCheckedByEmailRegex;
    }

    public static void initializeDuplication(List<List<String>> forms) {
        checkDuplication = new ArrayList<>(forms.size());
        for (int i = 0; i < forms.size(); i++) {
            checkDuplication.add(false);
        }
    }

    public static void nameDeduplicationMethod(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            duplicateNameDetectionMethod(forms, i);
            if ((checkDuplication.get(i))) {
                saveEmailForDuplicatedName.add(forms.get(i).get(0));
            }
        }
    }

    public static void duplicateNameDetectionMethod(List<List<String>> forms, int num) {
        str.clear();
        saveNameByTwoCharacters(forms.get(num).get(1));
        for (int i = num + 1; i < forms.size(); i++) {
            if (checkNameDuplication(str, i, forms)) {
                isDuplicateName(num, i);
            }
        }
    }

    public static String charToString(char ch) {
        return ch + "";
    }

    public static void saveNameByTwoCharacters(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            str.add(charToString(nickname.charAt(i)) + charToString(nickname.charAt(i + 1)));
        }
    }

    public static Boolean checkNameDuplication(List<String> str, int num, List<List<String>> forms) {
        for (String s : str) {
            if (forms.get(num).get(1).contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static void isDuplicateName(int num, int i) {
        checkDuplication.set(num, true);
        checkDuplication.set(i, true);
    }

    public static boolean checkExceptionList(List<List<String>> forms) {
        return (crewMembersOutOfRangeException(forms) ||
                nicknameOutOfRangeException(forms) ||
                isValidNicknameRegex(forms) ||
                emailDomainOutOfRulesException(forms) ||
                emailLengthOutOfRangeException(forms));
    }

    public static void checkEmailRegex() {
        saveEmailCheckedByEmailRegex = checkEmailDuplication(saveEmailForDuplicatedName);
        emailSort(saveEmailCheckedByEmailRegex);
    }

    public static void emailSort(List<String> emails) {
        emails.sort(String.CASE_INSENSITIVE_ORDER);
    }

    public static List<String> checkEmailDuplication(List<String> emails) {
        return emails.stream().distinct().collect(Collectors.toList());
    }

    public static boolean crewMembersOutOfRangeException(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            System.out.println("크루원은 1명부터 10000명까지 입니다.");
            return true;
        }
        return false;
    }

    public static boolean isValidNicknameRegex(List<List<String>> forms) {
        if (!forms.stream().allMatch(form -> form.get(1).matches(NAME_REG))) {
            System.out.println("올바른 닉네임형식이 아닙니다. 한글만 사용하여 닉네임을 작성헤주세요");
            return true;
        }
        return false;
    }

    public static boolean nicknameOutOfRangeException(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (form.get(1).length() < 1 || form.get(1).length() > 19) {
                System.out.println("닉네임은 1자부터 20자 미만까지 가능합니다");
                return true;
            }
        }
        return false;
    }

    public static boolean emailDomainOutOfRulesException(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!form.get(0).contains("email.com")) {
                System.out.println("email.com 도메인으로 이메일을 작성해주세요");
                return true;
            }
        }
        return false;
    }
}