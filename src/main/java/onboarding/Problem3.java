package onboarding;

import java.util.Arrays;

public class Problem3 {

   public static int cnt_369(Integer i){
       StringBuilder i_s = new StringBuilder(i.toString()); // i를 stringbuild로 바꿔서 숫자 하나하나 알아보자~
       int cnt = 0;
       while(i/10 > 0){
           //1의자리 => 가장 오른쪽 숫자
           if(i%10 == 3 || i%10 == 6 || i%10 == 9 ){
               cnt++;
           }
            i = i/10;
       }
        if(i%10 == 3 || i%10 == 6 || i%10 == 9 ){
            cnt++;
        }


       return cnt;
   }
    public static int solution(int number) {
        int answer = 0;
        int cnt_clap = 0;
        //number까지 현재 숫자는 1씩 커진다.
        for(Integer i = 0; i <= number ; i++){
            //숫자에 '3'이 포함된 갯수 만큼 박수를 치고 박수를 count 한다.
            // => 3 6 9 로 바꿔야됨

            cnt_clap += cnt_369(i);
        }
        answer = cnt_clap;
        System.out.println(answer);

        return answer;
    }
    public static void main(String[] args) {
        solution(15);
    }
}

