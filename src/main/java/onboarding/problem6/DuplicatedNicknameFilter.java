package onboarding.problem6;

import java.util.List;
import java.util.stream.Collectors;

public class DuplicatedNicknameFilter {
    private NicknameSnippets nicknameSnippets;
    private Crews crews;

    public DuplicatedNicknameFilter(NicknameSnippets nicknameSnippets, Crews crews) {
        this.nicknameSnippets = nicknameSnippets;
        this.crews = crews;
    }

    public List<String> filter() {
        return getDuplicatedNicknameCrews()
                .getCrews()
                .stream()
                .map(Crew::getEmail)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private Crews getDuplicatedNicknameCrews() {
        Crews duplicatedNicknameCrews = new Crews();

        for (Crew crew : crews.getCrews()) {
            if (nicknameSnippets.isDuplicated(crew)) {
                duplicatedNicknameCrews.add(crew);
            }
        }

        return duplicatedNicknameCrews;
    }
}
