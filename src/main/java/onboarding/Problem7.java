package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class User {

    private final String id;

    private SNS sns;

    User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public SNS getSns() {
        return sns;
    }

    static void validateIdLength(String id) {
        if (id.length() < 1 || 30 < id.length()) {
            throw new IllegalStateException("id는 1이상 30이하의 문자열로 입력해주세요");
        }
    }

    static void validateIdCase(String id) {
        String regex = "^[a-z]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(id);
        if(!m.matches()) {
            throw new IllegalStateException("id는 소문자만 가능합니다.");
        }
    }

    public void addSNS(SNS sns) {
        this.sns = sns;
    }
}

class SNS {

    private final List<String> visitors = new ArrayList<>();
    private User user;

    public SNS(User user) {
        this.user = user;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public void visitSNS(String userId) {
        if (0 <= visitors.size() || visitors.size() <= 10000) {
            visitors.add(userId);
        } else {
            throw new IllegalStateException("방문자가 10000명 이상입니다. 초기화가 필요합니다.");
        }
    }

}
class Relation {
    private static final List<List<String>> friendsTable = new ArrayList<>();
    private static final List<List<String>> requestTable = new ArrayList<>();

    static List<List<String>> findFriends(String id) {
        ArrayList<List<String>>friendList = new ArrayList<>();
        for (int i = 0; i < friendsTable.size(); i++) {
            if (friendsTable.get(i).contains(id)) {
                friendList.add(friendsTable.get(i));
            }
        }
        return friendList;
    }

    static void requestFriend(String from, String to) {
        boolean present = false;
        for (int i = 0; i < requestTable.size(); i++) {
            if (requestTable.get(i)
                    .contains(from) ||
                    requestTable.get(i)
                            .contains(to)) {
                present = isPresent(from, to, present, i);
                friendsTable.add(requestTable.get(i));
                requestTable.remove(i);
            }
        }
        if (!present) {
            requestTable.add(List.of(from, to));
        }
    }

    private static boolean isPresent(String from, String to, boolean isPresent, int i) {
        if (requestTable.get(i)
                .containsAll(List.of(from, to))) {
            isPresent = true;
        }
        return isPresent;
    }
}

class Algorithm {

    private final User user;

    private Map<String, Integer> recommend = new HashMap<>();

    public Algorithm(User user) {
        this.user = user;
    }

    public void scoreVisitors() {
        SNS sns = user.getSns();
        List<String> visitors = sns.getVisitors();
        getVistorsList(visitors);
        calculateVisitorsScore(visitors);
    }

    private void getVistorsList(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            List<List<String>> friends = Relation.findFriends(user.getId());
            extractFriend(visitors, i, friends);
        }
    }

    private static void extractFriend(List<String> visitors, int i, List<List<String>> friends) {
        for (int j = 0; j < friends.size(); j++) {
            if (friends.get(j)
                    .contains(visitors.get(i))) {
                visitors.remove(i);
                break;
            }
        }
    }

    private void calculateVisitorsScore(List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            if (recommend.containsKey(visitors.get(i))) {
                recommend.put(visitors.get(i), (int)(recommend.get(visitors.get(i)) + 1));
            } else {
                recommend.put(visitors.get(i), 1);
            }
        }
    }

    public void scoreKnownFriend() {

        Set<List<String>> knownFriendsSet = makeKnownFriendsSet();
        Iterator<List<String>> iterator = knownFriendsSet.iterator();
        while (iterator.hasNext()) {
            List<String> next = iterator.next();
            String knownFriend = getKnownFriend(next);
            for (int i = 0; i < next.size(); i++) {
                caculateKnownFriendScore(knownFriend);
            }
        }

    }

    private Set<List<String>> makeKnownFriendsSet() {
        HashSet<List<String>> knownFriends = new HashSet<>();

        List<List<String>> friends = Relation.findFriends(user.getId());
        for (int i = 0; i < friends.size(); i++) {
            String friend = choiceFriend(friends.get(i));
            List<List<String>> friendsList = Relation.findFriends(friend);
            for (int j = 0; j < friendsList.size(); j++) {
                knownFriends.add(friendsList.get(j));
            }
        }
        return knownFriends;
    }

    private String getKnownFriend(List<String> next) {
        ArrayList<String> listConverter = new ArrayList<>(next);
        String friend = choiceFriend(listConverter);
        listConverter.remove(friend);
        return listConverter.get(0);
    }

    private String choiceFriend(List<String> friends) {
        String id1 = friends.get(0);
        String id2 = friends.get(1);
        if (id1 != user.getId()) {
            return id1;
        } else {
            return id2;
        }
    }

    private void caculateKnownFriendScore(String knownFriend) {
        if (knownFriend != user.getId() && recommend.containsKey(knownFriend)) {
            recommend.put(knownFriend, (int) (recommend.get(knownFriend) + 10));
        } else if(knownFriend != user.getId()){
            recommend.put(knownFriend, 10);
        }
    }

}