package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (violateId(user)) return Collections.emptyList();
        if (violateFriends(friends)) return Collections.emptyList();
        if (violateVisitors(visitors)) return Collections.emptyList();

        List<String> answer = Collections.emptyList();

        return answer;
    }

    static boolean violateId(String id) {
        int length = id.length();
        if (length == 0 || length > 30) return true;
        String regex = "^[a-z]*";
        return !Pattern.matches(regex, id);
    }

    static boolean violateFriends(List<List<String>> friends) {
        int size = friends.size();
        if (size == 0 || size > 10000) return true;
        Set<Friend> friendSet = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.size() != 2) return true;
            String a = friend.get(0);
            String b = friend.get(1);
            if (violateId(a)) return true;
            if (violateId(b)) return true;
            if (a.equals(b)) return true;
            if (!friendSet.add(new Friend(a, b))) return true;
        }
        return false;
    }

    static boolean violateVisitors(List<String> visitors) {
        int size = visitors.size();
        if (size == 0 || size > 10000) return true;
        for (String visitor : visitors) {
            if (violateId(visitor)) return true;
        }
        return false;
    }

    static class Friend {
        String a;
        String b;

        Friend(String a, String b) {
            if (a.compareTo(b) >= 0) {
                this.a = a;
                this.b = b;
            } else {
                this.b = a;
                this.a = b;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
