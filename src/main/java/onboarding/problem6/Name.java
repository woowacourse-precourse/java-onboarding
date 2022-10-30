package onboarding.problem6;

import java.util.HashMap;
import java.util.List;

public class Name {
    public static void splitLeximsAll(List<String> lexims, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String personName = forms.get(i).get(1);
            splitLexim(lexims, personName);
        }
    }
    public static void checkNameAll(List<String> lexims, List<List<String>> forms, HashMap<String, String> repository) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> personInfo = forms.get(i);
            String personEmail = personInfo.get(0);
            String personName = personInfo.get(1);
            checkName(personName, personEmail, lexims, repository);
        }
    }
    public static void checkName(String name, String email, List<String> lexims, HashMap<String,String> repository) {
        for (int j = 0; j < name.length()-1; j++) {
            if (Util.appearMoreThanTwice(lexims, name.substring(j, j+2))) {
                repository.put(name, email);
                break;
            }
        }
    }
    public static void splitLexim(List<String> repository, String name) {
        for (int j = 0; j < name.length()-1; j++) {
            repository.add(name.substring(j, j+2));
        }
    }
}
