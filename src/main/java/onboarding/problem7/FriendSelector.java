package onboarding.problem7;

import java.util.Map;

/**
 * Select new friends from candidates
 */
public class FriendSelector {

    private final Map<String, Friend> candidates;

    /**
     * Constructor with candidates
     * @param candidates new friend candidates
     */
    public FriendSelector(Map<String, Friend> candidates) {
        this.candidates = candidates;
    }
}
