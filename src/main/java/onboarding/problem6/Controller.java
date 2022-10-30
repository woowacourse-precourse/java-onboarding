package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    public static List<String> getSolution(List<List<String>> forms) {
        if (Validation.check(forms)) {
            List<String> lexims = new ArrayList<>();
            HashMap<String, String> repository = new HashMap<>();
            Name.splitLeximsAll(lexims, forms);
            Name.checkNameAll(lexims, forms, repository);
            List<String> emails = Util.sortAndReturn(repository);
            emails = Util.removeOverlap(emails);
            return emails;
        }
        return Constant.EXCEPTION;
    }
}
