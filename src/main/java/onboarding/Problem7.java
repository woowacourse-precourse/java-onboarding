package onboarding;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, HashSet<String>> userInfo = createUserInfo(friends);

        HashSet<String> people0 = Sets.newHashSet(userInfo.keySet());
        HashSet<String> people1 = Sets.newHashSet(visitors);
        HashSet<String> mergedPeopleSet = new HashSet<String>();
        mergedPeopleSet.addAll(people0);
        mergedPeopleSet.addAll(people1);
        List<String> mergedPeopleList = Lists.newArrayList(mergedPeopleSet);

        HashMap<String, Integer> pointInfo = createPointInfo(mergedPeopleList);
        HashMap<String, Integer> pointInfo2 = createPointInfo(mergedPeopleList);

        return answer;
    }

    private static HashMap<String, HashSet<String>> createUserInfo(List<List<String>> friends) {
        HashMap<String, HashSet<String>> userInfo = new HashMap<String, HashSet<String>>();
        for (List<String> pair : friends) {
            String people0 = pair.get(0);
            String people1 = pair.get(1);
            if (userInfo.containsKey(people0)) {
                userInfo.get(people0).add(people1);
            } else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people1);
                userInfo.put(people0, temp);
            }
            if (userInfo.containsKey(people1)) {
                userInfo.get(people1).add(people0);
            } else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people0);
                userInfo.put(people1, temp);
            }
        }
        return userInfo;
    }

    private static HashMap<String, Integer> createPointInfo(List<String> people) {
        HashMap<String, Integer> pointInfo = new HashMap<String, Integer>();

        for (String p : people) {
            pointInfo.put(p, 0);
        }
        return pointInfo;
    }
}
