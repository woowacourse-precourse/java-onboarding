package onboarding;
//문자열 중복이 아니면 문자열에 붙이기
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String answer2 = "";
        while(answer!=answer2){
            answer=decrypt(cryptogram);
            answer2 = decrypt(cryptogram);
        }
        return answer;
    }
    public static String decrypt(String cryptogram){
        String answer="";
        int count=0;//중복된 문자열의 연속인지아닌지 구분하기위한 인자
        for(int i=0;i<cryptogram.length();i++){
            if(i==(cryptogram.length()-1)){ //i가 마지막 인덱스일때
                if(cryptogram.charAt(i-1)!=cryptogram.charAt(i)){
                    answer+=cryptogram.charAt(i);
                }else break;
            }else{
            if((cryptogram.charAt(i)!=cryptogram.charAt(i+1))&&count>0){//다음인자와는 같지않지만 중복된 문자열의 연속일경우
                count=0;
                continue;
            }else if((cryptogram.charAt(i)!=cryptogram.charAt(i+1))&&count==0){
                count=0;
                answer+=cryptogram.charAt(i);
            }else count ++;//다음인자와 같으면 count++;
                    continue;
        }}
        return answer;
    }
}
