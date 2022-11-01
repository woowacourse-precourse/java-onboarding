package onboarding;

import java.util.ArrayList;
import java.util.List;

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
}