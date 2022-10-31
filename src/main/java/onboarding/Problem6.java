package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = duplicatedCrewEmail(forms);
        return answer;
    }
    private static List<String> duplicatedCrewEmail(List<List<String>> forms) {

        Set<String> e = (Set<String>) duplicatedCrewEmail(forms);
        List<String> emailList = new ArrayList<>(e);

        sortEmailList(emailList);

        return emailList;
    }
    private static Set<String> getDuplicatedEmailSet(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        Map<Integer, Set<String>> charSetEmailMap = new HashMap<>();
        for(List<String> form : forms) {
            putCharSet(form, charSetEmailMap);
        }

        charSetEmailMap.forEach((strKey, setValue) -> {
            if(setValue.size() >= 2) {
                result.addAll(setValue);
            }
        });

        return result;
    }

    private static void putCharSet(List<String> form, Map<Integer, Set<String>> charSetEmailMap) {
        String nickname = form.get(1);
        String email = form.get(0);

        for(int node = 0; node < nickname.length() -1; node++) {
            String charSet = nickname.substring(node, node+2);
            int charSetHashCode = charSet.hashCode();

            if(charSetEmailMap.containsKey(charSetHashCode)) {
                charSetEmailMap.get(charSetHashCode).add(email);
            } else {
                Set<String> emailSet = new HashSet<>();
                emailSet.add(email);
                charSetEmailMap.put(charSetHashCode,emailSet);
            }
        }
    }

    private static void sortEmailList(List<String> emailList){
        Collections.sort(emailList, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return e1.split("@")[0].compareTo(e2.split("@")[0]);
            }
        });
    }
}
