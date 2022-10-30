package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<String> getSolution(List<List<String>> forms) {
        if (Validation.check(forms)) {
            LeximRepository lexims = new LeximRepository();
            EmailRepository emailRepository = new EmailRepository();
            Name.splitLeximsAll(lexims, forms);
            Name.checkNameAll(lexims, forms, emailRepository);
            emailRepository.sort();
            return emailRepository.getDistinctEmails();
        }
        return Constant.EXCEPTION;
    }
}
