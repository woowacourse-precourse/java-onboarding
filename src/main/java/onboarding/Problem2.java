package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
      StringBuilder sb = new StringBuilder(cryptogram);

      for(int i = 1; i < sb.length(); i++){
          char fstWord = sb.charAt(i - 1);
          char sndWord = sb.charAt(i);
          if(fstWord == sndWord){
              // 현재 인덱스의 문자와 한 칸 뒤에 있는 인덱스의 문자를 제거
              sb.delete(i - 1, i + 1);

              // 인덱스1(두번째 문자)에서 문자를 지운 경우에는 i를 1로 초기화
              if(i <= 1){
                  i = 1;
              } else { // 문자를 지운 인덱스에서 2번 앞에 있는 인덱스부터 다시 검색
                  i = i - 2;
              }
          } // end if
      } // end for
      String answer = sb.toString();
        return answer;
    }
}
