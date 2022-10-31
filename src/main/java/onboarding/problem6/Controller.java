package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<String> getSolution(List<List<String>> forms) {
        if (Validation.check(forms)) {
            LeximRepository leximRepo = new LeximRepository();
            EmailRepository emailRepo = new EmailRepository();

            for (int i = 0; i < forms.size(); i++) {
                List<String> personInfo = forms.get(i);
                String personName = personInfo.get(1);
                List<String> leximsFromName = Name.nameToLexims(personName);
                leximRepo.addLexim(leximsFromName);
            }
            for (int i = 0; i < forms.size(); i++) {
                List<String> personInfo = forms.get(i);
                String personEmail = personInfo.get(0);
                String personName = personInfo.get(1);
                if (leximRepo.isNameExistsInRepo(personName)) {
                    emailRepo.addEmail(personEmail);
                }
            }
            emailRepo.sort();
            return emailRepo.getDistinctEmails();
        }
        return Constant.EXCEPTION;
    }
}
