package onboarding;
;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();
        if (forms.size()==1){
            return answer;
        }
        answer = formController.findEmailOfDuplicateNickname(forms);
        Collections.sort(answer, String.CASE_INSENSITIVE_ORDER);
        return answer;
    }
}


class formController{
    static final int EMAIL = 0;
    static final int NICKNAME = 1;

    private static boolean isSingleLetter(String name) {
        return (name.length() == 1);
    }

    private static boolean isDuplicate(String baseName, String targetName) {
        if (isSingleLetter(targetName)) {
            return false;
        }
        for (int i = 0; i < baseName.length() - 1; i++) {
            if (targetName.contains(baseName.substring(i, i + 2))){
                return true;
            }
        }
        return false;
    }

    private static void removeCheckedName(ArrayList<List<String>> targetList, List<Integer> checkedIndex) {
        for (int i = 0; i < checkedIndex.size(); i++) {
            targetList.remove(checkedIndex.get(i));
        }
    }

    static List<String> findEmailOfDuplicateNickname(List<List<String>> input){
        ArrayList<List<String>> unCheckedList = new ArrayList<>(List.copyOf(input));
        List<Integer> checkedIndex;
        Set<String> result = new HashSet<>();
        List<String> cmpBase, cmpTarget;


        for (int i = 0; i < input.size(); i++) { // 전체 크루원을 한 명씩 비교 기준으로 선정
            cmpBase = input.get(i);

            if (isSingleLetter(cmpBase.get(NICKNAME))) {
                continue;
            }
            checkedIndex = new ArrayList<>();
            for (int j = 0; j < unCheckedList.size(); j++) { // 아직 중복이 입력되지 않은 크루원들을 기준과 비교
                cmpTarget = unCheckedList.get(j);

                if(cmpTarget.equals(cmpBase)) continue; // 같은 이메일, 이름이라면 같은 사람이라고 판단, 결과에 넣지 않음
                if(isDuplicate(cmpBase.get(NICKNAME), cmpTarget.get(NICKNAME))) {
                    result.add(cmpTarget.get(EMAIL));
                    checkedIndex.add(j);
                }
            }
            removeCheckedName(unCheckedList, checkedIndex);
        }

        ArrayList<String> resultArray = new ArrayList<>(result);
        return resultArray;
    }

}
