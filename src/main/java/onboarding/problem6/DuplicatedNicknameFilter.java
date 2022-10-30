package onboarding.problem6;

public class DuplicatedNicknameFilter {
    private NicknameSnippets nicknameSnippets;
    private Crews crews;

    public DuplicatedNicknameFilter(NicknameSnippets nicknameSnippets, Crews crews) {
        this.nicknameSnippets = nicknameSnippets;
        this.crews = crews;
    }

    public Crews getDuplicatedNicknameCrews() {
        Crews duplicatedNicknameCrews = new Crews();

        for (Crew crew : crews.getCrews()) {
            if (nicknameSnippets.isDuplicated(crew)) {
                duplicatedNicknameCrews.add(crew);
            }
        }

        return duplicatedNicknameCrews;
    }
}
