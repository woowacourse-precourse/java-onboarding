package onboarding;

public class Problem2 {

    /*
    * 기능 정리
    * 1. 중복이 존재하는지 확인
    * 2. 중복이 있을시 중복을 제거
    * 1,2를 중복이 제거 될 때 까지 반복됨.
    * */

    //1. 기능1
    static int isDuplicates(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }
        return -1; // 0번 idx를 사용함으로 -1로 반환
    }

    //2. 기능2
    static String removeDuplicates(String cryptogram){

        int start = isDuplicates(cryptogram);

        if(start == -1){ // 비교연산자 써야함.
            return cryptogram;
        }

        int end = start+1;

        for(; end<cryptogram.length(); end++){
            if(cryptogram.charAt(start) != cryptogram.charAt(end)) break;
        }

        String newCryptogram = cryptogram.substring(0,start) + cryptogram.substring(end);
        return removeDuplicates(newCryptogram); //★ for문으로 바꿔보기
    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicates(cryptogram);
        return answer;
    }
}
