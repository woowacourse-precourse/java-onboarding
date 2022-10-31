package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class PairList {
    List<Pair> content = new ArrayList<>();

    PairList(List<List<String>> forms) {
        forms.forEach(pair -> content.add(new Pair(pair)));
    }

    List<String> splitIntoLexims(LeximRepository leximRepo) {
        List<String> splittedLexims = new ArrayList<>();
        content.forEach(pair -> {
            String personName = pair.getName();
            List<String> leximsFromName = Name.nameToLexims(personName);
            splittedLexims.addAll(leximsFromName);
        });
        return splittedLexims;
    }
    List<String> getRestrictedEmails(LeximRepository leximRepo) {
        List<String> restrictedEmails = new ArrayList<>();
        content.forEach(pair -> {
            String personEmail = pair.getEmail();
            String personName = pair.getName();
            if (leximRepo.isNameExistsInRepo(personName)) {
                restrictedEmails.add(personEmail);
            }
        });
        return restrictedEmails;
    }
}
