package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        String[][] form = new String[forms.size()][forms.size()];

        for(int i=0;i<forms.size();i++) {
            for(int j=0;j<forms.get(0).size();j++) {
                form[i][j] = forms.get(i).get(j);
            }
        }

        String[] result = checkDuplicatation(form);
        List testList = new ArrayList<>();
        for(int i=0;i<result.length;i++) {
            testList.add(result[i]);
        }

        return testList;
    }

    public static String[] checkDuplicatation(String[][] forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String > hashMap = new HashMap<>();

        for (int i = 0; i < forms.length; i++) {

            final String name = forms[i][1];

            if(name.length() < 2){
                break;
            }

            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if(!email.equals(forms[i][0])){
                        emails.add(email);
                        emails.add(forms[i][0]);
                    }
                }
                hashMap.put(key, forms[i][0]);
            }
        }
        final List<String> collect = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        final String[] results = collect.toArray(new String[0]);

        return results;

    }
}
