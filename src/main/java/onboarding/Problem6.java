package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> crewEmailSet = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            extractCrew(i, crewEmailSet, forms);
        }
        List<String> answer = new ArrayList<>(crewEmailSet);
        Collections.sort(answer);
        return answer;
    }

    // 비슷한 이름을 가진 크루의 이메일을 추출한다.
    private static void extractCrew(int preIndex, HashSet<String> nameSet, List<List<String>> forms) {
        String myName = forms.get(preIndex).get(1);
        for (int i = preIndex+1; i < forms.size(); i++) {
            if (checkDuplicate(myName, forms.get(i).get(1))) {
                nameSet.add(forms.get(preIndex).get(0));
                nameSet.add(forms.get(i).get(0));
            }
        }
    }

    // 상대방과 나의 이름사이에 중복된 이름이 있는지 확인한다.
    private static boolean checkDuplicate(String myName, String targetName) {
        for (int i =0; i < myName.length()-1;i++) {
            String sample = myName.substring(i,i+2);
            if (targetName.contains(sample)) return true;
        }
        return false;
    }
}
