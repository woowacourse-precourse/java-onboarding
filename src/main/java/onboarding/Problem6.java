package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static boolean[] DuplicateName;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        DuplicateName = new boolean[forms.size()];
        findDuplicate(forms);
        AddEmail(forms, answer);
        Collections.sort(answer);
        return answer;
    }
    /*
        forms에 저장된 이름을 하나씩 꺼내고
        이름에서 2개의문자씩 꺼내어 다른 이름과 비교합니다.
        문제의 조건에서 2개의 순차적인 문자만 같아도 해당되기때문에
        3,4개는 비교하지 않고 있습니다.
     */
    private static void findDuplicate(List<List<String>> forms) {
        StringBuilder sb;
        for (int i = 0; i < forms.size() - 1 ; i++){
            for (int j = 0; j < forms.get(i).get(1).length()-1 ; j++){
                sb = new StringBuilder();
                sb.append(forms.get(i).get(1).charAt(j)).
                        append(forms.get(i).get(1).charAt(j+1));
                compare(forms, sb, i);
            }
        }
    }
    /*
    넘겨받은 문자 2개가 다른 이름에 포함이 된다면
    넘겨준 이름과 비교된 이름이 해당되어 true처리합니다.
     */
    private static void compare(List<List<String>> forms, StringBuilder sb, int j) {
        for (int i = j + 1; i < forms.size() ; i++){
            if (forms.get(i).get(1).contains(sb.toString())){
                DuplicateName[i] = true;
                DuplicateName[i] = true;
            }
        }
    }
    /*
    넘겨받은 문제에서 조건을 만족하고 해당되는 이름을 answer리스트에 넣는 메소드
     */
    private static void AddEmail(List<List<String>> forms, List<String> answer) {
        for (int i = 0; i < DuplicateName.length ; i++){
            if (DuplicateName[i]){
                answer.add(forms.get(i).get(0));
            }
        }
    }
}
