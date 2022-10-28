package onboarding;

import java.util.*;

/**
 * 1. n 단위로 문자열 slicing 해주는 기능
 * 2. 두 개의 문자열에서 서로 2글자 연속으로 중복되는게 있는지 boolean 값으로 알려주는 기능
 * 3. 매개변수로 건네온 컬렉션을 clone해서 해당 컬럭센에서 요소를 삭제해주는 기능
 * 4. 매개변수 forms에서 같은 글자가 연속적으로 포함된 닉네임을 가진 이메일 리스트를 반환하는 기능
 * 5. Set 자료구조를 List로 변환하는 기능
 * 6. 리스트 정렬 기능
 * */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> duplicatedEmail = new HashSet<>();

        for (List<String> form : forms) {
            List<List<String>> cloneForms = cloneAndRemove(forms, form);

            duplicatedEmail.addAll(getEmailOfDuplicationNickname(cloneForms, form));
        }

        List<String> result = convertSetToList(duplicatedEmail);
        sortList(result, String.CASE_INSENSITIVE_ORDER);
        return result;
    }

    private static List<List<String>> cloneAndRemove(List<List<String>> forms, List<String> target) {
        List<List<String>> cloneForms = new ArrayList<>(forms);
        cloneForms.remove(target);

        return cloneForms;
    }

    private static Set<String> getEmailOfDuplicationNickname(List<List<String>> forms, List<String> target) {
        Set<String> duplicatedEmail = new HashSet<>();

        for (List<String> form : forms) {
            addIfDuplicated(duplicatedEmail, target, form);
        }
        return duplicatedEmail;
    }

    private static <T> List<T> convertSetToList(Set<T> set) {
        return new ArrayList<>(set);
    }

    private static <T> void sortList(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    private static void addIfDuplicated(Set<String> duplicatedEmail, List<String> target, List<String> compare) {
        String targetEmail = target.get(0);
        String targetNickname = target.get(1);
        String compareEmail = compare.get(0);
        String compareNickname = compare.get(1);

        if (compareBothNickname(targetNickname, compareNickname)) {
            duplicatedEmail.add(targetEmail);
            duplicatedEmail.add(compareEmail);
        }
    }

    private static boolean compareBothNickname(String curNickname, String compareNickname) {
        List<String> slicingCurNick = sliceStringNTime(curNickname, 2);
        List<String> stringsCompareNic = sliceStringNTime(compareNickname, 2);

        return slicingCurNick.stream().anyMatch(stringsCompareNic::contains);
    }

    private static List<String> sliceStringNTime(String target, int n) {
        ArrayList<String> result = new ArrayList<>();

        if (n < 1 || target.length() < n) {
            return result;
        }

        for (int i = 0; i < target.length() - (n - 1); i++) {
            result.add(target.substring(i, i + n));
        }
        return result;
    }
}
