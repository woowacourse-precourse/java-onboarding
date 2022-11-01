package onboarding;
/*
중복 문자 삭제
1. String.charAt(i)을 이용해 i의 문자가 i+1과 같은지 검사
2. 같다면 지워주고 ( substring 이용) i값 갱신
3. 반복
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        int i = 0;
        while(i<cryptogram.length()-1){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                cryptogram=cryptogram.substring(0,i)+cryptogram.substring(i+2);
                System.out.println("cryptogram = " + cryptogram);
                i=i-1;
                continue;
            }
            i++;
        }
        String answer = cryptogram;
        return answer;
    }
}
