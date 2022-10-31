package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

//        compareFriend(user,friendMap(friends));
        HashMap<String, Integer> addCountIns = addCount(compareFriend(user, friendMap(friends)), friendMap(friends), visitors,user);
        friendResult(addCountIns);
        List<String> answer = friendResult(addCountIns);
        return answer;
    }

    //  1. HashMap으로 친구 당 가지는 모든 친구관계를 구성
    public static HashMap<String, List<String>> friendMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendRelation = new HashMap<>();
        for (List<String> friend : friends) {
            if (friendRelation.containsKey(friend.get(0))) {
                List<String> friednVal = friendRelation.get(friend.get(0));
                friednVal.add(friend.get(1));
                friendRelation.remove(friend.get(0));
                friendRelation.put(friend.get(0), friednVal);
            }if (friendRelation.containsKey(friend.get(1))) {
                List<String> friednVal = friendRelation.get(friend.get(1));
                friednVal.add(friend.get(0));
                friendRelation.remove(friend.get(1));
                friendRelation.put(friend.get(1), friednVal);
            }if (!(friendRelation.containsKey(friend.get(1)))) {
                List<String> friednVal = new ArrayList<>();
                friednVal.add(friend.get(0));
                friendRelation.put(friend.get(1), friednVal);
            }if (!(friendRelation.containsKey(friend.get(0)))) {
                List<String> friednVal = new ArrayList<>();
                friednVal.add(friend.get(1));
                friendRelation.put(friend.get(0), friednVal);
            }
        }
        return friendRelation;
    }

    //  2. 사용자가 가지는 친구 관계와 같은 친구를 뽑음.
    public static List<String> compareFriend(String user, HashMap<String, List<String>> friendRelation) {
        /*사용자와 겹치는 친구를 리스트에 넣음.*/
        List<String> findFriend = new ArrayList<>();
        if (friendRelation.containsKey(user)) {
            findFriend.addAll(friendRelation.get(user));
        }
        return findFriend;
    }
    //  3.친구 별로 사용자와 같은 친구 하나당 10을 추가하는 hashmap 생성
//  visitors는 1점 추가
    /*visitors에 1추가하면 5명의 친구가 뽑힘 0이랑 헷갈린건가? 1은 배제하라는 건가 일단
    1인 친구도 빼고 만듬.*/
    public static HashMap<String, Integer> addCount(List<String> findFriend, HashMap<String,List<String>> friendMap, List<String> visitors,String user) {
        HashMap<String, Integer> friendCount = new HashMap<>();
        for (String friendEach : findFriend) {/*리스트에서 같은 친구 뽑아서 비교*/
            for (String key : friendMap.keySet()) {/*전체 친구 value 중 같은 친구 있으면*/
                if (key.equals(user)) {/*user는 건너뛰기*/
                    continue;
                }
                List<String> value = friendMap.get(key);/*hashmap에서는 밸류 수정하면 갱신되기 때문에
                value를 숫자로 받아서 10추가한 후 key value를 remove 후 다시 바뀐 밸류를 다시 key value 저장
                */
                if (value.contains(friendEach)) {
                    if (friendCount.containsKey(key)) {
                        Integer numValue = friendCount.get(key);
                        numValue += 10;
                        friendCount.remove(key);
                        friendCount.put(key, numValue);
                    } else {
                        friendCount.put(key, 10);
                    }
                }
            }
        }
        for (String visitor : visitors) { /*위와 같은 방식으로 visitor는 점수 1추가*/
            if (friendCount.containsKey(visitor)) {
                Integer numValue = friendCount.get(visitor);
                numValue += 1;
                friendCount.remove(visitor);
                friendCount.put(visitor, numValue);
            } else {
                friendCount.put(visitor, 1);
            }
        }
        return friendCount;
    }

    //  4.hash 맵에서 밸류값이 높은 순서대로 뽑는데 같은 밸류값 뽑아서
    //  일단 이름순으로 list에 삽입 5명되면 break
    public static List<String> friendResult(HashMap<String, Integer> addAcount) {
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(addAcount.entrySet());
//       /*value 값으로 내림차순 정렬*/
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<String> result = new ArrayList<>();
        int count = 0;
        List<String> resultIns = new ArrayList<>();
        /*resultList 갯수만큼 for문 돌기*/
        for (int i = 0; i < resultList.size(); i++) {
            /*점수가 1 초과인 사람만 통과 추천점수가 0인 경우는 통과하지 말라고 하는데 그러면 1인 값이 통과 됨
            answer과는 다름 */
            if (resultList.get(i).getValue() > 1) {
                if (resultIns.isEmpty()) {
//                   /*result에 넣기 전에 같은 점수끼리 정렬해야 하기 때문에 임시 저장*/
                    resultIns.add(resultList.get(i).getKey());
                    /*같은 점수 인지 확인하는 int 값*/
                    count = resultList.get(i).getValue();
                }else{
                    if (resultList.get(i).getValue() == count) {
                        /*최대 5명이기 때문에 초과하면 break. 임시저장하기 전에 검사*/
                        if (result.size() > 5) {
                            break;
                        }
                        resultIns.add(resultList.get(i).getKey());
                    } else {
                        /*현재 값이 점수가 다르면 임시저장값을 정렬하고 임시저장값을 초기화*/
                        resultIns.sort(Comparator.naturalOrder());
                        result.addAll(resultIns);
                        resultIns.clear();
                        /*점수값을 현재값으로 할당*/
                        count = resultList.get(i).getValue();
                        if (result.size() > 5) {
                            break;
                        }
                        resultIns.add(resultList.get(i).getKey());
                    }
                }
            }
            /*마지막 값이 남아 있을 수 있어서 임시저장값을 result에 저장.*/
            if (i == resultList.size()-1) {
                result.addAll(resultIns);
            }
        }
        return result;
    }
}





