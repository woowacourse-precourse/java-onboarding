package onboarding;

import java.util.*;

class Problem_7_Restriction extends Exception {
    public Problem_7_Restriction() {
    }

    ;

    public Problem_7_Restriction(String message) {
        super(message);
    }
}

class RecommandAlgorithm {
    private Set<String> unknownUsers = new TreeSet<>();
    private List<String> userFriends = new ArrayList<>();
    private List<String> friendsOfUserFriends = new ArrayList<>();
    private List<String> visitors = new ArrayList<>();
    private Map<String, Integer> scoresOfFriends = new TreeMap<>();
    private LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    private String user = "";

    RecommandAlgorithm(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) == user) {
                this.userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1) == user) {
                this.userFriends.add(friends.get(i).get(0));
            }
        }
        for (String visitor : visitors) {
            if (this.userFriends.contains(visitor)) {
                continue;
            } else {
                this.visitors.add(visitor);
                this.unknownUsers.add(visitor);
            }
        }
    }

    public void chechException(String user, List<List<String>> friends, List<String> visitors) throws Problem_7_Restriction {
        if (user.length() < 1 || user.length() > 30) {
            throw new Problem_7_Restriction("UserNickNameOutOfRange");
        }
        if (friends.size() < 1 || friends.size() > 10_000) {
            throw new Problem_7_Restriction("FriendsSizeOutOfRange");
        }
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).size() != 2) {
                throw new Problem_7_Restriction("FrindsFormatWrong");
            }
            if (friends.get(i).get(0).length() < 1 || friends.get(i).get(1).length() > 30) {
                throw new Problem_7_Restriction("IdOutOfRange");
            }
        }
        if (visitors.size() > 10_000) {
            throw new Problem_7_Restriction("VisitorsOutOfRange");
        }
        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) < 97 || user.charAt(i) > 122) {
                throw new Problem_7_Restriction("UserIdWrongFormat");
            }
        }
    }
}


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
