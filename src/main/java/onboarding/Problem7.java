package onboarding;

import java.util.*;
import java.util.Collections;


class Friend{
    private String name;
    private int score;

    public Friend(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void plusTen(){
        score += 10;
    }

    public void plusOne(){
        score += 1;
    }

}
public class Problem7{
    public static List<Friend> makeAllList(String user, List<List<String>> friends, List<String> visitors){
        List<Friend> allfriends = new ArrayList<>();
        Set<String> allID = new HashSet<>();

        //friends 목록에 있는 유저 아이디 집합에 add
        for(int i = 0; i<friends.size(); i++){
            for(int j = 0; j<2; j++)
                allID.add(friends.get(i).get(j));
        }

        //visitors 목록에 있는 유저 아이디 집합에 add
        for(int i = 0; i<visitors.size(); i++){
            allID.add(visitors.get(i));
        }

        //user 아이디는 집합에서 제거
        allID.remove(user);

        //집합의 원소들(친구들)을 점수를 초기화해서 친구 목록에 저장
        Iterator<String> iter = allID.iterator();

        while(iter.hasNext()){
           allfriends.add(new Friend(iter.next(), 0));
        }
        return allfriends;
    }

    //freind의 friend 찾아 list로 만들고 친구 리스트를 반환
    public static List<String>  friendsKnowTogether(String user, List<List<String>> friends, List<Friend> allfriends){
        Set<String> userFriendSet = new HashSet<>();
        List<String> userFFList = new ArrayList<>();

        //user와 친구인 아이디 집합에 저장
        for(int i = 0; i<friends.size(); i++){
            if((friends.get(i).get(0)).equals(user)){
                userFriendSet.add(friends.get(i).get(1));
            }else if((friends.get(i).get(1)).equals(user)){
                userFriendSet.add(friends.get(i).get(0));
            }
        }

        //집합을 다시 list로 반환(중복 제거 위해)
        List<String> userFriendList = new ArrayList<>(userFriendSet);

        //user 친구와 친구인 아이디 리스트에 저장
        for(int i= 0; i<friends.size(); i++){
            for(int j = 0; j <userFriendList.size(); j++) {
                if (!(friends.get(i).get(0)).equals(user) | !(friends.get(i).get(1)).equals(user)) {
                    if (friends.get(i).get(0).equals(userFriendList.get(j))) {
                        userFFList.add(friends.get(i).get(1));
                    } else if (friends.get(i).get(1).equals(userFriendList.get(j))) {
                        userFFList.add(friends.get(i).get(0));
                    }
                }
            }
        }


        for(int i = 0; i<userFFList.size(); i++){
            for(int j = 0; j<allfriends.size(); j++){
                if((userFFList.get(i)).equals((allfriends.get(j)).getName())){
                    (allfriends.get(j)).plusTen();
                }
            }
        }
        return userFriendList;

    }

    //visitors 목록에서 찾아 점수 1점씩 추가
    public static void visitorsScore(List<String> visitors, List<Friend> allfriends){
        for(int i = 0; i< visitors.size(); i++){
            for(int j = 0; j<allfriends.size(); j++){{
                if((visitors.get(i)).equals((allfriends.get(j)).getName())){
                    (allfriends.get(j)).plusOne();
                }
            }            }
        }
    }

    //전체 추천 친구 리스트에서 친구 리스트에 있는 친구는 삭제해 줌
    public static void deleteFriends(List<String> userFriendList, List<Friend> allfriends){
        for(int i = 0; i<allfriends.size(); i++){
            for(int j = 0; j<userFriendList.size(); j++){
                if(((allfriends.get(i)).getName()).equals(userFriendList.get(j))){
                    allfriends.remove(i);
                }
            }
        }
    }

    //전체 추천 친구 리스트를 점수 순, 이름 순으로 정렬
    public static void sortRecommendList(List<Friend> allfriends){
        //Comparator<RecommendScore> reverse = Comparator.comparing(RecommendScore::getName);
        allfriends.sort(Comparator.comparing(Friend::getScore).reversed().thenComparing(Friend::getName));

    }

    //전체 추천 친구 리스트에서 점수 0을 제외한 top 5 친구 리스트를 반환
    public static List<String> recommendList(List<Friend> allfriends){
        List<String> list = new ArrayList<>();
        int count =0;
        for(int i = 0; i<allfriends.size(); i++){
            if(allfriends.get(i).getScore() != 0){
                list.add(allfriends.get(i).getName());
                count++;
            }

            if(count == 5)
                break;
        }
        return list;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<Friend> allList = makeAllList(user, friends, visitors);
        List<String> friendList = friendsKnowTogether(user, friends, allList);
        visitorsScore(visitors, allList);
        deleteFriends(friendList, allList);
        sortRecommendList(allList);
        answer = recommendList(allList);

        return answer;
    }
}
