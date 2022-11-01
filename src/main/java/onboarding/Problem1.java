package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft % 2 == 0 || pobiRight % 2 == 1 || crongLeft % 2 == 0 || crongRight % 2 == 1){      // 왼페이지가 짝수 or 오른페이지 홀수
            return -1;
        }
        else if (pobiLeft == 1 || pobiRight == 400 || crongLeft == 1 || crongRight == 400){  // 시작이 1page거나 끝이 400page
            return -1;
        }
        else if (pobiRight != pobiLeft+1 || crongRight != crongLeft+1){ // 연속하는 페이지가 아닐 때
            return -1;
        }

        String[] pobiLeftStr = String.valueOf(pobiLeft).split("");
        String[] pobiRightStr = String.valueOf(pobiRight).split("");
        String[] crongLeftStr = String.valueOf(crongLeft).split("");
        String[] crongRightStr = String.valueOf(crongRight).split("");

        pobiLeft = compare(pobiLeftStr);
        pobiRight = compare(pobiRightStr);

        int bigPobi;
        if (pobiLeft >= pobiRight){   // 왼쪽 페이지 > 오른쪽 페이지
            bigPobi = pobiLeft;
            System.out.println("포비는 왼페이지가 큼");
        }
        else {
            bigPobi = pobiRight;
        }

        crongLeft = compare(crongLeftStr);
        crongRight = compare(crongRightStr);

        int bigCrong;
        if (crongLeft >= crongRight){   // 왼쪽 페이지 > 오른쪽 페이지
            bigCrong = crongLeft;
        }
        else {
            bigCrong = crongRight;
        }

    // 포비와 크롱 점수 비교
        if (bigPobi > bigCrong){
            answer = 1;
        }
        else if (bigPobi == bigCrong){
            answer = 0;
        }
        else if (bigPobi < bigCrong){
            answer = 2;
        }
        else{
            answer = -1;
        }
        return answer;
    }

    public static int add (String[] str){   // 덧셈
        int result = 0;
        for (int i = 0; i < str.length; i++){
            result += Integer.valueOf(str[i]);
        }
        return result;
    }
    public static int mul (String[] str){   // 곱셈
        int result = 1;
        for (int i = 0; i < str.length; i++){
            result *= Integer.valueOf(str[i]);
        }
        return result;
    }

    public static int compare (String[] str){   // add와 mul 중 더 큰 것 비교
        int bigNum;
        if (add(str) >= mul(str)){
            bigNum = add(str);
        } else {
            bigNum = mul(str);
        }
        return bigNum;
    }
}

