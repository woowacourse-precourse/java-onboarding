package onboarding.domain;

import java.util.List;
import java.util.Map;

public class MutualDictionary {
    private final Map<String, Integer> mutualFriendDictionary;

    public MutualDictionary(String user, List<List<String>> relations) {
        this.mutualFriendDictionary = new MutualDictionaryGenerator(user, relations).getDictionary();
    }
}
