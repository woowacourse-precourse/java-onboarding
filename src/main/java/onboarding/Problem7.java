package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new LinkedList<>();

        /*
            가장먼저 생각난 방법.
            1. List를 순회하면서 user와 함께 있는 원소를 기억
            2. 기억한 원소와 같은 리스트의 원소의 갯수를 셈
            3. visitor 는 +1로 쳐서 점수순으로 출력.
        */

        List<String> userFriend = new LinkedList<>();

        for(int i = 0;i<friends.size();i++){
            if(friends.get(i).get(0).equals(user)){
                userFriend.add(friends.get(i).get(1));
            }else if (friends.get(i).get(1).equals(user)){
                userFriend.add(friends.get(i).get(0));
            }
        }

        HashMap<String,Integer> valueMap = new HashMap<>();

        for (int i = 0;i<userFriend.size();i++){
            for(int j = 0;j<friends.size();j++){

                if(friends.get(j).get(0).equals(userFriend.get(i))){

                    if(!valueMap.containsKey(friends.get(j).get(1))){
                        valueMap.put(friends.get(j).get(1),10);
                    }else{
                        valueMap.put(friends.get(j).get(1),(valueMap.get(friends.get(j).get(1))+10));
                    }

                }else if (friends.get(j).get(1).equals(userFriend.get(i))){

                    if(!valueMap.containsKey(friends.get(j).get(0))){
                        valueMap.put(friends.get(j).get(0),10);
                    }else{
                        valueMap.put(friends.get(j).get(0),(valueMap.get(friends.get(j).get(0))+10));
                    }

                }
            }
        }
        valueMap.remove(user);

        for(int i = 0;i<visitors.size();i++){
            if(!valueMap.containsKey(visitors.get(i))){
                valueMap.put(visitors.get(i),1);
            }else{
                valueMap.put(visitors.get(i),(valueMap.get(visitors.get(i))+1));
            }
        }

        for(int i = 0;i<userFriend.size();i++){
            valueMap.remove(userFriend.get(i));
        }

        List<String> nameList = new ArrayList<>(valueMap.keySet());

        Collections.sort(nameList, (o1, o2) -> (valueMap.get(o2).compareTo(valueMap.get(o1))));

        int cnt = 0;
        for(String key : nameList) {
            answer.add(key);
            cnt++;
            if(cnt ==5)
                break;
        }


        return answer;
    }


}
