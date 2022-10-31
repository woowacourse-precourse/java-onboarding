package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 전체 유저 찾기
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(user);
        for(int i=0; i< friends.size(); i++){
            for(int j=0; j<user.length(); j++){
                if(! friends.get(i).get(0).equals(arrayList.get(j))){
                    arrayList.add(friends.get(i).get(0));
                }
                if(! friends.get(i).get(1).equals(arrayList.get(j))){
                    arrayList.add(friends.get(i).get(1));
                }
            }
        }
        // 중복 제거
        ArrayList<String> users = new ArrayList<>();
        for(String us : arrayList){
            if(!users.contains(us))
                users.add(us);
        }

        ArrayList<String>[] grpah = new ArrayList[users.size()];
        for(int i=0; i< users.size(); i++){
            grpah[i] = new ArrayList<>();
        }
        for(int i=0; i<users.size(); i++){
            grpah[i].add(users.get(i));
        }

        // 그래프에 친구 넣기
        for(int i=0; i<friends.size(); i++){
            int indexA = 0;
            int indexB = 0;

            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);

            for(int j=0; j<users.size(); j++){
                if(a.equals(grpah[j].get(0))){
                    indexA = j;
                }
                if(b.equals(grpah[j].get(0))){
                    indexB = j;
                }
            }
            grpah[indexA].add(b);
            grpah[indexB].add(a);
        }

        // vistor에 새로운 친구가 있을 시 값 추가
        for(String us : visitors){
            if(!users.contains(us))
                users.add(us);
        }

        // 추천 점수 추가
        int[] result = new int[users.size()];

        // user의 친구의 친구 점수 추가
        for(int i=1; i<grpah[0].size(); i++){
            String fr = grpah[0].get(i);  // 마르코 친구
            // 마르코 친구 10점 추가
            int index = 0;
            for(int j=0; j< users.size(); j++){
                if(users.get(j).equals(fr)) index = j;
            }
            result[index] += 10;

            // 그 친구의 친구 10점 추가
            for(int j=1; j<grpah[index].size(); j++){
                String find = grpah[index].get(j);
                int otherIndex = 0;

                for(int k=0; k< users.size(); k++){
                    if(users.get(k).equals(find)) otherIndex = k;
                }
                result[otherIndex] += 10;
            }
        }

        // visitor 점수 추가
        for(int i=0; i< visitors.size(); i++){
            String vistor = visitors.get(i);
            int index = 0;
            for(int j=0; j< users.size(); j++){
                if(users.get(j).equals(vistor)) index = j;
            }
            result[index] += 1;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<users.size(); i++){
            if(result[i] != 0){
                map.put(users.get(i), result[i]);
            }
        }

        // map에 users 친구 제거
        for(int i=0; i<grpah[0].size(); i++){
            String a = grpah[0].get(i);
            map.remove(a);
        }

        // 맵 정렬
//        for(int i=0; i< map.size(); i++){
//
//        }
        List<String> answer = new ArrayList<>();

        for(String key : map.keySet()){
            answer.add(key);
        }
        return answer;
    }
}
