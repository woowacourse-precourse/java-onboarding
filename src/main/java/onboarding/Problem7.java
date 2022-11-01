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

    public void findFriendOfUserFriend(List<List<String>> friends, String user) {
        for (int i = 0; i < friends.size(); i++) {
            for (String friend : this.userFriends) {
                if (friends.get(i).get(0) == friend && friends.get(i).get(1) != user) {
                    friendsOfUserFriends.add(friends.get(i).get(1));
                    this.unknownUsers.add(friends.get(i).get(1));
                } else if (friends.get(i).get(1) == friend && friends.get(i).get(0) != user) {
                    friendsOfUserFriends.add(friends.get(i).get(0));
                    this.unknownUsers.add(friends.get(i).get(0));
                }
            }
        }
    }

    public List<String> scoringUnknownUsers() {
        List<String> answerTemp = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        LinkedHashMap<String, Integer> sortedScoreMap = new LinkedHashMap<>();

        int score = 0;
        for (String friend : this.unknownUsers) {
            this.scoresOfFriends.put(friend, score);
        }
        for (String plusTen : this.friendsOfUserFriends) {
            scoresOfFriends.replace(plusTen, scoresOfFriends.get(plusTen) + 10);
        }
        for (String plusOne : this.visitors) {
            scoresOfFriends.replace(plusOne, scoresOfFriends.get(plusOne) + 1);
        }
        List<String> scoresList = new ArrayList<>(scoresOfFriends.keySet());
        Collections.sort(scoresList, (o1, o2) -> (scoresOfFriends.get(o2).compareTo(scoresOfFriends.get(o1))));
        for (String str : scoresList) {
            for (Map.Entry<String, Integer> entry : scoresOfFriends.entrySet()) {
                if (entry.getKey().equals(str)) {
                    sortedScoreMap.put(str, entry.getValue());
                }
            }
        }
        answerTemp.addAll(sortedScoreMap.keySet());
        if (answerTemp.size() > 5) {
            for (int i = 0; i < 5; i++) {
                answer.add(i, answerTemp.get(i));
            }
            return answer;
        }
        return answerTemp;
    }
}


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        try {
            RecommandAlgorithm friend = new RecommandAlgorithm(user, friends, visitors);
            friend.chechException(user, friends, visitors);
            friend.findFriendOfUserFriend(friends, user);
            answer = friend.scoringUnknownUsers();
            return answer;
        } catch (Problem_7_Restriction e) {
            return answer;
        }
    }
}
