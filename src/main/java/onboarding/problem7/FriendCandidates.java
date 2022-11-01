package onboarding.problem7;

import onboarding.problem7.exception.RecommendListNotExistException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FriendCandidates {
    private static final int FRIEND_CANDIDATE_COUNT = 5;
    private final List<FriendCandidate> friendCandidates = new ArrayList<>();


    public void add(FriendCandidate friendCandidate) {
        friendCandidates.add(friendCandidate);
    }

    public List<String> getTop5MemberName() {
        checkIsEmpty();
        sortReverseOrder();
        List<String> memberNames = friendCandidates.stream()
                .map(FriendCandidate::getName)
                .collect(Collectors.toList());

        return toSubList(memberNames);
    }
    private void checkIsEmpty() {
        if(friendCandidates.isEmpty()) {
            throw new RecommendListNotExistException();
        }
    }

    private List<String> toSubList(List<String> friendTopList) {
        if(friendTopList.size() <= FRIEND_CANDIDATE_COUNT) {
            return friendTopList;
        }

        return friendTopList.subList(0, FRIEND_CANDIDATE_COUNT);
    }

    private void sortReverseOrder() {
        friendCandidates.sort(Comparator.reverseOrder());
    }
}
