package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i =3; i<=number;i++){
            int [] tmp = parseNum(i);
            answer += check(tmp);
        }
        return answer;
    }
    public static  int check(int []tmp){
        int cnt =0;
        for (int q=0;q<tmp.length;q++){
            if (tmp[q]==3 || tmp[q]==6 || tmp[q]==9){
                cnt++;
            }
        }
        return cnt;
    }
    public static int[] parseNum(int num) { 	// 한자리수 씩 파싱하는 함수
        int len = Integer.toString(num).length();
        int []tmpnum = new int[len];
        for(int i=0;i<len; i++) { //역순으로 저장됨
            tmpnum[i]= num%10;
            num /=10;
        }
        int tmp=0;
        for (int i=0;i<len/2;i++) { // 다시 역순으로 뒤집기
            tmp = tmpnum[i];
            tmpnum[i] = tmpnum[len-1-i];
            tmpnum[len-1-i] = tmp;
        }
        return tmpnum;
    }
}
