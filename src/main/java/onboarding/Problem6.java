package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem6 {
    static class CheckList {
        int [] checkName;

        public CheckList(List<List<String>> forms) {
            checkName = new int[forms.size()];
            for(int i = 0; i < forms.size(); i++)
                checkName[i] = 0;
        }

        int[] checkingList(List<List<String>> forms) {
            String compName = "";
            for (int i = 0; i < forms.size(); i++) {
                if(checkName[i] == 0) {
                    compName = forms.get(i).get(1);
                } else continue;
                for (int j = 1; j < forms.size(); j++) {
                    if (compName.equals(forms.get(j).get(1))
                            && checkName[j] == 0 && i != j) {
                        checkName[j] = 1;
                    }
                }
            }
            System.out.println(Arrays.toString(checkName));
            return checkName;
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        CheckList checkList = new CheckList(forms);
        int[] ints = checkList.checkingList(forms);
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(forms.size());
        solution(forms);
    }
}
