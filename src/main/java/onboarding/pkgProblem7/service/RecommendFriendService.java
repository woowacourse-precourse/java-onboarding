package onboarding.pkgProblem7.service;

import java.util.*;

public class RecommendFriendService {

    /**
     * 친구 관계도를 정리하는 메소드
     * friends를 탐색하여 A와 B가 친구 사이이면 HashA에 B를 추가, HashB에 A를 추가한다.
     * @param friends 서로 친구임을 나타내는 배열
     * @return 모든 사람이 자신의 친구인 목록을 return 받는다.
     */
    public HashMap<String, ArrayList<String>> organizeFriends(List<List<String>> friends){
        HashMap<String,ArrayList<String>> fh = new HashMap<>();

        for(List<String> strList : friends){
            fh.computeIfAbsent(strList.get(0), k -> new ArrayList<>()).add(strList.get(1));
            fh.computeIfAbsent(strList.get(1), k -> new ArrayList<>()).add(strList.get(0));
        }
         return fh;
    }

    //user의 친구 목록을 탐색한다.
    //목록에 있는 친구들의 Hash로 들어가 user의 친구 목록에 있는 사람이 있는지 탐색한다.
    //탐색을 했으면, 별도의 HashSet을 만들어 점수를 저장한다.

    /**
     * User와 함께 아는 친구의 수만큼 score를 더해주고 저장하는 메소드
     * user의 친구 목록에 있는 사람들을 찾아 organizeFriends에서 검색한다.
     * organizeFriends에서 user와 함께아는 친구가 있으면 score를 더한다.
     * @param user user 이름
     * @param getUserFriends user의 친구 목록
     * @param organizeFriends  {@link #organizeFriends(List)} 에서 정리된 친구 관계도
     * @return 친구의 수만큼 더해진 score를 담고 있는 HashMap 리턴
     */
    public HashMap<String,Integer> addFriendsScore(
            String user, ArrayList<String> getUserFriends, HashMap<String,ArrayList<String>> organizeFriends){
        HashMap<String,Integer> recommendScore = new HashMap<>();

        for(String friend : getUserFriends){
            ArrayList<String> friendOfFriends = organizeFriends.get(friend);
            for(String friendOfFriend : friendOfFriends){
                if(friendOfFriend == user) continue;
                recommendScore.put(friendOfFriend,recommendScore.getOrDefault(friendOfFriend,0)+10);
            }
        }
        return recommendScore;
    }

    /**
     * 방문기록을 확인하여 score 1을 더하는 메소드
     * @param visitors 방문 기록
     * @param getUserFriends user의 친구 목록
     * @param recommendScore user와 관련된 사람의 score를 담은 hashmap
     */
    public void addVisitorScore(
            List<String> visitors, ArrayList<String> getUserFriends,HashMap<String,Integer> recommendScore) {

        outer:
        for (String visitor : visitors) {
            for (String userFriend : getUserFriends)
                if (visitor == userFriend) continue outer;
            recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + 1);
        }
    }

    /**
     * score로 정렬하고 score가 같다면 이름순으로 정렬하는 메소드.
     * @param list_entries user와 관련된 친구 추천 목록
     */
    public void sortByNameScore(List<Map.Entry<String, Integer>> list_entries){
        Collections.sort(list_entries,((o1, o2) -> {
            if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue().compareTo(o1.getValue());
        }));
    }

    /**
     * 5인 이상이라면 5명까지만 추천하고, 5명보다 적다면 모두 추천하는 메소드.
     * @param list_entries user와 관련된 친구 추천 목록
     * @return 추려낸 추천 목록
     */
    public List<String> getRecommendFriends(List<Map.Entry<String, Integer>> list_entries){
        List<String> recommendList = new ArrayList<>();

        int limitSize = 5;
        int size = list_entries.size() > limitSize ? limitSize : list_entries.size();

        for(int i=0; i<size; i++)
            recommendList.add(list_entries.get(i).getKey());
        return recommendList;
    }
}
