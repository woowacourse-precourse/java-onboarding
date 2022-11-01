package onboarding;

import java.util.ArrayList;
import java.util.List;

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
}
