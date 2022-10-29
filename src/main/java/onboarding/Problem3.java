package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean isIn369(String string){
        // 3, 6, 9가 있는지 확인해주는 메소드
        int number = Integer.parseInt(string);
        return number == 3 || number == 6 || number == 9;
    }

    private static int getCount(int number){
        // 3, 6, 9의 개수를 세주는 메소드
        String string = String.valueOf(number);
        int totalCount = 0;
        for(String s : string.split("")){
            if (isIn369(s)){
                totalCount += 1;
            }
        }

        return totalCount;
    }
}
