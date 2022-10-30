package onboarding.problem6;

import java.util.List;

public class Name {
    public static void splitLeximsAll(LeximRepository leximRepo, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String personName = forms.get(i).get(1);
            List<String> leximsFromName = leximRepo.splitNameIntoLexim(personName);
            leximRepo.addLexim(leximsFromName);
        }
    }
    public static void checkNameAll(LeximRepository leximRepo, List<List<String>> forms, EmailRepository emailRepo) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> personInfo = forms.get(i);
            String personEmail = personInfo.get(0);
            String personName = personInfo.get(1);
            if (leximRepo.isNameExistsInRepo(personName)) {
                emailRepo.addEmail(personEmail);
            }
        }
    }


}
