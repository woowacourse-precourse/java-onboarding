package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
//      모든 수를 검증하기 위한 반복문 설정
        for(int i=1;i<=number;i++){
//          int를 String으로 형변환
            String n = Integer.toString(i);
//          각 수를 문자열로 변환한 뒤 3을 찾아 공백으로 대체한다.
//          기존 수의 자릿수에서 공백으로 대체한 새로운 문자열을 빼면 각 수에서 3이 포함된 개수를 알 수 있다.
//          위와 같은 방식으로 6과 9도 포함된 개수를 구한다.
            int count3 = n.length() - n.replace("3","").length();
            int count6 = n.length() - n.replace("6","").length();
            int count9 = n.length() - n.replace("9","").length();
//          기존 answer에서 3, 6, 9의 개수를 더해주면 3, 6, 9 개수의 총합을 구할 수 있다.
            answer = answer + count3 + count6 + count9;
        }
        return answer;
    }
}
