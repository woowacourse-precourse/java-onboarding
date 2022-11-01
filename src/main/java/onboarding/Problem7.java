package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 solve = new Problem7();
        solve.procException(solve.hasException(user, friends, visitors));
        Map<String, Integer> memberPoint = new HashMap<>();
        List<String> userFriend = solve.findUserFriend(user, friends);
        memberPoint = solve.getPointByFriend(friends, memberPoint, userFriend);
        memberPoint = solve.getPointByVisitors(visitors, memberPoint, userFriend);

        return solve.sortMemberByPoint(memberPoint);
    }

    private void procException(Boolean isException) {
        if (isException) {
            throw new RuntimeException("Error Occur");
        }
    }

    private boolean hasException(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30)
            return true;
        else if (friends.size() < 1 || 10000 < friends.size())
            return true;
        else if(visitors.size() < 0 || 10000 < visitors.size())
            return false;
        for (List<String> friend : friends) {
            if(friend.get(0).length() < 1 || 30 < friend.get(0).length())
                return true;
            else if(friend.get(1).length() < 1 || 30 < friend.get(1).length())
                return true;
            else if(friend.get(1).equals(friend.get(1).toLowerCase()) == false || friend.get(0).equals(friend.get(0).toLowerCase()) == false)
                return true;
        }
        return false;
    }

    private List<String> sortMemberByPoint(Map<String, Integer> memberPoint) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>(memberPoint.keySet());
        Collections.sort(list, (o1, o2) -> (memberPoint.get(o2).compareTo(memberPoint.get(o1))));
        for (String key : list) {
            if (memberPoint.get(key) != 0)
                result.add(key);
            else if (result.size() == 5)
                break;
        }
        return result;
    }

    private List<String> findUserFriend(String user, List<List<String>> friends){
        List<String> userFriend = new ArrayList<>();
        userFriend.add(user);
        for (List<String> member : friends) {
            if (member.contains(user)) {
                int index = (member.indexOf(user) == 0) ? 1 : 0;
                userFriend.add(member.get(index));
            }
        }
        return userFriend;
    }

    private Map<String, Integer> getPointByFriend(List<List<String>> friends, Map<String, Integer> memberPoint, List<String> userFriend) {
        for (List<String> member : friends) {
            member = new ArrayList<>(member);
            if (userFriend.contains(member.get(0)) && userFriend.contains(member.get(1))) {
                continue;
            } else if (userFriend.contains(member.get(0))) {
                memberPoint.put(member.get(1), 10);
            } else if (userFriend.contains(member.get(1))) {
                memberPoint.put(member.get(0), 10);
            }
        }
        return memberPoint;
    }

    private Map<String, Integer> getPointByVisitors(List<String> visitors, Map<String, Integer> memberPoint,List<String> userFriend) {

        for (String visitor : visitors) {
            if(userFriend.contains(visitor)){
                continue;
            }
            else if (memberPoint.containsKey(visitor)) {
                memberPoint.put(visitor, memberPoint.get(visitor) + 1);
            }
            else {
                memberPoint.put(visitor, 1);
            }
        }
        return memberPoint;
    }


}
