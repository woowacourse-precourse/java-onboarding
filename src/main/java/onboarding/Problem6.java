package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    static class Email {
        List<String> forms;

        public Email(List<List<String>> forms, int[] checkList) {
            this.forms = new ArrayList<>(forms.size());
            for (int i = 0; i < checkList.length; i++) {
                if (checkList[i] == 1) {
                    System.out.println(forms.get(i).get(0));
                    this.forms.add(forms.get(i).get(0));
                }
            }
        }
        List<String> sortEmails(List<String> forms) {
            String[] arr = forms.toArray(new String[forms.size()]);
            Arrays.sort(arr);
            return Arrays.asList(arr);
        }
    }
    static class CheckList {
        int[] checkName;

        public CheckList(List<List<String>> forms) {
            checkName = new int[forms.size()];
            for (int i = 0; i < forms.size(); i++)
                checkName[i] = 0;
        }

        int[] checkingList(List<List<String>> forms) {
            String compName = "";
            int flag = 0;
            for (int i = 0; i < forms.size(); i++) {
                if (checkName[i] == 0) {
                    compName = forms.get(i).get(1);
                } else continue;
                for (int j = 1; j < forms.size(); j++) {
                    if (isDupChar(forms, compName, j)
                            && checkName[j] == 0 && i != j) {
                        checkName[j] = 1;
                        flag = 1;
                    }
                }
                if (flag == 1) checkName[i] = 1;
                flag = 0;
            }

            return checkName;
        }

        private boolean isDupChar(List<List<String>> forms, String compName, int j) {
            /***
             * [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"],
             * ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ]
             */
            for (int m = 0; m < forms.get(j).get(1).length() - 1; m++) {
                for (int n = 0; n < compName.length() - 1; n++) {
                    String compNameSlicing = compName.substring(n, n + 2);
                    String formsNameSlicing = forms.get(j).get(1).substring(m, m + 2);
                    if (compNameSlicing.equals(formsNameSlicing))
                        return true;
                }
            }
            return false;
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        CheckList checkList = new CheckList(forms);
        int[] ints = checkList.checkingList(forms);
        System.out.println(Arrays.toString(ints));
        Email email = new Email(forms, ints);
        answer = email.sortEmails(email.forms);

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
        solution(forms);
    }
}


