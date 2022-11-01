package onboarding;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    //  Static-Variable
    private static final int POINT_FRIEND = 10;
    private static final int POINT_VISIT = 1;
    private static final int MIN_ID_LENGTH = 1;
    private static final int MAX_ID_LENGTH = 30;
    private static final int MAX_LIST_LENGTH = 10000;
    private static final Map<String, Integer> recommend = new LinkedHashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //  회원 유효성 검사
    private static void verifyUser(String user){
        //  verify user length : 길이가 1이상 30이하 문자열
        if(!verifyIdLength(user)) throw new RuntimeException("INVALID_ID_LENGTH");
        //  verify user id type : 알파벳 소문자로만 구성
        if(!verifyIdType(user)) throw new RuntimeException("INVALID_ID_TYPE");
    }

    //  회원 유효성 검사 - 길이
    private static Boolean verifyIdLength(String id){
        int length = id.length();
        if(length < MIN_ID_LENGTH) return false;
        if(length > MAX_ID_LENGTH) return false;
        return true;
    }

    //  회원 유효성 검사 - 소문자
    private static Boolean verifyIdType(String id){
        for(int i = 0; i < id.length(); i++){
            int comp = id.charAt(i);
            if(comp < (int) 'a' || comp > (int) 'z') return false;
        }
        return true;
    }

    //  친구 목록 유효성 검사
    private static void verifyFriends(List<List<String>> friends){
        //  verify friends list length : 길이가 1 이상 10,000 이하
        if(!verifyFriendsLength(friends)) throw new RuntimeException("INVALID_INPUT_LENGTH");
        //  verify frindes id length: 아이디의 길이가 1이상 30이하
        for(List<String> friend : friends){
            if(!verifyFriendsId(friend)) throw new RuntimeException("INVALID_ID_LENGTH");
        }
    }

    //  친구 목록 유효성 검사 - ID
    private static Boolean verifyFriendsId(List<String> friend){
        for(String s : friend){
            if(!verifyIdLength(s)) return false;
        }
        return true;
    }

    //  친구 목록 유효성 검사 - 목록 길이
    private static Boolean verifyFriendsLength(List<List<String>> friends){
        int length = friends.size();
        if (length < 1) return false;
        if (length > MAX_LIST_LENGTH) return false;
        return true;
    }

    //  방문자 목록 유효성 검사
    private static void verifyVisitors(List<String> visitors){
        int length = visitors.size();
        if (length == 0) throw new RuntimeException("INVALID_INPUT_LENGTH");
        if (length > MAX_LIST_LENGTH) throw new RuntimeException("INVALID_INPUT_LENGTH");
    }
}
