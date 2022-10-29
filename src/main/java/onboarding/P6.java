package onboarding;

import java.util.Arrays;
import java.util.List;

public class P6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        makeNameLst(forms);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> makeNameLst(List<List<String>> forms) {
        String[] nameLst = new String[forms.size()];

        for(int i=0; i< forms.size(); i++) {
            nameLst[i] = "";
        }

        for(int i=0; i<forms.size(); i++) {
            nameLst[i] = forms.get(i).get(1);
        }
//        System.out.println(Arrays.toString(nameLst));
        return Arrays.asList(nameLst);
    }

    public static void loop(List<String> nameLst) {
        for(int i=0; i<nameLst.size(); i++) {
            /**
             * A기준 A[i], A[j] 연속된 문자에 대해서 완전탐색
             * B기준 위와 동일
             */


            for(int j=0; j<nameLst.size(); j++) {
                /**
                 *모든 이름들을 돌며 정해진 문자에 대해서
                 * 동일한 문자가 있는지 탐색
                 * A[i], A[i+1] == B[i][i+1], C[i][i+1]
                 */
            }
        }

    }
}
