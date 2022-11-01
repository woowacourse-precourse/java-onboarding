package onboarding;

import java.util.List;

class Problem1 {

    //예외사항에 해당하는 경우인지 체크
    public static boolean exception(int pobileft, int pobiright, int crongleft, int crongright){
        boolean check = false;

        // 페이지가 1~400 이 아닐 경우
        if(!(pobileft>=1 && pobileft<=400) || !(pobiright>=1 && pobiright<=400) || !(crongleft>=1 && crongleft<=400) || !(crongright>=1 && crongright<=400)){
            check = true;
        }

        // 왼쪽 페이지는 홀수이고 오른쪽 페이지는 짝수가 아닐 경우
        if(pobileft%2!=1 || pobiright%2!=0 || crongleft%2!=1 || crongright%2!=0){
            check =  true;
        }

        // 왼쪾 페이지와 오른쪽 페이지가 연속적이지 않을 경우
        if(pobileft+1!=pobiright || crongleft+1!=crongright){
            check =  true;
        }

        return check;
    }

    // 해당 페이지의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 반환한다.
    public static int maximumValue(int page){
        String spage = Integer.toString(page);
        int sum=0;
        int mul=1;
        for (int i = 0; i < spage.length(); i++) {
            System.out.println((int)spage.charAt(i)-'0');
            sum = sum + ((int)spage.charAt(i)-'0');
            mul = mul * ((int)spage.charAt(i)-'0');
        }
        return Math.max(sum, mul);
    }

    // 왼쪽 페이지와 오른쪽 페이지를 비교해 최종 점수를 반환한다.
    public static int comparePage(int leftpage, int rightpage){
        return Math.max(leftpage, rightpage);
    }

    // 우승자를 반환한다.
    public static int returnAns(int pobiscore, int crongscore){
        int answer = -1;

        //pobi가 우승할 경우
        if(pobiscore > crongscore){
            answer = 1;
        }

        //crong이 우승할 경우
        else if(pobiscore < crongscore){
            answer = 2;
        }

        //무승부일 경우
        else{
            answer = 0;
        }
        return answer;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // pobi와 crong의 페이지 수 변수에 저장
        int pobileft = pobi.get(0);
        int pobiright = pobi.get(1);
        int crongleft = crong.get(0);
        int crongright = crong.get(1);

        // 예외사항 체크
        if(exception(pobileft, pobiright, crongleft, crongright)) return -1;

        // 각 페이지의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int pobileftmaximum = maximumValue(pobileft);
        int pobirightmaximum = maximumValue(pobiright);
        int crongleftmaximum = maximumValue(crongleft);
        int crongrightmaximum = maximumValue(crongright);

        // 최종 pobi와 crong의 점수를 구한다.
        int pobiscore = comparePage(pobileftmaximum, pobirightmaximum);
        int crongscore = comparePage(crongleftmaximum, crongrightmaximum);

        //포비와 크롱의 승부를 가린다.
        return returnAns(pobiscore, crongscore);
    }
}
