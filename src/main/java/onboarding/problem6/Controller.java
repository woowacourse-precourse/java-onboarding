package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<String> getSolution(List<List<String>> forms) {
        if (Validation.check(forms)) {
            LeximRepository leximRepo = new LeximRepository();
            EmailRepository emailRepo = new EmailRepository();
            forms.forEach(pair -> {
                String personName = pair.get(1);
                List<String> leximsFromName = Name.nameToLexims(personName);
                leximRepo.addLexim(leximsFromName);
            });
            forms.forEach(pair -> {
                String personEmail = pair.get(0);
                String personName = pair.get(1);
                if (leximRepo.isNameExistsInRepo(personName)) {
                    emailRepo.addEmail(personEmail);
                }
            });
            emailRepo.sort();
            return emailRepo.getDistinctEmails();
        }
        return Constant.EXCEPTION;
    }
}
