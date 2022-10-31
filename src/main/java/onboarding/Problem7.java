package onboarding;

import java.util.*;

public class Problem7 {
    //잘 모르겠어서 일단 주먹구구식 하드 코딩 start!
    //일단 풀고 나중에 배우면서 리팩토링 합시다! 부족한 것을 부끄러워하지 말고 배울 수 있는 기회가 있다고 생각하자!
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 각 사람의 친구 목록을 저장할 해시맵
        HashMap<String, List<String>> friendList = new HashMap<String, List<String>>();

        for (List<String> list : friends) {
            HashSet<String> set = new HashSet<String>();
            HashSet<String> set2 = new HashSet<String>();

            String name = list.get(0);
            String name2 = list.get(1);

            for (List<String> temp : friends) {
                if (temp.contains(name)) {
                    set.add(temp.get(0));
                    set.add(temp.get(1));
                }
                if (temp.contains(name2)) {
                    set2.add(temp.get(0));
                    set2.add(temp.get(1));
                }
            }
            set.remove(name);
            set2.remove(name2);

            List<String> tempList = new ArrayList<>(set);
            List<String> tempList2 = new ArrayList<>(set2);

            friendList.put(name, tempList);
            friendList.put(name2, tempList2);
        }

        //{andole=[shakevan, donut], jun=[shakevan, donut], shakevan=[andole, jun, mrko], donut=[andole, jun, mrko], mrko=[shakevan, donut]}

        HashMap<String, Integer> scoreList = new HashMap<String, Integer>();


        List<String> userFriends = friendList.get(user);

        for (String str : userFriends) {
            scoreList.put(str, 0);
            // str의 친구 리스트에 들어가서 mrko가 없으면 10점추가 mrko가 있으면 0점
            for (String str2 : friendList.get(str)) {

                if (str2.equals(user)) break;
                if (!friendList.containsValue(user)) {
                    // 스코어 리스트에 존재할 때 +10점
                    if (scoreList.containsKey(str2)) scoreList.put(str2, scoreList.get(str2) + 10);
                    // 스코어 리스트에 존재하지 않으면 추가
                    if (!scoreList.containsKey(str2)) scoreList.put(str2, 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (!friendList.get(user).contains(visitor)) {
                if (scoreList.containsKey(visitor)) scoreList.put(visitor, scoreList.get(visitor) + 1);
                if (!scoreList.containsKey(visitor)) scoreList.put(visitor, 1);
            }
        }

        List<String> removeList = new ArrayList<>();
        for (String key : scoreList.keySet()) {
            if (scoreList.get(key) == 0) removeList.add(key);
        }

        for (String key : removeList) {
            scoreList.remove(key);
        }

        List<String> answer = new ArrayList<>(scoreList.keySet());
        return answer;
    }
}
