package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> visitors_a = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        List<String> friends_friends = new ArrayList<>();
        for (int i = 0; i < visitors.size(); i++) {
            visitors_a.add(visitors.get(i));
        }
        TreeMap<String, Integer> tree = new TreeMap<>();
        Collections.sort(visitors_a);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j).equals(user)) {
                    user_friends.add(friends.get(i).get(1 - j));
                }
            }
        }
        for (int i = 0; i < user_friends.size(); i++) {
            for (int s = 0; s < friends.size(); s++) {
                for (int j = 0; j < 2; j++) {
                    if (user_friends.get(i).equals(friends.get(s).get(j))) {
                        if (!friends.get(s).get(1 - j).equals(user)) {
                            friends_friends.add(friends.get(s).get(1 - j));
                        }
                    }
                }
            }
        }
        int cnt = 1;
        Collections.sort(friends_friends);
        for (int i = 0; i < friends_friends.size(); i++) {
            if (i + 1 < friends_friends.size() && friends_friends.get(i).equals(friends_friends.get(i + 1)))
                cnt++;
            else {
                if (cnt > 1)
                    tree.put(friends_friends.get(i), cnt * 10);
                cnt = 1;
            }
        }
        cnt = 1;
        int qwer = 0;
        for (int i = 0; i < visitors.size(); i++) {
            if (user_friends.contains(visitors_a.get(i))) {
                qwer++;
            }
            if (qwer == 0) {
                if (i + 1 < visitors_a.size() && visitors_a.get(i).equals(visitors_a.get(i + 1))) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        tree.put(visitors_a.get(i), cnt);
                    } else {
                        tree.put(visitors_a.get(i), cnt);
                    }
                    cnt = 1;
                }
            }
            qwer = 0;
        }
        resultArr[] re=new resultArr[tree.size()];
        int po=0;
        for (String i : tree.keySet()) {
            re[po]=new resultArr(i,tree.get(i));
            po++;
        }
        Arrays.sort(re);
        cnt=0;
        for(int i=0;i<tree.size();i++){
            if(i>5)
                break;
            if(i+1<tree.size()&&re[i].num==re[i+1].num){
                cnt++;
            }
            if(cnt+i>5)
                break;
            else{
                answer.add(re[i].name);
            }
            cnt=0;
        }
        return answer;
    }
    static class resultArr implements Comparable<resultArr>{
        String name;
        int num;
        public resultArr(String name,int num){
            this.name=name;
            this.num=num;
        }
        public int compareTo(resultArr other){
            if(other.num==this.num){
                return this.name.compareTo(other.name);
            }
            return Integer.compare(other.num,this.num);
        }
    }
}