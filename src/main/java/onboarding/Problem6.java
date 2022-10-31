package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    // 연속으로 포함되는 닉네임 찾기
    private static List<String> findDuplicateName(List<List<String>> forms) {
        Set<String> duplicateName = new HashSet<>();
        List<String> result;
        String current = "";
        String currentName = "";
        int flag;

        for(int i = 0; i < forms.size(); i++) {
            flag = 0;
            current = forms.get(i).get(1);
            for(int j = 0; j < current.length() - 1; j++) {
                currentName = current.substring(j,j+2);
                for(int k = 0; k < forms.size(); k++) {
                    if(i == k || forms.get(k).get(1).length() == 1) {
                        continue;
                    }
                    if(forms.get(k).get(1).contains(currentName)) {
                        duplicateName.add(forms.get(k).get(0));
                        flag = 1;
                    }
                }
            }
            if(flag == 1) {
                duplicateName.add(forms.get(i).get(0));
            }
        }
        result = new ArrayList<>(duplicateName);

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        return findDuplicateName(forms);
    }
}
