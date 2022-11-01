package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외사항 책의 페이지가 이상할 경우.
        boolean err1 = pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1;// 페이지수 검사
        boolean err2 = (pobi.get(0) + crong.get(0)) % 2 != 0 || (pobi.get(1) + crong.get(1)) % 2 != 0;//페이지 홀, 짝 검사
        if(err1 || err2){//책 페이지가 비정상적으로 입력됬을경우
            answer = -1;
        }else{//정상의 경우
            int crongValue = maxValue(crong);
            int pobiValue = maxValue(pobi);

            if(pobiValue > crongValue){
                answer = 1;
            }
            else if(pobiValue < crongValue){
                answer = 2;
            }
            else{
                answer = 0;
            }
        }

        return answer;
    }

    public static int maxValue(List<Integer> arr){//자릿수로 다시
        int plusMax = 0;
        int mulMax = 1;

        String num = "";

        for(int q : arr){
            num = String.valueOf(q);

            for (int i = 0;i<num.length();i++)
                plusMax += (num.charAt(i) - '0');

            for (int i = 0;i<num.length();i++)
                mulMax *= (num.charAt(i) - '0');
        }


        return Math.max(plusMax, mulMax);
    }
}