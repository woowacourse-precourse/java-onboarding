package onboarding;
import java.util.Scanner;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true) {
            for(int i=0; i<cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    cryptogram = cryptogram.replace(cryptogram.substring(i,i+2), "");
                }
            }
            answer = cryptogram;

            int check = 0;
            for(int i = 0; i<cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    check += 1;
                }
            }
            if(check ==0) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cryptogram = sc.nextLine();
        System.out.println(solution(cryptogram));
    }
}
