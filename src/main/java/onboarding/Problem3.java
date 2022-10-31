package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){ // 15
            int clap = countClap(i);
            answer += clap;

        }
        return answer;
    }

    private static int countClap(int i) {
        String[] splitNum = splitNumByDigits(i);
        int clap = 0;
        for(String str: splitNum){ // "1"
            int stringToInt = Integer.parseInt(str); // "1" => 1
            if(stringToInt % 3 == 0 && stringToInt != 0){ // false
                clap++;
            }
        }
        return clap;
    }

    private static String[] splitNumByDigits(int i) {
        String numToStr = Integer.toString(i); // 15 => "15"
        String[] splitNum = numToStr.split(""); // "15" => ["1", "5"]
        return splitNum;
    }
}
