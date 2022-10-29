package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    static class Email {

        List<String> forms;

        Email(List<List<String>> forms, int[] checkList) {
            this.forms = new ArrayList<>(forms.size());

            for (int i = 0; i < checkList.length; i++) {
                if (checkList[i] == 1) {
                    this.forms.add(forms.get(i).get(0));
                }
            }
        }

        private List<String> sortEmails(List<String> forms) {
            String[] arr = forms.toArray(new String[0]);
            Arrays.sort(arr);

            return Arrays.asList(arr);
        }
    }

    static class CheckList {

        int[] checkName;
        int formsLength;
        CheckList(List<List<String>> forms) {
            this.formsLength = forms.size();
            checkName = new int[formsLength];

            for (int i = 0; i < forms.size(); i++) {
                checkName[i] = 0;
            }
        }

        private int[] checkingList(List<List<String>> forms) {
            String compName = "";

            for (int i = 0; i < formsLength; i++) {
                compName = isStandardName(i, forms, compName);
                boolean flag = isComparisonName(i, forms, compName);
                checkFlag(flag, i);
            }

            return checkName;
        }

        private String isStandardName(int i, List<List<String>> forms, String compName) {
            if (checkName[i] == 0) {
                compName = forms.get(i).get(1);
            }

            return compName;
        }

        private boolean isComparisonName(int i, List<List<String>> forms, String compName) {
            boolean flag = false;

            for (int j = i; j < formsLength; j++) {
                if (isDupChar(forms, compName, j)
                        && checkName[j] == 0 && i != j) {
                    checkName[j] = 1;
                    flag = true;
                }
            }

            return flag;
        }

        private void checkFlag(boolean flag, int i) {
            if (flag) {
                checkName[i] = 1;
                System.out.println(Arrays.toString(checkName));
            }
        }

        private boolean isDupChar(List<List<String>> forms, String compName, int j) {
            /**
             * [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"],
             * ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ]
             */
            for (int m = 0; m < forms.get(j).get(1).length() - 1; m++) {
                for (int n = 0; n < compName.length() - 1; n++) {
                    String compNameSlicing = compName.substring(n, n + 2);
                    String formsNameSlicing = forms.get(j).get(1).substring(m, m + 2);

                    if (compNameSlicing.equals(formsNameSlicing)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        CheckList checkList = new CheckList(forms);

        Email email = new Email(forms, checkList.checkingList(forms));
        answer = email.sortEmails(email.forms);

        return answer;
    }
}


