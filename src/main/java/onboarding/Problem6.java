package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static boolean[] DuplicateName;
    static List<List<String>> formsT;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        formsT = forms;
        DuplicateName = new boolean[forms.size()];
        findDuplicate();
        AddEmail(answer);
        Collections.sort(answer);
        return answer;
    }
    /*
        forms에 저장된 이름을 하나씩 꺼내고
        이름에서 2개의문자씩 꺼내어 다른 이름과 비교합니다.
        문제의 조건에서 2개의 순차적인 문자만 같아도 해당되기때문에
        3,4개는 비교하지 않고 있습니다.
     */
    private static void findDuplicate() {
        for (int i = 0; i < formsT.size() - 1 ; i++){
            pushWord(formsT.get(i),i);
        }
    }

    private static void pushWord(List<String> form,int i) {
        for (int j = 0; j < form.get(1).length()-1 ; j++){
            String temp = form.get(1).substring(j,j+2);
            compare(temp, i);
        }
    }

    /*
    넘겨받은 문자 2개가 다른 이름에 포함이 된다면
    넘겨준 이름과 비교된 이름이 해당되어 true처리합니다.
     */
    private static void compare(String temp, int i) {
        for (int j = i + 1; j < formsT.size() ; j++){
            if(processVisit(temp ,formsT.get(i))){
                DuplicateName[i] = true;
                DuplicateName[j] = true;
            }
        }
    }

    private static boolean processVisit(String temp, List<String> form) {
        return form.get(1).contains(temp);
    }

    /*
    넘겨받은 문제에서 조건을 만족하고 해당되는 이름을 answer리스트에 넣는 메소드
     */
    private static void AddEmail(List<String> answer) {
        for (int i = 0; i < DuplicateName.length ; i++){
            AddVisitEmail(answer, i);
        }
    }

    private static void AddVisitEmail(List<String> answer, int i) {
        if (DuplicateName[i]){
            answer.add(formsT.get(i).get(0));
        }
    }
}
