package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");

        List<String> name = new ArrayList<>(forms.size());
        List<String> email = new ArrayList<>(forms.size());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            name.add(i, forms.get(i).get(1));
            email.add(i, forms.get(i).get(0));
        }

        //boolean 배열 두고 i,j 둘다 true 해서 시간 단축 시키기
        for (int i = 0; i < name.size(); i++) {
            for (int j = 0; j < name.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (hasOverlap(name.get(i), name.get(j))) {
                    result.add(email.get(i));
                    break;
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }

    static boolean hasOverlap(String str, String other) {
        for (int i = 0; i < str.length()-1; i++) {
            String unit = str.substring(i, i+2);
            if (other.contains(unit)) {
                return true;
            }
        }
        return false;
    }
}
