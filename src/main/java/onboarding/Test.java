package onboarding;

import java.sql.Array;
import java.util.*;
import java.util.stream.*;

public class Test {
    /* Problem1
    public static void main(String[] args){
        List<Integer> pobi = new ArrayList<Integer>();
        List<Integer> crong = new ArrayList<Integer>();

        pobi.add(99);
        pobi.add(102);
        crong.add(211);
        crong.add(212);

        int answer = Integer.MAX_VALUE;
        // 예외사항
        // 1. 요소값 1~400 외
        // 2. 리스트 크기가 2가 아닌경우
        Integer[] pobiArr = pobi.stream().filter(s->s>=1).filter(s->s<=400).toArray(Integer[]::new);
        Integer[] crongArr = crong.stream().filter(s->s>=1).filter(s->s<=400).toArray(Integer[]::new);
//        System.out.println(Arrays.toString(pobiArr));
        if(pobiArr.length == 2 && crongArr.length == 2){
            int fpobi = pobiArr[0];
            int spobi = pobiArr[1];
            int fcrong = crongArr[0];
            int scrong = crongArr[1];
//            System.out.printf("%d, %d, %d, %d%n",fpobi,spobi,fcrong,scrong);
            // 포비, 크롱 각각의 점수 구해
            String strFpobi = String.valueOf(fpobi);
            String strSpobi = String.valueOf(spobi);
            String strFcrong = String.valueOf(fcrong);
            String strScrong = String.valueOf(scrong);

            int pobiScore = Math.max(maxValue(strFpobi),maxValue(strSpobi));
            int crongScore = Math.max(maxValue(strFcrong),maxValue(strScrong));
//            System.out.printf("%d, %d%n", pobiScore,crongScore);
            // 점수 비교하여 answer값 저장
            if(pobiScore>crongScore) answer = 1;
            else if(crongScore>pobiScore) answer = 2;
            else answer = 0;

//            System.out.println(answer);
            // 예외사항
            // 3. 연속된 두 값이 아닌경우
            // 4. 왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닌경우
            if((spobi-fpobi)!=1 || (scrong-fcrong)!=1 || (fpobi%2)!=1 || (spobi%2)!=0 || (fcrong%2)!=1 || (scrong%2)!=0)
                answer = -1;

//            System.out.println(answer);
        }else{
            answer = -1;
        }
        System.out.println(answer);
    }

    public static int maxValue(String num){
        int plusNum = 0;
        int multipleNum = 1;
        for(int i=0;i<num.length();i++){
            plusNum += (num.charAt(i)-'0');
            multipleNum *= (num.charAt(i)-'0');
        }
        return Math.max(plusNum,multipleNum);
    }
    */

    /* Problem2
    public static void main(String[] args){
        StringBuffer cryptogramBuffer = new StringBuffer("browoanoommnaon");
        while(true){
            int cnt=0;
            char cach = ' ';
            for(int i=0;i<cryptogramBuffer.length()-1;i++){
                if(cryptogramBuffer.charAt(i)==cryptogramBuffer.charAt(i+1)){
                    cach = cryptogramBuffer.charAt(i);
                    cryptogramBuffer.delete(i,i+2);
                    i--;
                    cnt++;
                }else if(cach == cryptogramBuffer.charAt(i)){
                    cryptogramBuffer.deleteCharAt(i);
                    i--;
                }else{
                    cach = ' ';
                }
            }

            if(cnt == 0)
                break;
        }
        String answer = cryptogramBuffer.toString();
        System.out.println(answer);
    }
     */

    /* Problem3
    public static void main(String[] args){
        int number = 20;
        int answer = 0;
        for(int i=1;i<=number;i++){
//            System.out.print(String.valueOf(i));
            answer += String.valueOf(i).chars().filter(c->c=='3'||c=='6'||c=='9').count();
        }
//        answer += String.valueOf(369).chars().filter(c->c=='3'||c=='6'||c=='9').count();
        System.out.println(answer);
    }
    */

    /* Problem4
    public static void main(String[] args){
        String word = "I love you";
        Map mother = new HashMap(){{
            put('A','Z');
            put('B','Y');
            put('C','X');
            put('D','W');
            put('E','V');
            put('F','U');
            put('G','T');
            put('H','S');
            put('I','R');
            put('J','Q');
            put('K','P');
            put('L','O');
            put('M','N');
            put('N','M');
            put('O','L');
            put('P','K');
            put('Q','J');
            put('R','I');
            put('S','H');
            put('T','G');
            put('U','F');
            put('V','E');
            put('W','D');
            put('X','C');
            put('Y','B');
            put('Z','A');
        }};
        char c = ' ';
        char[] frog = new char[word.length()];
        for(int i=0;i<word.length();i++){
            c = word.charAt(i);
            if(c>='A' && c<='Z')
                frog[i] = (char)mother.get(c);
            else if(c>='a' && c<='z')
                frog[i] = (char)((char)mother.get((char)(c-32))+32);
            else
                frog[i] = c;
        }

        String answer = new String(frog);
        System.out.println(answer);
    }
    */

    public static void main(String[] args){
        int money = 15000;
        List<Integer> answer = new ArrayList<>();
        int[] moneyUnit = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i : moneyUnit){
            answer.add(money / i);
            money %= i;
        }
        for(int i : answer.toArray(Integer[]::new))
            System.out.print(i+",");
    }
}
