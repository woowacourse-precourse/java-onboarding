package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, String> crews = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        initialCrews(forms);
        List<String> answer = deleteEmailDuplicate(checkDuplicate());
        Collections.sort(answer);
        return answer;
    }

    private static List<String> deleteEmailDuplicate(List<String> emailList) {
        Set<String> emailSet = new HashSet<>(emailList);
        return new ArrayList<>(emailSet);
    }

    private static void initialCrews(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> crew = forms.get(i);
            crews.put(crew.get(1), crew.get(0));
        }
    }

    private static List<String> checkDuplicate() {
        List<String> result = new ArrayList<>();
        String[] names = crews.keySet().toArray(new String[0]);
        String name;
        for (int i = 0; i < names.length; i++) {
            name = names[i];
            for (int j = 1; j < name.length(); j++) {
                String temp = String.valueOf(name.charAt(j - 1) + name.charAt(j));
                for (String otherName : names) {
                    if (otherName.contains(temp)) {
                        result.add(crews.get(name));
                        result.add(crews.get(otherName));
                    }
                }
            }
        }

        return result;
    }

}
