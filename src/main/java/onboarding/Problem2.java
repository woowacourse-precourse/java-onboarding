package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer crypto = new StringBuffer(cryptogram);
        for(int i=1;i<crypto.length();i++)
        {
            if(compare(crypto.charAt(i-1),crypto.charAt(i)))//두값이 같다면
            {
                crypto.delete(i-1,i+1);//두 단어 삭제
                i=1; //for문 초기화
            }
        }
        exception(crypto); //예외사황 처리
        answer = crypto.toString();
        return answer;
    }
    public static boolean compare(char index1, char index2)//두 문자열 값 확인하기
    {
        boolean sum = false;

        if(index1==index2)
            sum=true;

        return sum;
    }
    public static StringBuffer exception(StringBuffer crypto)//2개가 남으면 지워지지않는 예외상황 제거
    {
        if(compare(crypto.charAt(0),crypto.charAt(1)))
            crypto.delete(0,3);

        return crypto;
    }
}
