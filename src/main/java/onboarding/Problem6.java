package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        String[][] forms2 = convertToArray(forms);

        HashSet<String> emails = new HashSet<>();

        Map<String, String > hashMap = new HashMap<>();

        for (int i = 0; i < forms2.length; i++) {

            final String name = forms2[i][1];

            if(name.length() < 2){
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    String email = hashMap.get(key);
                    if(!email.equals(forms2[i][0])){
                        emails.add(email);
                        emails.add(forms2[i][0]);
                    }
                }
                hashMap.put(key, forms2[i][0]);
            }
        }

        List<String> collect = emails.stream().sorted().collect(Collectors.toList());

        String[] answer2 = collect.toArray(new String[0]);

        List<String> answer = Arrays.asList(answer2);

        return answer;
    }

    public static String[][] convertToArray(List<List<String>> list) {
        String[][] result = new String[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            result[i] = new String[list.get(i).size()];
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }
        return result;
}
}
