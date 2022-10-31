package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendMap {

    public HashMap<String, List<String>> createFriendList(List<List<String>> relationships) {

        HashMap<String, List<String>> friendMap = new HashMap<>();

        for (List<String> relation : relationships) {

            String friendA = relation.get(0);
            String friendB = relation.get(1);

            List<String> aRelationship = friendMap.getOrDefault(friendA, new ArrayList<>());
            List<String> bRelationship = friendMap.getOrDefault(friendB, new ArrayList<>());

            aRelationship.add(friendB);
            bRelationship.add(friendA);

            friendMap.put(friendA, aRelationship);
            friendMap.put(friendB, bRelationship);

        }

        return friendMap;
    }

}
