package onboarding;

import onboarding.problem7.NotMatchingFriendSize;
import onboarding.problem7.NotMatchingFriendsSize;
import onboarding.problem7.NotMatchingUserLength;
import onboarding.problem7.NotMatchingVisitorsSize;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        int userLength = user.length();
        int friendsSize = friends.size();
        int visitorsSize = visitors.size();

        //1. 예외사항
        //1-1 user 길이 1 이상 30 이하인지 체크
        if(isNotMatchingUserLength(userLength)){
            throw new NotMatchingUserLength("사용자의 길이가 맞지 않습니다.");
        }

        //1-2 friends 길이 1 이상 10000 이하인지 체크
        if(isNotMatchingFriendsSize(friendsSize)){
            throw new NotMatchingFriendsSize("친구 관계 정보의 길이가 맞지 않습니다.");
        }

        //1-3 friends 의 각 원소의 길이가 2인지 체크
        int friendSize = friends.get(0).size();
        if(isNotMatchingFriendSize(friendSize)){
            throw new NotMatchingFriendSize("친구 관계 정보의 원소의 길이가 맞지 않습니다.");
        }

        //1-5 visitors 길이 0 이상 10000 이하인지 체크
        if(isNotMatchingVisitorsSize(visitorsSize)){
            throw new NotMatchingVisitorsSize("방문 기록의 길이가 맞지 않습니다.");
        }
        //- 사용자 아이디 소문자인지 체크


        return answer;
    }

    private static boolean isNotMatchingVisitorsSize(int size) {
        return size < 0 || size > 10000;
    }

    //1-4 아이디 길이 1 이상 30 이하인지 체크
    private static boolean isNotMatchingId(int length) {
        return length < 1 || length > 30;
    }

    private static boolean isNotMatchingFriendSize(int size) {
        return size != 2;
    }

    private static boolean isNotMatchingFriendsSize(int size) {
        return size < 1 || size > 10000;
    }

    private static boolean isNotMatchingUserLength(int length) {
        return length < 1 || length > 30;
    }
}
