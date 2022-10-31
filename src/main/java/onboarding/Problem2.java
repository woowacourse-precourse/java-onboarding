package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int cryptogramIndex=0; //문자열 순회 변수
        int end = cryptogram.length(); // 순회의 끝 조건 지정을 위해

        while (cryptogramIndex < end){
            if (cryptogramIndex != end-1 && cryptogram.charAt(cryptogramIndex) == cryptogram.charAt(cryptogramIndex+1) ){
                cryptogram = cryptogram.replace(cryptogram.substring(cryptogramIndex,cryptogramIndex+2),"");
                cryptogramIndex=0;
                end = cryptogram.length();
            }
            else {
                cryptogramIndex++;
            }
        }

        answer = cryptogram;
        return answer;
    }
}
