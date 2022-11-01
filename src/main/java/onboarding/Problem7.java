package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem7 {
    public static class FriendInfo implements Comparable<FriendInfo> {
        String name;
        int point;

        FriendInfo(String n, int p) {
            name = n;
            point = p;
        }

        // 추천 점수 추가
        void plusPoint(int plus) {
            point += plus;
        }

        // 정렬 기준 설정
        @Override
        public int compareTo(FriendInfo infor) {
            if (infor.point > point) {
                return 1;
            } else if (infor.point < point) {
                return -1;
            } else {
                return name.compareTo(infor.name);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        // 이미 친구인 사람들의 이름을 모아놓은 리스트
        List<String> friendsList = new ArrayList<String>();

        // 코드의 간결성을 위해 친구가 아닌 사람들의 이름만 모아놓은 리스트를 따로 만들었다.
        List<String> notFriendsList = new ArrayList<String>();

        // 친구가 아닌 사람들의 이름과 추천 점수에 대한 정보를 담은 리스트
        List<FriendInfo> notFriendsInfo = new ArrayList<FriendInfo>();

        // friends
        for (int i = 0; i < friends.size(); ++i) {
            String friend = friends.get(i).get(0);
            String notFriend = friends.get(i).get(1);

            // 친구 목록에 존재하지 않는 이름이라면 추가
            if (!friendsList.contains(friend)) {
                friendsList.add(friend);
            }

            // 이름이 user와 동일할 경우 패스
            if (notFriend != user) {
                // 친구가 아닌 사람들의 목록에 존재하지 않는 이름이라면 정보 추가
                if (!notFriendsList.contains(notFriend)) {
                    notFriendsList.add(notFriend);

                    // 친구의 친구이므로 10점
                    FriendInfo newNotFriend = new FriendInfo(notFriend, 10);
                    notFriendsInfo.add(newNotFriend);
                } else {// 목록에 존재한다면 정보 갱신
                    int index = notFriendsList.indexOf(notFriend);
                    notFriendsInfo.get(index).point += 10;
                }
            }
        }

        // visiotrs
        for (int i = 0; i < visitors.size(); ++i) {
            String visitor = visitors.get(i);

            if (!friendsList.contains(visitor)) {
                // 친구가 아닌 사람들의 목록에 존재하지 않는 이름이라면 정보 추가
                if (!notFriendsList.contains(visitor)) {
                    notFriendsList.add(visitor);

                    // 방문자이므로 10점
                    FriendInfo newNotFriend = new FriendInfo(visitor, 1);
                    notFriendsInfo.add(newNotFriend);
                } else {// 목록에 존재한다면 정보 갱신
                    int index = notFriendsList.indexOf(visitor);
                    notFriendsInfo.get(index).point += 1;
                }
            }
        }

        Collections.sort(notFriendsInfo);

        for (int i = 0; i < 5 && i < notFriendsInfo.size(); ++i) {
            if (notFriendsInfo.get(i).point != 0) {
                answer.add(notFriendsInfo.get(i).name);
            }
        }

        return answer;
    }
}
