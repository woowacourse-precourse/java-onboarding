package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 사항
 * 1.중복문자가 있는 인덱스번호를 리스트에 추가하는 함수
 * 2.연속되지 않은 중복문자라면, 배열을 잘라 리턴하는 함수
 * 3.리스트 0번지와 마지막이 가지는 인덱스번호를 리턴하는 함수
 * 4.중복문자 부분만 제거해서 리턴하는 함수
 */
public class Problem2 {
    /**
     * 1.중복문자가 있는 인덱스번호를 리스트에 추가하는 함수
     */
    static List<Integer> array(String n){
        List<Integer> overlaplist = new ArrayList<>();
        for(int i = 1; i<n.length();i++){
            if(n.charAt(i-1) == n.charAt(i)){
                overlaplist.add(i-1);
                overlaplist.add(i);
            }
        }
        return overlaplist;
    }

    /**
     * 2.연속되지 않은 중복문자라면, 배열을 잘라 리턴하는 함수
     */
    public static List<Integer> split (List<Integer> n){
        for(int j = 1; j<n.size(); j++){
            if(n.get(j-1) == n.get(j) || n.get(j-1)+1 == (n.get(j))){

            } else{
                n = n.subList(0,j);
                break;
            }
        }
        return n;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
