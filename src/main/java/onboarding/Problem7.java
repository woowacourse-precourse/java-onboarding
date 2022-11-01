package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        // 친구명과 점수
        HashMap<String, Integer> friendsScore = new HashMap<>();

        // 친구 관계를 표시할 HashMap
        HashMap<String, ArrayList<String>> friendsMap = new HashMap<String, ArrayList<String>>();

        // 친구 관계 friendsMap 만들기
        for(List<String> friendsRelation : friends) {
            makeFriendsMap(friendsRelation, friendsMap);
        }

        // 친구들의 Score 초기화
        for(String friend : friendsMap.keySet()) {
            makeFriendsScore(friend, user, friendsScore);
        }


        // 친구 관계 점수 추가
        for(String friend : friendsScore.keySet()) {
            if(haveNoFriends(user, friendsMap)) {
                break;
            }

            if(isUserFriend(friend, user, friendsMap)) {
                continue;
            }
            addFriendScore(friend, friendsScore, getSameFriendsScore(user, friend, friendsMap));
        }

        // 방문자 추가
        for(String friend : visitors) {
            makeFriendsScore(friend, user, friendsScore);
        }

        // 방문자 점수 추가
        for(String friend : visitors) {
            if(!haveNoFriends(user, friendsMap)) {
                if(isUserFriend(friend, user, friendsMap)) {
                    continue;
                }
            }
            addFriendScore(friend, friendsScore, 1);
        }

        // 정렬
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer>>(friendsScore.entrySet());
        sortByValueAndKey(list);

        // 추천 순 리스트 만들기
        ArrayList<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> friend : list) {
            getCandidateList(friend, res);
        }

        // 5명 또는 그 이하 추천 리스트 만들기
        answer = new ArrayList<>(getFriendsList(res));
        return answer;
    }

    public static void makeFriendsMap(List<String> friendsRelation, HashMap<String, ArrayList<String>> friendsMap) {
        String friend1 = friendsRelation.get(0);
        String friend2 = friendsRelation.get(1);

        if(friendsMap.containsKey(friend1)) {
            friendsMap.get(friend1).add(friend2);
        } else {
            friendsMap.put(friend1, new ArrayList<>(Arrays.asList(friend2)));
        }

        if(friendsMap.containsKey(friend2)) {
            friendsMap.get(friend2).add(friend1);
        } else {
            friendsMap.put(friend2, new ArrayList<>(Arrays.asList(friend1)));
        }
    }

    public static void makeFriendsScore(String friend, String user, HashMap<String, Integer> friendsScore) {
        if(!friend.equals(user) && !friendsScore.containsKey(friend)) {
            friendsScore.put(friend, 0);
        }
    }

    public static Integer getSameFriendsScore(String user, String friend, HashMap<String, ArrayList<String>> friendsMap) {
        int score = 0;
        for(String userFriend : friendsMap.get(user)) {
            if(friendsMap.get(friend).contains(userFriend)) {
                score += 10;
            }
        }
        return score;
    }

    public static boolean haveNoFriends(String user, HashMap<String, ArrayList<String>> friendsMap) {
        if(!friendsMap.containsKey(user)) {
            return true;
        }

        return false;
    }
    public static boolean isUserFriend(String friend, String user, HashMap<String, ArrayList<String>> friendsMap) {
        for(String userFriend : friendsMap.get(user)) {
            if(friend.equals(userFriend)) {
                return true;
            }
        }
        return false;
    }
    public static void addFriendScore(String friend, HashMap<String, Integer> friendsScore, Integer value) {
        Integer curScore = friendsScore.get(friend);
        curScore += value;
        friendsScore.put(friend, curScore);
    }


    public static void sortByValueAndKey(List<Map.Entry<String, Integer> > list) {
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int diff = o1.getValue() - o2.getValue();
                if(diff < 0) {
                    return 1;
                } else if (diff == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return -1;
                }
            }
        });
    }

    public static void getCandidateList(Map.Entry<String, Integer> friend, ArrayList<String> res) {
        if(friend.getValue() > 0) {
            res.add(friend.getKey());
        }
    }

    public static List<String> getFriendsList(ArrayList<String> res) {
        if(res.size() < 5) {
            return res;
        } else {
            return res.subList(0, 5);
        }
    }
}
