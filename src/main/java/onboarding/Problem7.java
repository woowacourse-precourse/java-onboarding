package onboarding;

import onboarding.problem7.*;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        int userLength = user.length();
        int friendsSize = friends.size();
        int visitorsSize = visitors.size();


        //1. 예외사항
        checkException(friends, userLength, friendsSize, visitorsSize);

        //2. 유저 친구 관계 표현하기
        Map<String, Integer> userFriendInfo = new HashMap<>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if(isUserFriendName(user, friendA)){
                userFriendInfo.put(friendB,1);
            }
            if(isUserFriendName(user, friendB)){
                userFriendInfo.put(friendA,1);
            }
        }

        Map<String, Integer> recommendScore = new HashMap<>();
        //3. 유저와 함께 아는 친구 확인하고 점수 매기기
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if(isUser(user, friendA, friendB)) continue;

            if(isMapContain(userFriendInfo, friendA)){
                if(!isMapContain(userFriendInfo, friendB)){ // 친구A 가 유저와 함께 아는 친구일 경우
                    if(isMapContain(recommendScore, friendB)){ // 추천점수목록에 존재할 때와 존재하지 않을 때 구분해서 점수 등록
                        recommendScore.put(friendB,recommendScore.get(friendB)+10);
                    }else{
                        recommendScore.put(friendB, 10);
                    }
                }
            }

            if(isMapContain(userFriendInfo, friendB)){
                if(!isMapContain(userFriendInfo, friendA)){ // 친구B 가 유저와 함께 아는 친구일 경우
                    if(isMapContain(recommendScore, friendA)){ // 추천점수목록에 존재할 때와 존재하지 않을 때 구분해서 점수 등록
                        recommendScore.put(friendA,recommendScore.get(friendA)+10);
                    }else{
                        recommendScore.put(friendA, 10);
                    }
                }
            }
        }

        //4. 유저의 타임라인에 방문한 횟수를 토대로 점수 매기기
        for (String visitor : visitors) {
            if(!isMapContain(userFriendInfo, visitor)) { // 유저의 친구가 아니여야 함
                if (isMapContain(recommendScore, visitor)) { // 추천점수목록에 존재할 때와 존재하지 않을 때 구분해서 점수 등록
                    recommendScore.put(visitor, recommendScore.get(visitor) + 1);
                } else {
                    recommendScore.put(visitor, 1);
                }
            }
        }

        // 5. 추천 점수 목록을 List 로 변환
        ArrayList<ScoreInfo> arrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> recommendScoreMap : recommendScore.entrySet()) {
            arrayList.add(new ScoreInfo(recommendScoreMap.getKey(),recommendScoreMap.getValue()));
        }

        // 6. 친구 추천 규칙에 따라 점수가 가장 높은 순대로 정렬 후 최대 5명의 user 를 뽑음
        answer = arrayList.stream().sorted().map(scoreInfo -> scoreInfo.getId()).limit(5).collect(Collectors.toList());

        return answer;
    }

    private static void checkException(List<List<String>> friends, int userLength, int friendsSize, int visitorsSize) {
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
    }

    private static boolean isUser(String user, String friendA, String friendB) {
        return friendA == user || friendB == user;
    }

    private static boolean isMapContain(Map<String, Integer> userFriendInfo, String friendA) {
        return userFriendInfo.containsKey(friendA);
    }

    private static boolean isUserFriendName(String user, String friendA) {
        return user.equals(friendA);
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

    // 1-4,6 한번에 처리
    public static boolean isNotId(String id){
        boolean found = true;

        if(StringUtils.isBlank(id)){
            found = true;
        }

        String regex = "^[a-z]{1,30}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(id);
        if(matcher.matches()){
            found = false;
        }
        return found;
    }
}
