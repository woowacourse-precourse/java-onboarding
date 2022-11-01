package onboarding;

import java.util.*;

public class Problem7 {

    //모든 {사용자=[사용자의 친구들]} Map
    private static Map<String, List<String>> friendsOfPerson = new HashMap<>();
    //본인과 이미 친구인 사람 목록 List
    private static List<String> alreadyFriends = new ArrayList<>();

    private static Map<String, Integer> strangerScoreMap = new HashMap<>();

    private final static int FRIENDS_POINT = 10;
    private final static int VISIT_POINT = 1;


    //{사용자=[사용자의 친구들]} friends 목록과 대조해 만들기
    private static Map<String, List<String>> mapFriendsOfPerson(List<List<String>> friends, String person) {
        List<String> friendsList = new ArrayList<>();

        for(List<String> friend : friends){
            if (friend.indexOf(person) == 0) {
                friendsList.add(friend.get(1));
            } else if (friend.indexOf(person) == 1) {
                friendsList.add(friend.get(0));
            }else{
                continue;
            }
        }
        friendsOfPerson.put(person, friendsList);
        return friendsOfPerson;
    }

    //목록에서 이미 친구인 사람 제거
    private static List<String> removeAlreadyFriend(List<String> includeAlreadyFriends) {
        List<String> strangers = new ArrayList<>();
        strangers.addAll(includeAlreadyFriends);
        strangers.removeAll(alreadyFriends);
        return strangers;
    }

    //점수 계산
    private static void calculateScore(List<String> nameList, int point) {
        int score = 0;

        for (String name : nameList) {
            if (strangerScoreMap.containsKey(name)) {
                score = strangerScoreMap.get(name);
            } else {
                score=0;
            }
            score += point;
            strangerScoreMap.put(name, score);
        }
    }

    // value(점수)기준 내림차순 key(이름) list
    private static List<String> sortScore(){
        List<String> namesSortedByScore = new ArrayList<>();
        List<String> keySet = new ArrayList<>(strangerScoreMap.keySet());

        keySet.sort((o1, o2) -> strangerScoreMap.get(o2) - strangerScoreMap.get(o1));
        for (String key : keySet) {
            namesSortedByScore.add(key);
        }
        return namesSortedByScore;
    }

    //같은 점수일 때, 이름 순으로 정렬
    private static List<String> sortSameScore(List<String> namesSortedByScore) {
        List<String> sameScores = new ArrayList<>();
        List<String> sortedNames = new ArrayList<>();
        String before = "";

        for (String name : namesSortedByScore) {
            if (strangerScoreMap.get(name) == strangerScoreMap.get(before)) {
                sameScores.add(name);
            } else {
                sameScores.sort(Comparator.naturalOrder());
                sortedNames.addAll(sameScores);
                sameScores.clear();
                sameScores.add(name);
            }
            before = name;
        }
        sameScores.sort(Comparator.naturalOrder());
        sortedNames.addAll(sameScores);

        return sortedNames;
    }

    //최대 5명, 0점 x
    private static List<String> changeToStandard(List<String> sortedNames) {
        List<String> answer = new ArrayList<>();

        int count = 0;
        for (String name : sortedNames) {
            if (count == 5 || strangerScoreMap.get(name) == 0) {
                break;
            }
            answer.add(name);
            count++;
        }
        return answer;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        //점수 계산에 사용할 함께아는 친구, 방문자 List
        List<String> knowMyFriendNameList = new ArrayList<>();
        List<String> visitorNameList = new ArrayList<>();

        //결과에 포함되지않는 user, user 친구 list {user=[user 친구들]}
        alreadyFriends.add(user);
        alreadyFriends.addAll(mapFriendsOfPerson(friends, user).get(user));

        //결과에 포함되지 않는 사용자들(alreadyFriends)을 friendsOfPerson Map 에 추가 {alreadyFriend =[alreadyFriend 의 친구들]}
        for (String alreadyFriend : alreadyFriends) {
            mapFriendsOfPerson(friends, alreadyFriend);
        }

        //alreadyFriends의 친구들을 합쳐 함께아는 친구 목록
        for (List<String> friendName : friendsOfPerson.values()) {
            knowMyFriendNameList.addAll(friendName);
        }

        //방문 기록과 함께아는 친구 목록에서 결과에서 제외되는 대상 삭제
        knowMyFriendNameList.removeAll(alreadyFriends);
        visitorNameList.addAll(removeAlreadyFriend(visitors));

        //점수 계산해서 strangerScoreMap 매핑
        calculateScore(knowMyFriendNameList, FRIENDS_POINT );
        calculateScore(visitorNameList, VISIT_POINT);

        //규격에 맞게 정렬해 답안 작성
        answer.addAll(changeToStandard(sortSameScore(sortScore())));

        return answer;
    }
}
