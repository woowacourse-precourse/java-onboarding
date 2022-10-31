package onboarding;

import java.util.*;

public class Problem7 {

    //유저의 친구셋 만들기
    static void setMyFriends(String user,List<List<String>> friends,HashSet<String> myFriends,HashSet<String> notMyFriends){

        for (List<String> friend : friends){
            String a = friend.get(0);
            String b = friend.get(1);

            notMyFriends.add(a);
            notMyFriends.add(b);

            if (Objects.equals(a,user))
                myFriends.add(b);
            else if(Objects.equals(b,user))
                myFriends.add(a);
        }
    }

    //유저의 친구가 아닌사람 리스트를 맵으로 저장
    static void setRecommendList(String user,HashSet<String> myFriends,HashSet<String> notMyFriends,HashMap<String,Integer> recommendList){
        notMyFriends.removeAll(myFriends);
        notMyFriends.remove(user);
        for (String x: notMyFriends)
            recommendList.put(x,0);
    }

    //친구 관계 그래프 만들기
    static void makeGraph (List<List<String>> friends,HashMap<String,List<String>> graph) {
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
    static void countFriend (HashSet<String> myFriends,HashMap<String,Integer> recommendList,HashMap<String,List<String>> graph){
        for (String x:recommendList.keySet()){
            int countFriend = 0;
            if (graph.get(x)==null)
                continue;
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
    static void countVisitor (List<String> visitors,HashSet<String> myFriends,HashMap<String,Integer> recommendList){
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
    static Map<String, Integer> sortList(HashMap<String,Integer> recommendList){
        List<Map.Entry<String,Integer>> list = new ArrayList<>(recommendList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                } else if (o1.getValue()< o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        Map<String,Integer> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<String,Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String,Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashSet<String> myFriends = new HashSet<>();
        HashSet<String> notMyFriends = new HashSet<>();
        HashMap<String,List<String>> graph = new HashMap<>();
        HashMap<String,Integer> recommendList = new HashMap<>();

        //함수 호출해서 완성하기
        setMyFriends(user,friends,myFriends,notMyFriends);
        setRecommendList(user,myFriends,notMyFriends,recommendList);
        makeGraph(friends,graph);

        countFriend(myFriends,recommendList,graph);
        countVisitor(visitors,myFriends,recommendList);

        recommendList.values().remove(0);
        answer = new ArrayList<>(sortList(recommendList).keySet());

        if (answer.size()>5)
            answer.subList(0,5);

        return answer;
    }
}
