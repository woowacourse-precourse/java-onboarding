package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static List<String> Member = new ArrayList<>();
    private static List<String> Overlap =new ArrayList<>();
    private static List<String> depulicate = new ArrayList<>();
    private static final String NAME_REG = "^[가-힣]*$";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return AllMemberCheck(forms);
    }

    public static List<String> AllMemberCheck(List<List<String>> forms){
        Overlap.clear();
        depulicate.clear();
        if(!error(forms)) {
            Overlap.addAll(firstMemberCheck(forms));
            for (int i = 1; i < forms.size(); i++) {
                Overlap.addAll(MemberCheck(forms, i));
            }
            Overlap.removeAll(Arrays.asList("", null));
            depulicate = Overlap.stream().distinct().collect(Collectors.toList());
            Collections.sort(depulicate);
        }
        return depulicate;
    }
}
