package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        valid(user, friends, visitors);
        List<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> friend_link = new HashMap<String, ArrayList<String>>();  //친구들의 관계를 나타내는 맵
        Map<String, Integer> friend_sco = new HashMap<>();  //나에게 보여줄 친구 추천 맵

        for(int i = 0; i < friends.size(); i++){
            List<String> list = friends.get(i);
            String friend1 = list.get(0);
            String friend2 = list.get(1);

            ArrayList<String> arlist = friend_link.getOrDefault(friend1, new ArrayList<String>());
//            if(arlist.contains(friend2)){
//                throw new Exception("동일한 친구 관계가 중복해서 주어졌습니다.");
//            }
            arlist.add(friend2);
            friend_link.put(friend1, arlist);

            ArrayList<String> arlist2 = friend_link.getOrDefault(friend2, new ArrayList<String>());
            arlist2.add(friend1);
            friend_link.put(friend2, arlist2);
        }

        ArrayList<String> friend_list = friend_link.get(user);
        for(int i = 0; i < friend_list.size(); i++){        //관련있는 친구일 때 10점씩
            String friend = friend_list.get(i);
            ArrayList<String> friend_friends = friend_link.get(friend);
            for(int j = 0; j < friend_friends.size(); j++){
                String f = friend_friends.get(j);
                if(!f.equals(user)){    //사용자의 친구이면 안된다.
                    friend_sco.put(f, friend_sco.getOrDefault(f, 0)+10);
                }
            }
        }

        for(int i = 0; i < visitors.size(); i++){   //방문할때마다 1점씩
            String s = visitors.get(i);
            if(!friend_list.contains(s))    //나의 친구가 아니여야 한다.
                friend_sco.put(s, friend_sco.getOrDefault(s, 0)+1);
        }

        //1순위 점수로 정렬, 2순위 이름으로 정렬

        List<Map.Entry<String, Integer>> sort_sc = new LinkedList<>(friend_sco.entrySet());
        Collections.sort(sort_sc, new Comparator<Object>() {
            @Override
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                Map.Entry<String, Integer> a = (Map.Entry<String, Integer>)o1;
                Map.Entry<String, Integer> b = (Map.Entry<String, Integer>)o2;
                if(a.getValue() != b.getValue()){
                    return b.getValue() - a.getValue();
                }else{
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });
        for(int i = 0; i < Math.min(5, sort_sc.size()); i++){
            answer.add(sort_sc.get(i).getKey());
        }
//        if(answer.isEmpty()){
//            throw new Exception("추천할 친구가 존재하지 않습니다.");
//        }

        return answer;
    }

    public static void valid(String user, List<List<String>> friends, List<String> visitor) throws Exception { //입력조건 확인
    if(user.length() < 1 || user.length() > 30){
        throw new Exception("user의 이름의 길이가 조건에 맞지 않습니다 length: "+ user.length());
    }
    if(friends.size() < 1 || friends.size() > 10000){
        throw new Exception("입력된 친구의 수가 조건에 맞지 않습니다 friends size : "+friends.size());
    }
    for(int i = 0; i < friends.size(); i++){
        if(friends.get(i).size() != 2){
            throw new Exception("입력된 친구 관계가 1:1이 아닙니다.");
        }
        String member1 = friends.get(i).get(0);
        String member2 = friends.get(i).get(1);
        if(member1.length() < 1 || member1.length() >30 || member2.length() < 1 || member2.length() >30){
            throw new Exception(String.format("친구의 아이디 길이가 조건에 맞지 않습니다. %s : %d, %s : %d", member1,member1.length(), member2, member2.length()));
        }
    }
    if(visitor.size()>10000){
        throw new Exception("방문자의 수가 조건에 맞지 않습니다. visitor size: "+ visitor.size());
    }
    for(int i = 0; i < user.length(); i++){
        if(Character.isUpperCase(user.charAt(i)))
            throw new Exception("사용자의 아이디에 대문자가 포함되어 있습니다. user: "+ user);
    }
    }
}
