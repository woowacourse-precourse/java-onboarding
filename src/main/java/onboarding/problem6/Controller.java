package onboarding.problem6;

import java.util.List;

public class Controller {
    public static List<String> getSolution(List<List<String>> forms) {
        if (Validation.check(forms)) {
            LeximRepository leximRepo = new LeximRepository();
            EmailRepository emailRepo = new EmailRepository();
            PairList pairList = new PairList(forms);
            leximRepo.addLexim(pairList.splitIntoLexims(leximRepo));
            emailRepo.addEmail(pairList.getRestrictedEmails(leximRepo));
            emailRepo.sort();
            return emailRepo.getDistinctEmails();
        }
        return Constant.EXCEPTION;
    }
}
