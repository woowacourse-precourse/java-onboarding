package onboarding;

public class
Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String tmpString = "";

        for(int i =0; i<=number;i++){ // 1~number 까지 문자화
            tmpString+= i ;
        }

        for( int i =0; i<tmpString.length(); i++){ // 박수 횟수 count
            if (tmpString.charAt(i)=='3' || tmpString.charAt(i)=='6'|| tmpString.charAt(i)=='9'){
                answer+=1;
            }
        }
        return answer;
    }
}
