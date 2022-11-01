package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;



public class Problem6 {
    public static String[] solution(List<List<String>> forms) {

       forms = new ArrayList<List<String>>();

        String[][] array = forms.stream().map(item -> item.stream().toArray()).toArray(String[][]::new);


           String[] answer = new String[array.length];


            HashSet<String> emails = new HashSet<>();

            final Map<String, String > hashMap = new HashMap<>();

            for (int i = 0; i < array.length; i++) {

                final String name = array[i][1];

                if(name.length() < 2){
                    break;
                }


                for (int j = 0; j < name.length() - 1; j++) {
                    final String key = name.substring(j, j+2);
                    if(hashMap.containsKey(key)){
                        final String email = hashMap.get(key);
                        if(!email.equals(array[i][0])){
                            emails.add(email);
                            emails.add(array[i][0]);
                        }
                    }
                    hashMap.put(key, array[i][0]);
                }
            }

            final List<String> collect = emails.stream()
                    .sorted()
                    .collect(Collectors.toList());

            final String[] results = collect.toArray(new String[0]);

            return results;
        }

    }

