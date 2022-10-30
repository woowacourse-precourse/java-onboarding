package onboarding.problem6;

import java.util.List;

public class Name {
    public static void splitLeximsAll(LeximRepository leximRepo, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String personName = forms.get(i).get(1);
            splitLexim(leximRepo, personName);
        }
    }
    public static void checkNameAll(LeximRepository leximRepo, List<List<String>> forms, EmailRepository emailRepo) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> personInfo = forms.get(i);
            String personEmail = personInfo.get(0);
            String personName = personInfo.get(1);
            checkName(personName, personEmail, leximRepo, emailRepo);
        }
    }
    public static void checkName(String name, String email, LeximRepository leximRepo, EmailRepository emailRepo) {
        for (int j = 0; j < name.length()-1; j++) {
            if (leximRepo.countLexim(name.substring(j, j+2)) > 2) {
                emailRepo.addEmail(email);
                break;
            }
        }
    }
    public static void splitLexim(LeximRepository leximRepo, String name) {
        for (int j = 0; j < name.length()-1; j++) {
            leximRepo.addLexim(name.substring(j, j+2));
        }
    }
}
