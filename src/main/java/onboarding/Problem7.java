package onboarding;

import java.util.*;

public class Problem7 {


    static HashSet<String> myFriends = new HashSet<>();
    static HashSet<String> notMyFriends = new HashSet<>();
    static HashMap<String,List<String>> graph = new HashMap<>();
    static HashMap<String,Integer> recommendList = new HashMap<>();

    //유저의 친구셋 만들기
    static void setMyFriends(String user,List<List<String>> friends){

        HashSet<String> tempMyFriends = new HashSet<>();

        for (List<String> friend : friends){
            String a = friend.get(0);
            String b = friend.get(1);

            notMyFriends.add(a);
            notMyFriends.add(b);

            if (Objects.equals(a,user))
                tempMyFriends.add(b);
            else if(Objects.equals(b,user))
                tempMyFriends.add(a);
        }
        myFriends = tempMyFriends;
    }

    //유저의 친구가 아닌사람 리스트를 맵으로 저장
    static void setRecommendList(String user){
        notMyFriends.removeAll(myFriends);
        notMyFriends.remove(user);
        for (String x: notMyFriends)
            recommendList.put(x,0);
    }

    //친구 관계 그래프 만들기
    static void makeGraph (List<List<String>> friends) {
        for (List<String> friend : friends){
            String u = friend.get(0);
            String v = friend.get(1);


            List<String> list = graph.getOrDefault(u,new ArrayList<>());
            list.add(v);
            graph.put(u,list);

            list = graph.getOrDefault(v,new ArrayList<>());
            list.add(u);
            graph.put(v,list);
        }
        return;
    }

    //함께 아는 친구의 수를 찾아 점수로 환산하기
    static void countFriend (){
        for (String x:recommendList.keySet()){
            int countFriend = 0;
            List<String> list = graph.get(x);
            for (String i :list){
                if (myFriends.contains(i))
                    countFriend++;

            }
            int score = recommendList.get(x);
            score += countFriend*10;
            recommendList.put(x,score);
        }
    }

    //타임라인 방문기록을 점수화 하기
    static void countVisitor (List<String> visitors){
        for (String x: visitors){
            if (recommendList.containsKey(x)){
                int score = recommendList.get(x);
                recommendList.put(x,score+1);
            }
            else if(myFriends.contains(x)){
                continue;
            }
            else{
                recommendList.put(x,1);
            }
        }
    }

    //점수를 기준으로 내림차순하고, 이름을 기준으로 오름차순으로 정렬하기


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //함수 호출해서 완성하기
        return answer;
    }
}
