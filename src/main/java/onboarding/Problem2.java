package onboarding;
// 1. replace 정규식을 이용하여 해결하는 방법
//    > 정규식을 어떻게 이용하여 임의의 문자의 중복을 선별하는 법을 모르겠다. 
// 2. Brute focre 
//    > 최악의 경우 O(n^2)
// 3. 패린드롬형식과 비슷하게 풀어보기.
//    > 한번의 탐색에 끝낼수 있다!
//    탐색 중 연속되는 문제가 나오면 그 곳을 기준으로 오른쪽, 왼쪽도 탐색
//    둘이 같다면 또 오른쪽 왼쪽도 탐색
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] arr = cryptogram.toCharArray();
        for(int i=0; i<arr.length-1; i++) {
        	if(arr[i]==arr[i+1] && arr[i]!='0') {
        		arr[i]='0';
        		arr[i+1]='0';
        		find_other_combo(i-1, i+1, arr);
        	}
        }
        for(int i=0; i<arr.length;i++) {
        	if(arr[i]!='0') {
        		answer +=arr[i];
        	}
        }
        return answer;
    }
    public static void find_other_combo(int L, int R, char[]arr){
    	if(L<0 || R >=arr.length) {return;}
    	// 앞애 이미 '0'으로 만든 index는 뛰어넘어 주어야한다. 
    	while(arr[L]=='0' || arr[R]=='0') {
    		if(arr[L]=='0') {
    			L--;
    			if(L<0) return;
    		}
    		if(arr[R]=='0') {
    			R++;
    			if(R>=arr.length) return;
    		}
    	}
    	if(arr[L]==arr[R]) {
    		arr[L] = arr[R] = '0';
    		find_other_combo(L-1,R+1,arr);
    	}
    }
}
