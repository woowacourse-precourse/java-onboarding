package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> dupName(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> formsMap = new HashMap<>();
        ArrayList<String> nameArr = new ArrayList<>();
        ArrayList<String> dupName = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            formsMap.put(forms.get(i).get(1), forms.get(i).get(0));
            nameArr.add(forms.get(i).get(1));
        }

        Arrays.sort(new ArrayList[]{nameArr});
        for (int i = 0; i < nameArr.size(); i++) {
            for (int j = i + 1; j < nameArr.size(); j++) {
                for (int k = 0; k < nameArr.get(i).length() - 1; k++) {
                    if (nameArr.get(j).contains(nameArr.get(i).substring(k, k + 2))) {
                        if (!dupName.contains(nameArr.get(i))) {
                            dupName.add(nameArr.get(i));
                        }
                        if (!dupName.contains(nameArr.get(j))) {
                            dupName.add(nameArr.get(j));
                        }
                        break;
                    }
                }
            }
        }

        for (String str : dupName) {
            answer.add(formsMap.get(str));
        }

        Collections.sort(answer);

        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = dupName(forms);
        return answer;
    }
}
