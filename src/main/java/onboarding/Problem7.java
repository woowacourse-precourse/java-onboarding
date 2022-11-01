package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        inputFriend(friends, makeFriendLst(friendsLst(friends), friends), friendsLst(friends));
        getPointFriend(inputFriend(friends, makeFriendLst(friendsLst(friends), friends), friendsLst(friends)), user, makeFriendLst(friendsLst(friends), friends), friends);
        ArrayList<Integer> pointLst = new ArrayList<>();

        for(int i=0; i<makeFriendLst(friendsLst(friends), friends).size(); i++) {
            pointLst.add(0);
        }


        for(int i=0; i<friends.size(); i++) {

            for(int j=0; j<inputFriend(friends, makeFriendLst(friendsLst(friends), friends), friendsLst(friends))[i].size(); j++) {


                if(getPointFriend(inputFriend(friends, makeFriendLst(friendsLst(friends), friends), friendsLst(friends)), user, makeFriendLst(friendsLst(friends), friends), friends).contains(inputFriend(friends, makeFriendLst(friendsLst(friends), friends), friendsLst(friends))[i].get(j))){
                    int tmp = pointLst.get(i);
                    tmp += 10;
                    pointLst.set(i, tmp); // 해당되는 친구의 index
                }
            }
        }

        for(int i=0; i<visitors.size(); i++) {

            Integer a = (Integer) getKey(makeFriendLst(friendsLst(friends), friends), visitors.get(i));
//            visitors.get(a); //i가 visitor요소의 인덱스가 되어야 함
            int tmp = pointLst.get(a);
            tmp += 1;
            pointLst.set(a, tmp); // 해당되는 친구의 index
        }

        System.out.println(pointLst);

        return answer;
    }


    public static List<String> friendsLst (List<List<String>> friends) {
        ArrayList<String> friendsLst = new ArrayList<>();

        for(int i=0; i<friends.size(); i++) {
            if(!friendsLst.contains(friends.get(i).get(0))) {
                friendsLst.add(friends.get(i).get(0));
            }
            if (!friendsLst.contains(friends.get(i).get(1))) {
                friendsLst.add(friends.get(i).get(1));
            }
        }
        return friendsLst;
    }

//    public static Map makeFriendLst (List<String> friendLst, List<List<String>> friends) {
//        Map<Integer, String> map = new HashMap<>();
//
//        for(int i=0; i<friendLst.size(); i++) {
//            map.put(i, friendLst.get(i));
//        }
//
//        System.out.println(map);
//        return map;
//    }
//
//    public static ArrayList<String>[] inputFriend(List<List<String>> friends, Map makeFriendLst, List<String> friendLst) {
//        ArrayList<String>[] allFriendLst = new ArrayList[friendLst.size()];
//
//        for(int i=0; i<friendLst.size(); i++) {
//            allFriendLst[i] = new ArrayList<>();
//        }
//
//
//        for(int i=0; i<friends.size(); i++) {
//            Integer tmp1 = (Integer) getKey(makeFriendLst, friends.get(i).get(0)); // Key를 가져온다 이 key를 바탕으로 2차원 배열에 1번째 요소를 넣는다.
//            allFriendLst[tmp1].add(friends.get(i).get(1));
//            Integer tmp2 = (Integer) getKey(makeFriendLst, friends.get(i).get(1)); // Key를 가져온다 이 key를 바탕으로 2차원 배열에 2번째 요소를 넣는다.
//            allFriendLst[tmp2].add(friends.get(i).get(0));
//        }
//        System.out.println(Arrays.toString(allFriendLst));
//
//        return allFriendLst;
//
//    }
//
//    public static <K, V> K getKey(Map<K, V> map, V value) {
//        for (K key : map.keySet()) {
//            if (value.equals(map.get(key))) {
//                return key;
//            }
//        }
//        return null;
//    }
//
//    public static List<String> getPointFriend(ArrayList<String>[] inputFriend, String user, Map makeFriendLst, List<List<String>> friends) {
//        Integer king = (Integer) getKey(makeFriendLst, user);
//        System.out.println(king);
//
//
//        ArrayList<String> realFriend = new ArrayList<>(); // user의 친구리스트, allFriendLst에서 user 순서의 리스트를 가져오면 됨
//
//        realFriend.addAll(inputFriend[king]);
//        System.out.println(realFriend); //얘네들을 기준으로 가져오면 됨
//
//        return realFriend;
//    }
//
//    public static void getPointVisit(List<String> visitors) {
//
//    }
}
