package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new LinkedList<>();

        HashMap<String,String> map=new HashMap<>();//모든 친구관계 목록.
        Set<String> set=new HashSet<>();//직접 친구 목록.

        Iterator<List<String>> it= friends.iterator();
        while (it.hasNext()) {
            List<String> list=it.next();
            map.put(list.get(1), list.get(0));
            if(map.containsKey(user)){
                set.add(map.get(user));
                //직접친구 목록 추출해서 set에 저장.
            }
        }

        HashSet<Friend> resultset=new HashSet<>();//함계아는 친구의 목록+추천점수 까지 포함된 리스트
        HashSet<String> resultnameset=new HashSet<>();//함께아는 친구의 목록(중복제거)

        List<String> arr=new ArrayList<>();
        Iterator<List<String>> it2= friends.iterator();
        while (it2.hasNext()) {
            List<String> list=it2.next();
            String name= list.get(0);
            String friend= list.get(1);
            if(set.contains(name)&&!friend.equals(user)){
                //직접친구의 친구이고, user만 뺀 나머지를 모두 list에 추가.
                arr.add(friend);
                resultnameset.add(friend);
                // resultset.add(new Friend(friend));

            }
        }
        List<String> rr=new ArrayList<>(resultnameset);
        List<Friend> countarr=new ArrayList<>();
        for (int i = 0; i < rr.size(); i++) {
            countarr.add(new Friend(rr.get(i)));
        }

        for (int i = 0; i < arr.size(); i++) {
            String name=arr.get(i);//직접 친구의 친구(함께아는친구의 수)를 count
            for (int j = 0; j < countarr.size(); j++) {
                Friend cnt=countarr.get(j);
                if(cnt.name==name){
                    cnt.count+=10;
                }

            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String name= visitors.get(i);
            if(resultnameset.contains(name)){
                for (int j = 0; j < countarr.size(); j++) {
                    if(name==countarr.get(j).name){
                        countarr.get(j).count++;
                    }
                }
            }
            else{
                if(!set.contains(name)) {// 직접친구가 방문했을때는 넣지 않도록 필터링.
                    resultnameset.add(name);
                    countarr.add(new Friend(name, 1));
                }
            }

        }// visitor 한 횟수만큼 +1 해줌.

        countarr.sort(new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                int judge= o2.count-o1.count;
                if(judge==0){
                    return o1.name.compareTo(o2.name);
                }
                else{
                    return judge;
                }
            }
        });

        for (int i = 0; i < countarr.size(); i++) {
            Friend f=countarr.get(i);
            if(f.count!=0){
                answer.add(f.name);
            }
        }
        return answer;
    }
    static class Friend implements Comparator<Friend> {

        Friend(String name) {
            this.name = name;
        }
        Friend(String name, int count){
            this.name=name;
            this.count=count;
        }

        int count = 0;
        String name;

        @Override
        public int compare(Friend o1, Friend o2) {
            int result;
            result=o1.name.compareTo(o2.name);
            return result;
        }
    }
}
