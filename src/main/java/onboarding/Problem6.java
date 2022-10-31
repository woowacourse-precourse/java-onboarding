package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String[] email = new String[forms.size()];
        String[] name = new String[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            email[i] = forms.get(i).get(0);
            name[i] = forms.get(i).get(1);
        }
        answer= (nameequals(email, name));

        answer = emaillist(answer);

        return answer;
    }

    public static List<String> nameequals(String[] email, String[] name) { // 한 글자씩 뗀 후 두 글자가 중복되는 이메일을 모아서 리턴
        String[] namearr;
        String[] namestr;
        List<String> emailarr = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            namearr = name[i].split("");
            for (int j = 0; j < name.length; j++) {
                if (j != i) {
                    namestr = name[j].split("");

                    if (1 < namearr.length || 1 < namestr.length) {

                        for (int n = 0; n < namearr.length - 1; n++) {
                            for (int m = 0; m < namestr.length - 1; m++) {
                                if ((namearr[n] + namearr[n + 1]).equals(namestr[m] + namestr[m + 1])) {
                                    emailarr.add(email[i]);

                                }
                            }
                        }
                    }
                }
            }
        }
        return emailarr;
    }
    public static List<String> emaillist (List<String> answer) { // 이메일 오름차순으로 바꾼 후 리턴
        Set<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        String[] arr = answer.toArray(new String[answer.size()]);
        Arrays.sort(arr);
        answer = Arrays.asList(arr);
        return answer;
    }
}