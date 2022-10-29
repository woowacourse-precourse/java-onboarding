package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> notified = findContinuousNameForms(forms);
        return null;
    }

    private static List<List<String>> findContinuousNameForms(List<List<String>> forms) {
        List<List<String>> notified = new ArrayList<>();

        for (int size = forms.size(), i = 0; i < size; i++) {
            notified.addAll(findContinuousNameForms(forms, i));
        }

        return notified;
    }

    private static List<List<String>> findContinuousNameForms(List<List<String>> forms, int currentIdx) {
        List<List<String>> notified = new ArrayList<>();
        List<String> currentForm = forms.get(currentIdx);
        String currentName = currentForm.get(1);

        for (int len = currentName.length() - 1, i = 0; i < len; i++) {
            String target = currentName.substring(i, i + 2);
            notified.addAll(findContinuousNameForms(forms, currentIdx, target));
        }

        return notified;
    }

    private static List<List<String>> findContinuousNameForms(List<List<String>> forms, int currentIdx, String target) {
        List<List<String>> notified = new ArrayList<>();

        for (int size = forms.size(), i = currentIdx + 1; i < size; i++) {
            List<String> comparedForm = forms.get(i);
            String comparedName = comparedForm.get(1);

            if (comparedName.contains(target)) {
                notified.add(comparedForm);
            }
        }

        return notified;
    }

}
