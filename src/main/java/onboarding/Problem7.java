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