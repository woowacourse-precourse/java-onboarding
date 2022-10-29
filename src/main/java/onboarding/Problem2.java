package onboarding;

public class Problem2 {

    // 1. cryptogram 예외사항 검사함수 만들기
    // cryptogram이 대문자가 들어간 경우거나 길이가 1~1000을 벗어난 경우 false return
    public static boolean isException(String cryptogram){
        if(cryptogram.length() > 1000 || cryptogram.length() < 1){ // 길이가 1~1000을 벗어난 경우 false return
            return false;
        } else if(isUpperCase(cryptogram)){ // 대문자가 있는 경우 false return
            return false;
        }
        return true;
    }

    // 대문자 검사 함수.
    public static boolean isUpperCase(String cryptomgram){
        for(int i = 0; i < cryptomgram.length(); i++){
            if(cryptomgram.indexOf(i) == cryptomgram.toUpperCase().indexOf(i)){ // 대문자가 있는 경우 true return
                return true;
            }
        }
        return false;
    }
    // 2. 연속하는 중복문자를 삭제하는 함수 만들기
    public static String deleteDuplicate(String cryptogram){
        String answer = "";
        for(int i = 0; i<cryptogram.length(); i++){
            if(cryptogram.indexOf(i) != cryptogram.indexOf(i+1)){
                answer += cryptogram.indexOf(i);
            }
        }
        return answer;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(isException(cryptogram)){
            // 2. 연속하는 중복문자를 삭제하는 함수 만들기
        }

        return answer;
    }
}
