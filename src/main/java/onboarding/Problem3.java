package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=0; i<=number; i++) {
        	String num1 = String.valueOf(number);
        	String[] num2 = num1.split("");
        	for(String num3 : num2) {
        		if(Integer.parseInt(num3) % 3 == 0 && Integer.parseInt(num3) != 0) {
        			answer ++;
        		}
        	}
        }
        return answer;
    }
    
    public static void main(String[] args){
    //	System.out.println(solution(3));
        /*int number = 123;
    	String num1 = String.valueOf(number);
    	String[] num2 = num1.split("");*/
    	int answer = 0;
    	int number = 33;
        for(int i=0; i<=number; i++) {
        	String num1 = String.valueOf(number);
        	String[] num2 = num1.split("");
        	System.out.println(num1);
        	for(String num3 : num2) {
        		if(Integer.parseInt(num3) % 3 == 0 && Integer.parseInt(num3) != 0) {
        			answer++;
        		}
        	}
        }
    	System.out.println(answer);
    }
}
/*1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30
 * 31,32,33 14번인 이유 33은 두번 토크나이저
 * 33이 입력되면 33번을 1부터 33까지 순서대로 수 분리 후 369가 있는지 체크 후 있으면 count++ 
 * n번째 숫자 추출(number1 / 10^(자리수(0~)-1))%10;
 * 숫자 자리수 추출(int)( Math.log10(num)+1 )
 * 0번째는 -N 이 나옴 그러므로 *-1 해줘야 양수로 나옴
 * 1. 숫자 받는다
 * 2. 숫자 자리수 체크
 * 3. 받은 숫자만큼 반복하며 숫자n번째 추출하고 그 수가 369에 속한지 체크한다
 * 	  (1-10까지는 값 넣어준다)
 * 4. 속해있으면 count++
 */
 