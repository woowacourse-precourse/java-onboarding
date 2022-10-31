package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     *
     * 기능 1=>연속되는 수찾기
     * 기능2=>이후에 나오는 연속 되는 수도 찾기
     * */
    public static String solution(String cryptogram) {
        //중복 문자열을 저장하는 변수
        Stack<Character> duple=new Stack<>();
        String cry=cryptogram;
        //이전 문자
        Character before=' ';
        boolean isDuple=true;

      while(isDuple){
          isDuple=false;
          //while 반복시 before 가 쌓이는 문제 해결을 위해 초기화
          before=' ';

          //모든 문자를 돌면서 공통 부분 찾는 메서드
          for(Character c:cry.toCharArray()){
              //중복이 끝난경우
              if(before!=c){
                  //중복이 2개이상인경우
                  if (duple.size() >= 2) {
                      String str="";
                      for(int i=0;i<duple.size();i++){
                          str+=""+before;
                      }
                      cry=cry.replace(str,"");
                      isDuple=true;
                  }
                  duple.clear();
                  duple.add(c);
              }else{ //중복인 경우
                  duple.add(c);
              }
              before=c;
          }
      }
      //마무리전까지 중복이 있던경우
        if(duple.size()>1){
            String str="";
            for(int i=0;i<duple.size();i++){
                str+=""+before;
            }
            cry=cry.replace(str,"");
            isDuple=true;
        }
        return cry;
    }
}
