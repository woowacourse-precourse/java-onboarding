package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Set<String>> friend_list = new HashMap<String, Set<String>> (){
        @Override
        public Set<String> get(Object key){
            Set<String> set = super.get(key);
            if(set == null){
                set = new HashSet<String>();
                put((String) key,set);
            }
            return set;
        }
    };
    static Map<String, Integer> fscore = new HashMap<String, Integer>();

    public static Integer common_friends(String user, String key){
        int ret = 0;
        Set<String> users = friend_list.get(user);
        for(String ufriend : users){
            if(friend_list.get(key).contains(ufriend)) ret++;
        }
        return ret;
    }
    public static void cal_fscore(String user){
        Iterator iter = friend_list.keySet().iterator();
        while(iter.hasNext()){
            String k = iter.next().toString();
            if(k.equals(user)) continue;
            if(friend_list.get(user).contains(k)) continue;

            Integer score = fscore.get(k);
            if(score == null) fscore.put(k,10*common_friends(user,k));
            else fscore.put(k,score + 10*common_friends(user,k));
        }
    }

    public static void cal_visitor(String user, List<String> visitors){
        for(String v: visitors){
            if(friend_list.get(user).contains(v)) continue;
            Integer score = fscore.get(v);
            if(score == null) fscore.put(v,1);
            else fscore.put(v,1 + score);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        //make friend list
        for(List<String>f : friends) {
            String f1 = f.get(0); String f2 = f.get(1);
            friend_list.get(f1).add(f2);
            friend_list.get(f2).add(f1);
        }
        cal_fscore(user);
        cal_visitor(user, visitors);

        List<String> keyList = new ArrayList<>(fscore.keySet());
        Collections.sort(keyList, (o1,o2)->{
            int res = fscore.get(o2).compareTo(fscore.get(o1));
            if(res == 0) return o1.compareTo(o2);
            return res;
        });

        int turn = 0;
        for(String key : keyList){
            if(turn == 5) break;
            answer.add(turn,key);
            turn++;
        }
        return answer;
    }
}
