package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    static boolean[] DuplicateName;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        DuplicateName = new boolean[forms.size()];
        return answer;
    }
    /*
        forms에 저장된 이름을 하나씩 꺼내고
        이름에서 2개의문자씩 꺼내어 다른 이름과 비교합니다.
        문제의 조건에서 2개의 순차적인 문자만 같아도 해당돼기때문에
        3,4개는 비교하지 않고 있습니다.
     */
    private static void findDuplicate(List<List<String>> forms) {
        StringBuilder sb;
        for (int name = 0; name < forms.size() - 1 ; name++){
            for (int wordIndex = 0; wordIndex < forms.get(name).get(1).length()-1 ; wordIndex++){
                sb = new StringBuilder();
                sb.append(forms.get(name).get(1).charAt(wordIndex)).
                        append(forms.get(name).get(1).charAt(wordIndex+1));
                //compare(forms, sb, name);
            }
        }
    }
}
