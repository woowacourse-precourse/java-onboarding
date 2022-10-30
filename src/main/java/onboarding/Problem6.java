package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    static HashMap<String, String> fragmentMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();

        int lastIndex = 0;
        for (int i = 0; i < forms.size(); i++) {

            String currentName = forms.get(i).get(1);
            String currentEmail = forms.get(i).get(0);

            for (int j = 1; j < currentName.length(); j++) {
                String fragment = String.valueOf(currentName.charAt(j - 1)) + currentName.charAt(j);
                if (map.containsKey(fragment)) {

                } else{
                    map.put(fragment, currentEmail);
                }
                lastIndex++;
            }

        }

        return answer;
    }

    public static void makeMap() {

    }
}
