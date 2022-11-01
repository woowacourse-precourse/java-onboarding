package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer ans = new StringBuffer(cryptogram);

        int left = 0;
        int right = 1;

        //right의 인덱스가 문자열의 끝에 위치할 때까지 반복한다.
        while (right < ans.length()){
            //right는 중복 문자의 첫 인덱스를, left는 중복 문자의 끝 인덱스의 다음 인덱스를 가지도록 한다.
            while (right < ans.length() && ans.charAt(left) == ans.charAt(right)){
                right += 1;
            }

            //right와 left를 비교해 중복 문자가 존재하면, 이를 제거하고 left와 right를 다시 비교할 인덱스로 조정한다.
            if (right - left > 1){
                ans.delete(left, right);
                left -= 1;
                right = left + 1;
            }
            //중복 문자가 존재하지 않으면, left와 right의 인덱스를 한 칸씩 이동한다.
            else {
                right += 1;
                left += 1;
            }
        }
        return ans.toString();
    }
}
