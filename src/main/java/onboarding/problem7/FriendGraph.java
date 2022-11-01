package onboarding.problem7;

import onboarding.problem7.exception.FriendArrayOutOfSizeException;

import java.util.*;

public class FriendGraph {
    private static final int MIN_FRIEND_LIST_SIZE = 1;
    private static final int MAX_FRIEND_LIST_SIZE = 10_000;
    private final Map<String, List<String>> graph = new HashMap<>();

    public FriendGraph(List<List<String>> initData) {
        initGraph(initData);
    }

    public List<String> getFriends(String user) {
        return graph.get(user);
    }

    private void initGraph(List<List<String>> initData) {
        validateFriendCount(initData.size());
        initData.stream()
                .map(FriendPair::new)
                .forEach(this::initGraphElement);
    }

    private void validateFriendCount(int count) {
        if (count < MIN_FRIEND_LIST_SIZE || count > MAX_FRIEND_LIST_SIZE) {
            throw new FriendArrayOutOfSizeException();
        }
    }

    private void initGraphElement(FriendPair pair) {
        if (!graph.containsKey(pair.getUser1())) {
            graph.put(pair.getUser1(), new ArrayList<>());
        }

        if (!graph.containsKey(pair.getUser2())) {
            graph.put(pair.getUser2(), new ArrayList<>());
        }

        putPair(pair);
    }

    private void putPair(FriendPair pair) {
        graph.get(pair.getUser1()).add(pair.getUser2());
        graph.get(pair.getUser2()).add(pair.getUser1());
    }

}
