package onboarding;

import java.util.*;

public class Problem7 {

    public static class Score{
        String name;
        int score;
        public void changeScore(int update){
            this.score = this.score + update;
        }
        public Score(String name , int score){
            this.name = name;
            this.score = score;

        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Set<String>> friendsMap = new HashMap<>();

        //친구관계 저장
        for (List<String> friendList : friends) {
            for(int i = 0 ; i < friendList.size() ; i++){
                String f1 = friendList.get(0);
                String f2 = friendList.get(1);

                if( !friendsMap.containsKey(f1) && !friendsMap.containsKey(f2) ){  //없는 경우
                    Set<String> f1Friend = new HashSet<>();
                    f1Friend.add(f2);
                    Set<String> f2Friend = new HashSet<>();
                    f2Friend.add(f1);

                    friendsMap.put(f1, f1Friend);
                    friendsMap.put(f2, f2Friend);

                } else if( friendsMap.containsKey(f1) && !friendsMap.containsKey(f2) ) {
                    friendsMap.get(f1).add(f2);

                    Set<String> f2Friend = new HashSet<>();
                    f2Friend.add(f1);

                    friendsMap.put(f2, f2Friend);
                } else if( friendsMap.containsKey(f2) && !friendsMap.containsKey(f1)) {
                    friendsMap.get(f2).add(f1);

                    Set<String> f1Friend = new HashSet<>();
                    f1Friend.add(f2);

                    friendsMap.put(f1, f1Friend);
                }
                else {  //이미 있는 경우
                        friendsMap.get(f1).add(f2);
                        friendsMap.get(f2).add(f1);
                    }
                }
            }


        //순회 -> 같은 친구의 수 * 10 -> 저장
        TreeMap<String, Score> scores = new TreeMap<>();

        Set<String> mrkoFriend = friendsMap.get(user); // 유저의 친구
        System.out.println(mrkoFriend);
        for(int i = 0 ; i < friendsMap.size() ; i++){
            Set<String> keySet = friendsMap.keySet();

            for(String key : keySet){
                int count = 0;
                if( key.equals(user)){
                    continue;
                }
                Set<String> iFriend = friendsMap.get(key);
                for( String friend : iFriend ){
                    System.out.println(friend);
                    if( mrkoFriend.contains(friend) ){
                        count++;
                        System.out.println("count : " + count);
                    }
                }

                scores.put( key, new Score( key, count * 10) );
            }



        }

        // 방문 수 에 따른 점수 저장
        for(String visitor : visitors){
            boolean contains = scores.keySet().contains(visitor);
            if( contains ){
               scores.get(visitor).changeScore(1);
            } else scores.put(visitor, new Score(visitor, 1));
        }

        //scores에서 높은 점수 반환
        List<Score> sortedScore = new ArrayList<>(scores.values());
        System.out.println(scores.get("donut").score);
        sortedScore.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.score - o1.score;
            }
        });
        System.out.println();
        List<String> result = new ArrayList<>();

        sortedScore.forEach(candidate -> {
            System.out.println(candidate.name +" "+ candidate.score);
            if ( candidate.score > 0 && result.size() < 5 && !mrkoFriend.contains(candidate.name))  result.add(candidate.name);
        });

        System.out.println(friendsMap);
        return result;
        }

    }


// 예외 사항 처리