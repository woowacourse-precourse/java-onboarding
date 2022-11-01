package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
      StringBuffer sb = new StringBuffer(cryptogram);

      for(int i = 1; i < sb.length(); i++){
          char fstWord = sb.charAt(i - 1);
          char sndWord = sb.charAt(i);

          if(fstWord == sndWord && i <= 1){
              // 인덱스1(두번째 문자)에서 문자를 지운 경우에는 i를 1로 초기화
              sb.delete(i - 1, i + 1);
              i = 0;
          } else if(fstWord == sndWord){
              // 문자를 지운 인덱스에서 2번 앞에 있는 인덱스부터 다시 검사
              sb.delete(i - 1, i + 1);
              i -= 2;
          } // end if

      } // end for
      String answer = sb.toString();

      return answer;
    }

}
