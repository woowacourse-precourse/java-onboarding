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
}