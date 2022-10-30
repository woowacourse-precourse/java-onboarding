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

    /**
     * 3.리스트 0번지와 마지막이 가지는 인덱스번호를 리턴하는 함수
     */
    public static int [] decoding(String cryptogram){
        List<Integer> arr = array(cryptogram);
        arr = split(arr);

        int [] overlapIndex = new int[2];
        int size = arr.size();
        if(size == 0){
            return overlapIndex;
        }

        overlapIndex[0] = arr.get(0);
        overlapIndex[1] = arr.get(size-1);
        return overlapIndex;
    }

    /**
     * 4.중복문자 부분만 제거해서 리턴하는 함수
     * 중복문자가 없을경우(overlap Index == 0) cryptogram 리턴
     * 중복문자가 있을경우(overlap Index > 0) 중복문자를 잘라서 cryptogram 재선언
     * 변경된 cryptogram 리턴
     */
    public static String overlapDelete(String cryptogram) {
        int [] overlapIndex = decoding(cryptogram);
        if(overlapIndex[0] == 0 && overlapIndex[1] == 0){
            return cryptogram;
        }
        cryptogram = cryptogram.substring(0, overlapIndex[0]) +
                cryptogram.substring(overlapIndex[1]+1,cryptogram.length());
        return overlapDelete(cryptogram);
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
