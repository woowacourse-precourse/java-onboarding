package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> my_friends;
        HashMap<String, Integer> recommended;

        // friends 내에 user의 친구를 찾는다.
        my_friends = find_user_friends(user, friends);

        // 사용자와 함께 아는 친구의 수 = 10점
        recommended = friend_of_my_friends(my_friends, friends, user);

        // 사용자의 타임 라인에 방문한 횟수 = 1점
        recommended.putAll(visited_friends(visitors, my_friends, recommended));

        // 점수가 가장 높은 순으로 정렬하여 최대 5명을 return. 단 0점은 추천하지 않음
        answer = get_top5(recommended);

        return answer;
    }

    // 점수가 가장 높은 순으로 정렬하여 최대 5명을 return. 단 0점은 추천하지 않음
    public static List<String> get_top5(HashMap<String, Integer> recommended){
        HashMap<String, Integer> top5_hash = new HashMap<>();
        List<String> top5_list = new ArrayList<>();

        for(Map.Entry<String, Integer> member:recommended.entrySet()){
            if (Is_top5(member, top5_hash)) {
                top5_hash.put(member.getKey(), member.getValue());
            }
            if(top5_hash.size()>5){
                top5_hash = Delete_minEntry(top5_hash);
            }
        }

        top5_list = sort_Heap(top5_hash);

        return top5_list;
    }

    // ID가 top5에 들어가도 되는지를 확인하는 메소드
    public static boolean Is_top5(Map.Entry<String, Integer> member, HashMap<String, Integer> top5_hash){
        if(top5_hash.size()<5){
            return true;
        }
        for(Integer top5_score: top5_hash.values()){
            if(member.getValue()<top5_score){
                return false;
            }
        }
        return true;
    }

    // top5_hash의 크기가 5개를 초과할 때 가장 작은 값을 제거
    public static HashMap<String, Integer> Delete_minEntry(HashMap<String, Integer> top5_hash){
        HashMap<String, Integer> result = new HashMap<>();
        while(result.size()<5){
            Map.Entry<String, Integer> max = maxEntry(top5_hash);
            result.put(max.getKey(), max.getValue());
            top5_hash.remove(max.getKey());
        }
        return result;
    }

    // Hashmap 내에 가장 큰 entry를 return
    public static Map.Entry<String, Integer> maxEntry(HashMap<String, Integer> top5_hash) {
        Map.Entry<String, Integer> max = null;
        for(Map.Entry<String, Integer> member: top5_hash.entrySet()){
            if(max == null){
                max = member;
                continue;
            }
            String member_key = member.getKey(), max_key = max.getKey();
            int member_value = member.getValue(),max_value = max.getValue();

            if(member_value>max_value){
                max = member;
            }

            if ((member_value == max_value) && member_key.compareTo(max_key)<0) {
                max = member;
            }
        }
        return max;
    }

    // 점수가 높은 5명을 담고있는 hash를 정렬하여 retrun
    public static List<String> sort_Heap(HashMap<String, Integer> top5_hash){
        System.out.println("top5_hash = " + top5_hash);
        List<String> result = new ArrayList<>();
        while(top5_hash.size()>0){
            Map.Entry<String, Integer> max = maxEntry(top5_hash);
            result.add(max.getKey());
            top5_hash.remove(max.getKey());
        }
        System.out.println("result = " + result);
        return result;
    }

    // friends 내에 user의 친구를 찾는다.
    public static List<String> find_user_friends(String user, List<List<String>> friends){
        List<String> my_friends = new ArrayList<>();

        for(List<String> Relation: friends){
            if(Relation.contains(user)){
                my_friends.add(find_friend_in_relation(user,Relation));
            }
        }

        return my_friends;
    }

    public static String find_friend_in_relation(String user, List<String> relation){
        String friend="";
        for(String name: relation){
            if(!name.equals(user)){
                friend = name;
            }
        }
        return friend;
    }

    public static HashMap<String, Integer> friend_of_my_friends(List<String> my_friends, List<List<String>> friends, String user){
        HashMap<String, Integer> friend_of_friend = new HashMap<>();
        List<String> new_friends=new ArrayList<>();
        for(String my_frnd:my_friends){
            new_friends = remove_duplicated_friend(new_friends, find_user_friends(my_frnd, friends), user);
        }


        for(String fof:new_friends){
            friend_of_friend.put(fof,10);
        }

        return friend_of_friend;
    }

    public static List<String> remove_duplicated_friend(List<String> old_friends, List<String> new_friends, String user){
        for(String new_friend:new_friends){
            if(!old_friends.contains(new_friend) && !new_friend.equals(user)){
                old_friends.add(new_friend);
            }
        }
        return old_friends;
    }

    // 사용자의 타임 라인에 방문한 횟수 = 1점
    public static HashMap<String, Integer> visited_friends(List<String> visitors, List<String> my_friends, HashMap<String, Integer> recommended){
        for(String visitor: visitors){
            if (!recommended.containsKey(visitor) && !my_friends.contains(visitor)) {
                recommended.put(visitor, 0);
            }
            if(!my_friends.contains(visitor)){
                recommended.put(visitor, recommended.get(visitor) + 1);
            }

        }

        return recommended;
    }
}


