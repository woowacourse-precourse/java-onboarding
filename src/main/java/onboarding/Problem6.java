package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, String> crew = new HashMap<>();
    static Set<String> crewSet = new HashSet<>();

    static boolean checkName(String name) {
        return crew.containsKey(name);
    }

    static List<String> creatCrew(List<List<String>> forms) {
        int crewLegnth = forms.size();
        for(int i = 0; i < crewLegnth; i++) {
            int nameLength = forms.get(i).get(1).length();
            if(nameLength == 1) {
                String name = forms.get(i).get(1);
                String email = forms.get(i).get(0);
                if(checkName(name)) {
                    crewSet.add(crew.get(name));
                    crewSet.add(email);
                    continue;
                }
                crew.put(name, email);
                continue;
            }
            for(int j = 0; j < nameLength - 1; j++) {
                String name = forms.get(i).get(1).substring(j, j + 2);
                String email = forms.get(i).get(0);
                if(checkName(name)) {
                    crewSet.add(crew.get(name));
                    crewSet.add(email);
                    continue;
                }
                crew.put(name, email);
            }
        }
        ArrayList<String> list = new ArrayList<>(crewSet);

        return list;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = creatCrew(forms);
        return answer;
    }
}
