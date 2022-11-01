package onboarding;

import java.util.*;

public class Problem7 {


    public static HashMap<String, Integer> set_member_score(HashMap<String, Integer> member_score,
                                                            String user,
                                                            HashMap<String, List<String>> member_hash,
                                                            List<String> visited){
        Set<String> not_me_member = member_hash.keySet();
        for (String member : not_me_member){
            if (!member.equals(user)){
                member_score.put(member, 0);
            }
        }
        for (String member : visited){
            if (!member.equals(user)){
                member_score.put(member, 0);
            }
        }

        return member_score;
    } // 각 사람들의 해당되는 점수를 의미함

    public static HashMap<String, Integer> visited_score(HashMap<String, Integer> member, List<String> visitors, List<String> user_friends){
        for (String visitor : visitors){
            if (!user_friends.contains(visitor)) {
                Integer score = member.get(visitor);
                member.put(visitor, score + 1);
            }
        }
        return member;
    } // 방문하는 사람들을 통해서 얻게 되는 점수를 반영

    public static HashMap<String, List<String>> set_member(
            HashMap<String, List<String>> member_hash,
            List<List<String>> friends,
            List<String> visited){
        for (List<String> friend : friends){
            String person1 = friend.get(0);
            String person2 = friend.get(1);
            List<String> related_member = new ArrayList<>();
            if (!member_hash.containsKey(person1)){
                related_member.add(person2);
                member_hash.put(person1, related_member);
            } else {
                related_member = member_hash.get(person1);
                if (related_member.contains(person1)){continue;}
                related_member.add(person2);
                member_hash.put(person1, related_member);
            }

            related_member = new ArrayList<>();
            if (!member_hash.containsKey(person2)){
                related_member.add(person1);
                member_hash.put(person2, related_member);
            } else {
                related_member = member_hash.get(person2);
                if (related_member.contains(person1)){continue;}
                related_member.add(person1);
                member_hash.put(person2, related_member);
            }
        }
        for (String visitor : visited){
            List<String> related_member = new ArrayList<>();
            if (!member_hash.containsKey(visitor)){
                member_hash.put(visitor, related_member);
            }
        }

        return member_hash;
    } // 처음에 member에 대해서 설정하는 변수 - 해쉬를 통해서 친구가 되어 있는 사람들의 목록을 알 수 있다.


    public static HashMap<String, Integer> member_related_score(HashMap<String, Integer> member_score,
                                                                String user,
                                                                HashMap<String, List<String>> member_hash){
        List<String> user_related = member_hash.get(user);
        for (String related_friend : user_related){
            List<String> related_friend_related = member_hash.get(related_friend);
            for (String target_friend : related_friend_related){
                if (!target_friend.equals(user) && !user_related.contains(target_friend)) {
                    member_score.put(target_friend, member_score.get(target_friend) + 10);
                }
            }
        }
        return member_score;
    } // 함께 아는 친구를 통해서 점수를 얻는 method





    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, List<String>> member_hash = new HashMap<>();
        HashMap<String, Integer> member_score = new HashMap<>();
        member_hash = set_member(member_hash, friends, visitors);
        List<String> user_friends = new ArrayList<>(member_hash.get(user));
        member_score = set_member_score(member_score, user, member_hash, visitors);
        member_score = visited_score(member_score, visitors, user_friends);
        member_score = member_related_score(member_score, user, member_hash);


        // 지금까지 점수를 토대로 배열에 정렬하고, 0보다 큰 것들 중에서 5개까지의 사람 이름을 return한다.
        List<Map.Entry<String, Integer>> score_check = new ArrayList<>(member_score.entrySet());
        score_check.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> person1, Map.Entry<String, Integer> person2) {
                if(person1.getValue() == person2.getValue()) {
                    return person1.getKey().compareTo(person2.getKey());
                }
                return person2.getValue().compareTo(person1.getValue());
            }
        });
        int person = 0;
        for (Map.Entry<String, Integer> entry: score_check){
            if (person >= 5 || entry.getValue() <= 0){
                break;
            }
            answer.add(entry.getKey());
            person += 1;
        }


        return answer;
    }
}
