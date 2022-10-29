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
            if(cryptomgram.charAt(i) == cryptomgram.toUpperCase().charAt(i)){ // 대문자가 있는 경우 true return
                return true;
            }
        }
        return false;
    }
    // 중복이 있는지 체크하는 함수 만들기.
    public static boolean isDuplicate(String cryptomgram){
        for(int i = 0; i < cryptomgram.length(); i++){
            if(cryptomgram.charAt(i) == cryptomgram.charAt(i++)){
                return true;
            }
        }
        return false;
    }
    // 2. 연속하는 중복문자를 삭제하는 함수 만들기
    public static String deleteDuplicate(String cryptogram){
        char[] chars = cryptogram.toCharArray();
        char prev = 0;
        int k = 0;

        for(char c : chars){
            if(prev != c) {
                chars[k++] = c;
                prev = c;
            }else{
                chars[k--] = chars[k+2];
            }
        }
        return new String(chars).substring(0, k);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(isException(cryptogram)){
            // 중복제거 함수를 통해서 중복제거 하기.
            System.out.println("유효성 검사 통과");
            while(isDuplicate(cryptogram)){
                System.out.println("유효성 검사 통과 : " + cryptogram);
                cryptogram = deleteDuplicate(cryptogram);
                if(!isDuplicate(cryptogram)){
                    answer = cryptogram;
                    System.out.println("결과 : " + answer);
                    break;
                }
            }
        }

        return answer;
    }
}
