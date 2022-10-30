package onboarding;

import java.util.List;

//0.검증
//1)시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
//2)연속되지 않는 경우
//3)왼페이지 짝수면 에러, 오른페이지 홀수면 에러
//1.왼 페이지 모두 더한 경우
//2.오른 페이지 모두 더한 경우
//3.왼 페이지 모두 곱한 경우
//4.오른 페이지 모두 곱한 경우
//5.출력: 각자 최댓값 비교
//만약 에러있으면 -1

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        boolean ok=true;
        int max1 = -1;
        int max2=-1;
        int tpSum=0, tp=1;

        //0.검증
        //1)시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        //2)연속되지 않는 경우
        //3)왼페이지 짝수면 에러, 오른페이지 홀수면 에러
        if(pobi.get(1)<=1 || pobi.get(1)>=400){ok=false;}
        if(crong.get(1)<=1 || crong.get(1)>=400){ok=false;}

        if(pobi.get(1)-pobi.get(0) != 1){ok=false;}
        if(crong.get(1)-crong.get(0) != 1){ok=false;}

        if(pobi.get(0)%2 != 1 || pobi.get(1)%2 !=0){ok=false;}
        if(crong.get(0)%2 != 1 || crong.get(1)%2 !=0){ok=false;}
        //1.왼 페이지 모두 더한 경우
        //2.오른 페이지 모두 더한 경우
        //3.왼 페이지 모두 곱한 경우
        //4.오른 페이지 모두 곱한 경우
        if(ok==true){
            for(int j=0;j<2;j++){
                for(int i=0;i<pobi.get(j).toString().length();i++){
                    tpSum+=pobi.get(j).toString().charAt(i)-'0';
                }
                if(tpSum> max1){
                    max1= tpSum;
                }
                tpSum=0;
            }

            for(int j=0;j<2;j++){
                for(int i=0;i<pobi.get(j).toString().length();i++){
                    tp*= pobi.get(j).toString().charAt(i)-'0';
                }
                if(tp>max1){max1 = tp;}
                tp=1;
            }

            for(int j=0;j<2;j++){
                for(int i=0;i<crong.get(j).toString().length();i++){
                    tpSum+=crong.get(j).toString().charAt(i)-'0';
                }
                if(tpSum> max2){
                    max2= tpSum;
                }
                tpSum=0;
            }

            for(int j=0;j<2;j++){
                for(int i=0;i<crong.get(j).toString().length();i++){
                    tp*= crong.get(j).toString().charAt(i)-'0';
                }
                if(tp>max2){max2 = tp;}
                tp=1;
            }
        }

        //5.출력: 각자 최댓값 비교
        //만약 에러있으면 -1
        if(ok==false){ answer=-1;}
        else if(max1== max2){answer=0;}
        else if(max1>max2){answer=1;}
        else if(max1<max2){answer=2;}
        return answer;
    }
}