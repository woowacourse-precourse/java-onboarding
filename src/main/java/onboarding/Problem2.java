package onboarding;

public class Problem2 {

    /*
    * 기능 정리
    * 1. 중복이 존재하는지 확인
    * 2. 중복이 있을시 중복을 제거
    * 1,2를 중복이 제거 될 때 까지 반복됨.
    * */

    static int isDuplicates(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }
        return 0;
    }


    public static String solution(String cryptogram) {
        return removeDuplicates(cryptogram);
    }
}
