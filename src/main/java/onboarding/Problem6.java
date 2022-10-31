package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        final Map<String, String > hashMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {

            final String name = forms.get(i).get(1);
            final String emailForm = forms.get(i).get(0);
            if(name.length() < 1 || name.length() > 20){
                break;
            }

            if( emailForm.length() < 11 || emailForm.length() > 20 || !emailForm.split("@")[1].equals("email.com")){
                break;
            }


            for ( int j = 0 ; j < name.length() - 1 ; j++) {
                final String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if ( !email.equals(forms.get(i).get(0)) ){
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                hashMap.put(key, forms.get(i).get(0));
            }
        }

        final List<String> result = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        return result;
    }


}