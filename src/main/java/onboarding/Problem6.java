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

    public static List<String> firstMemberCheck(List<List<String>> forms){
        Member.clear();
        for(int i=1; i<forms.size(); i++){
            if(checkequals(forms.get(0).get(1), forms.get(i).get(1))) {
                Member.add(forms.get(0).get(0));
                break;
            }
        }
        return Member;
    }

    public static List<String> MemberCheck(List<List<String>> forms, int index){
        Member.clear();
        for(int i=0; i<forms.size()&index!=i; i++){
            if(checkequals(forms.get(index).get(1), forms.get(i).get(1))) {
                Member.add(forms.get(index).get(0));
                Member.add(forms.get(i).get(0));
                break;
            }
        }
        return Member;
    }
}
