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
}
