package onboarding;

import java.util.*;

class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userfriendList = new ArrayList<>();
        List<String> withfriendList = new ArrayList<>();
        List<String> visitcount = new ArrayList<>(); // 이미 친구인 사람과 user는 뺌


        HashMap<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                if (friends.get(i).get(0) == user) {
                    userfriendList.add(friends.get(i).get(1));
                } else if (friends.get(i).get(1) == user) {
                    userfriendList.add(friends.get(i).get(0));
                }
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userfriendList.size(); j++) {
                if (friends.get(i).contains(userfriendList.get(j))) {
                    if (friends.get(i).get(0) == userfriendList.get(j)) {
                        withfriendList.add(friends.get(i).get(1));
                    } else if (friends.get(i).get(1) == userfriendList.get(j)) {
                        withfriendList.add(friends.get(i).get(0));
                    }
                }
            }
        }

        while (withfriendList.remove(String.valueOf(user))){} ; // user제거

        Set<String> set = new HashSet<String>(withfriendList);
        List<String> tmpwithfriendList = new ArrayList<String>(set);

        for (int i = 0; i < tmpwithfriendList.size(); i++) {
            map1.put(tmpwithfriendList.get(i), Collections.frequency(withfriendList, tmpwithfriendList.get(i)) * 10);
        }

        visitcount.addAll(visitors);
        for (int i = userfriendList.size() - 1; i >= 0; i--) {
            visitcount.remove(String.valueOf(userfriendList.get(i)));
        }

        Set<String> set2 = new HashSet<String>(visitcount);
        List<String> tmpvisitlist = new ArrayList<String>(set2); // 함께하는 친구 중복제거

        for (int i = 0; i < tmpvisitlist.size(); i++) {
            map1.put(tmpvisitlist.get(i), Collections.frequency(visitcount, tmpvisitlist.get(i)) * 1);
        }

        while(map1.values().remove(0)){}

        List<Map.Entry<String, Integer>> list1 = new LinkedList<>(map1.entrySet());

        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });


        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list1.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }


        return answer;
    }
}