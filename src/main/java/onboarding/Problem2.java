package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * List(add, get, size, contains,remove)
 * StringTokenizer(hasMoreTokens(),nextToken()) = 문자열 파싱, 구분자, 토큰화
 * 1, 받은 문자열을 배열화 시킨다
 *  - 중간의 삽입 삭제가 편한 리스트 고려
 * 2, 중복 문자 찾기
 */
public class Problem2 {
    static String cryptogram = "browoanoommnaon";
    static String alphbet = "abcdefghijklmnopqrstuvwxyz";
    
    public static String solution(String cryptogram) {
        String answer = "answer";

        StringtoList(cryptogram);
        return answer;
    }
    public static void StringtoList(String crcryptogram){
        List<String> list = new LinkedList<>();
        StringTokenizer str = new StringTokenizer(cryptogram,alphbet,true);
        while (str.hasMoreTokens()){
            list.add(str.nextToken());
        }
    }
    
    
    public static void main(String[] args){
    }
}
