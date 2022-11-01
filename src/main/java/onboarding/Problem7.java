package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // user의 친구목록 얻음
        List<String> userFriends = getUserFriends(user, friends);
//        System.out.println("userFriends = " + userFriends);

        List<String> tmp;

        // userFriend의 친구 목록을 추천 점수와 기록
        List<FriendCount> friendRecommendList = new ArrayList<>();

        for (List<String> friend : friends) {
            for (String userFriend : userFriends) {
                boolean findFlag = false;
                for (int i = 0; i < friend.size(); i++) {

                    if(findFlag) // 같은 행에서 찾았다면,
                        break;

                    if (friend.get(i).equals(userFriend)) { // userFriend와 friend 일치
                        findFlag = true;

                        // 1. user인지 확인
                        if(isUser(friend.get(1-i), user))
                            continue;

                        // 2. user친구 목록에 있는 사람인지 확인
                        if(isExistFriend(friend.get(1-i), userFriends))
                            continue;
                        // 만약 1,2에 해당한다면 아무런 동작을 하지 않고 넘어간다.

                        FriendCount friendCount = findFromRecommendList(friend.get(1 - i), friendRecommendList);
                        if (friendCount == null) {
                            // 3. user친구의친구 목록에 있는 사람이 아니라면 새로 리스트에 추가한다.
                            friendRecommendList.add(new FriendCount(friend.get(1 - i), 10));
                        } else {
                            // 4. user친구의친구 목록에 있는 사람이라면 해당 친구의친구에 10을 더한다
                            friendCount.count += 10;
                        }
                    }
                }
            }
        }
//        System.out.println("friendRecommendList = " + friendRecommendList);

        // 방문자 점수 계산
        // 방문자 리스트 돌기

        for (String visitor : visitors) {
            FriendCount friendCount = findFromRecommendList(visitor, friendRecommendList);

            // 방문자가 본인이거나, 친구가 아닐경우,
            if (isUser(visitor, user))
                continue;
            if(isExistFriend(visitor, userFriends))
                continue;

            if (friendCount == null) {
                // 방문자 이름이 RecommandList에 없다면 생성 & count+1
                friendRecommendList.add(new FriendCount(visitor, 1));
            } else {
                // 방문자 이름이 RecommendList에 있다면 count+1
                friendCount.count++;
            }
        }

//        System.out.println("friendRecommendList = " + friendRecommendList);


        // userFriendFriends에서 count 내림차순으로 정렬
        // 내림차순 정렬한 것에서 이름순으로 정렬하기
        friendRecommendList.sort(
                (a, b) -> {
                    if(a.count > b.count) {
                        return -1;
                    } else if (a.count < b.count) {
                        return 1;
                    } else {
                        return a.name.compareTo(b.name);
                    }
                }
        );

        List<String> output = new ArrayList<>();
        int size = 0;

        if(friendRecommendList.size() > 5)
            size = 5;
        else
            size = friendRecommendList.size();

        for (int i = 0; i < size; i++) {
            output.add(friendRecommendList.get(i).name);
        }

        return output;
    }


    // 추천 친구 목록에서 인자로 넘겨준 String의 FriendCount 인스턴스 넘겨줌. 없으면 null
    private static FriendCount findFromRecommendList(String friendFriendName, List<FriendCount> friendRecommendList) {
        for (FriendCount friendCount : friendRecommendList) {
            if (friendFriendName.equals(friendCount.name)) {
                return friendCount;
            }
        }
        return null;
    }

    // user의 친구 목록에 String으로 넘겨준 값의 존재 여부 확인
    private static boolean isExistFriend(String friendFriendName, List<String> userFriends) {
        for (String userFriend : userFriends) {
            if(friendFriendName.equals(userFriend))
                return true;
        }
        return false;
    }

    // user의 이름과 String으로 넘겨준 값이 일치하는지 확인
    private static boolean isUser(String friendFriendName, String user) {
        return friendFriendName.equals(user);
    }


    // user와 친구인 사람들의 이름 List반환
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        List<String> tmp;

        for (int i = 0; i < friends.size(); i++) {
            tmp = friends.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (tmp.get(j).equals(user)) {
                    userFriends.add(tmp.get(1 - j));
                }
            }
        }
        return userFriends;
    }

    // 추천 친구와 점수를 기록하기 위한 클래스
    private static class FriendCount {
        String name;
        int count;

        FriendCount(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}