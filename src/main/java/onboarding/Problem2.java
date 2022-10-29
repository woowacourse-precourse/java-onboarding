package onboarding;
import java.util.Scanner;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true) {//중복 문자를 계속 확인
            for(int i=0; i<cryptogram.length()-1; i++) { //문자열에서 연속된 중복 문자를 공백으로 대체 -> 제거
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    cryptogram = cryptogram.replace(cryptogram.substring(i,i+2), "");
                }
            }
            answer = cryptogram; //return 값을 중복이 제거된 문자로 설정

            int check = 0;
            for(int i = 0; i<cryptogram.length()-1; i++) { //중복된 문자가 있는지 알아보기
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    check += 1;
                }
            }
            if(check == 0) { // 중복된 문자가 없다면 while문 탈출
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) { //문자열 입력 받기
        Scanner sc = new Scanner(System.in);
        String cryptogram = sc.nextLine();
        System.out.println(solution(cryptogram));
    }
}
