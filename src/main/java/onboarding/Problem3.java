package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // 2. 원래 숫자 길이와 ClapNumber가 제거된 숫자 길이의 차이를 찾기
    // -> 해당 숫자의 ClapNumber 갯수를 찾음
    public static int find369(String num)
    {
        String removedNum =removeClapNumber(num);

        int totalNumLength = num.length();
        int removedNumLength = removedNum.length();

        return totalNumLength - removedNumLength;
    }

    // 3. 현재 숫자에서 ClapNumber(3,6,9)만 제거하기
    public static String removeClapNumber(String num)
    {
        String removedNum = num
                .replace("3", "")
                .replace("6", "")
                .replace("9", "");
        return removedNum;
    }

    // 4. int -> String 타입 변환
    public static String changeIntToString(int num)
    {
        String result= Integer.toString(num);
        return result;
    }
}
