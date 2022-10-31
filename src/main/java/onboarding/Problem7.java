package onboarding;


import java.util.*;

public class Problem7 {
	 static HashMap<String, Set<String>> friendGraph = new HashMap<>();

	    private static int countSharedFriend(String person, String user) {
	        int count = 0;
	        for (String person2 : friendGraph.get(person))
	            if (friendGraph.get(user).contains(person2))
	                count++;

	        return count;

	    }
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	HashMap<String, Integer> point = new HashMap<>();
        List<String> sortedFriend;


        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);

            if (!friendGraph.containsKey(f1)) friendGraph.put(f1, new HashSet<>());
            if (!friendGraph.containsKey(f2)) friendGraph.put(f2, new HashSet<>());

            friendGraph.get(f1).add(f2);
            friendGraph.get(f2).add(f1);
        }

        for (String person : friendGraph.keySet()) {
            if (person.equals(user)) continue; //자기 자신이라면 건너뜀
            if (friendGraph.get(user).contains(person)) continue; // 이미 친구라면 건너 뜀

            int count = countSharedFriend(person, user);
            point.put(person, count * 10);
        }

        for (String person : visitors) {
            if (friendGraph.get(user).contains(person)) continue; //이미 친구라면 건너 뜀
            point.put(person, point.getOrDefault(person, 0) + 1);
        }

        sortedFriend = new ArrayList<>(point.keySet());
        sortedFriend.sort((o1, o2) -> {
            if (point.get(o2) > point.get(o1)) return 1;
            if (Objects.equals(point.get(o1), point.get(o2))) return o1.compareTo(o2);
            return -1;
        });

        if (sortedFriend.size() <= 5) return sortedFriend;
        return sortedFriend.subList(0, 4);
    }
}
