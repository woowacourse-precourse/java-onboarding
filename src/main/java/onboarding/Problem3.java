package onboarding;

//기능목록
//1.입력받은 number만큼 반복하며 각 자리수 에 369가 있는지 확인.
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //입력받은 number만큼 반복
        for(int i = 0 ; i <= number ; i++){
            int count = i;
            // 각 자리 수 마다 10으로 나눠가며 369를 확인
            while (count > 1){
                if(count % 10 == 3 || count % 10 == 6 || count % 10 == 9){
                    answer++;
                }
                count /=10;
            }
        }
        return answer;
    }
}
