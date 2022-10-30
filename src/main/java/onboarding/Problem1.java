package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        myfunc01 mf= new myfunc01(); // 메소드 임포트
        if(!(mf.chk_cond(pobi)&&mf.chk_cond(crong))){ // 둘 중 하나라도 참이 아닌경우
            return -1;
        }else{ // 무결성 체크 이후 기능 수행
            int repPobi=-1; // 포비의 점수
            repPobi=mf.cal_score(pobi,mf,repPobi);
            int repCrong=-1;
            repCrong=mf.cal_score(crong,mf,repCrong);
            // 포비와 크롱의 점수 비교
            if(repPobi>repCrong){// 포비점수가 높은경우
                return 1;
            }else if(repPobi<repCrong){
                return 2;
            }else return 0;
        }
    }
    public static class myfunc01 {
        // 분리가 된 자릿수를 더하는 기능
        int sum(List<Integer> nums) {
            return (int) nums.stream().reduce((x, y) -> x + y).stream().toArray()[0];
        }
        // 분리가 된 자릿수를 곱하는 기능
        int multi(List<Integer> nums){
            return (int) nums.stream().reduce((x,y)->x*y).stream().toArray()[0];
        }
        // 한 쪽 페이지의 숫자에 대하여 자릿수를 하나씩 리스트에 집어넣어 리턴하는 기능
        List<Integer> divPage(Integer pages){
            String s=Integer.toString(pages);
            List<Integer> result=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                result.add(Integer.parseInt(s.substring(i,i+1))); // 자릿수를 하나씩 리스트에 추가
            }
            return result;
        }
        // 각자의 점수 계산
        int cal_score(List<Integer> user,myfunc01 mf ,int rep){
            for (int i = 0; i < 2; i++) { // 포비
                List<Integer> tmp = mf.divPage(user.get(i));
                int a=mf.sum(tmp);
                int b=mf.multi(tmp);
                if(a>=b){ // 합한 것이 더 클 경우
                    if(rep<a) rep=a;
                }else { // 곱한 것이 더 클경우
                    if(rep<b) rep=b;
                }
            }
            return rep;
        }
        // 무결성 체크하는 기능/
        boolean chk_cond(List<Integer> lst){
            if(lst.get(0)!=lst.get(1)-1){ // 하나 차이가 아니라면
                return false;
            }else if(lst.get(0)%2==0 || lst.get(1)%2==1){ // 홀짝이 맞지 않으면(0이나오거나;짝수 || 1이 나온다면;홀수)
                return false;
            }else return true; // 입력이 무결하면
        }

    }
}