package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static String[] getDeduplication(List<List<String>> forms) {

        String[][] array = forms.stream()
                .map(item -> item.stream().toArray())
                .toArray(String[][]::new);

        String[] answer = new String[array.length];
        HashSet <String> emails = new HashSet<>();
        Map <String, String> tmpHashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            String name = array[i][1];

            if(name.length() < 2){
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);

                if(tmpHashMap.containsKey(key)){
                    String email = tmpHashMap.get(key);

                    if(!email.equals(array[i][0])) {
                        emails.add(email);
                        emails.add(array[i][0]);
                    }
                }
                tmpHashMap.put(key, array[i][0]);
            }
        }

        List <String> collect = emails.stream().sorted().collect(Collectors.toList());

        return collect.toArray(new String[0]);

    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Arrays.asList(getDeduplication(forms));
        return answer;
    }
}
