package onboarding;



public class Problem2 {

    public static long countChar(String str, char ch){
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static String solution(String cryptogram) {
        String answer = "";
        char[] dividedChars;
        String temp = "";

//        문자열에서 사용하는 char들 가져오기
        for (int i=0;i<cryptogram.length();i++){
            if(cryptogram.indexOf(cryptogram.charAt(i)) == i){
                temp += cryptogram.charAt(i);
            }
        }
//        사용하는 char를 char[]형태로
        dividedChars = temp.toCharArray();

//        char 개수가 홀수이면 추가
        for(int i=0; i < temp.length(); i++){
            if (countChar(cryptogram, dividedChars[i])%2 == 1){
                answer += dividedChars[i];
            }
        }

        return answer;
    }
}
