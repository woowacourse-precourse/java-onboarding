package onboarding.problem6;

import java.util.HashMap;
import java.util.Map;

public class NicknameSnippets {
    private Map<String, Integer> snippetAppearedCount;

    public NicknameSnippets(Crews crews) {
        this.snippetAppearedCount = new HashMap<>();
        countAppearedSnippets(crews);
    }

    public boolean isDuplicated(Crew crew) {
        if (!crew.isPossibleToMakeSnippets()) return false;
        for (String snippet : crew.nicknameToSnippets()) {
            if (snippetAppearedCount.get(snippet) > 1) return true;
        }
        return false;
    }

    private void countAppearedSnippets(Crews crews) {
        for (Crew crew : crews.getCrews()) {
            if (!crew.isPossibleToMakeSnippets()) continue;
            for (String snippet : crew.nicknameToSnippets()) {
                snippetAppearedCount.put(snippet, snippetAppearedCount.getOrDefault(snippet, 0) + 1);
            }
        }
    }


}
