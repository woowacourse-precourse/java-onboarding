package onboarding;

import problem6.Forms;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Forms formList = new Forms(forms);
        return formList.getProblematicEmails();
    }
}
