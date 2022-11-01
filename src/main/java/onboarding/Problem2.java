package onboarding;

public class Problem2 {

    //cryptogram은 길이가 1 이상 1000 이하인 문자열이다. cryptogram은 알파벳 소문자로만 이루어져 있다.
    //1. answer 을 한글자씩 판단할 수 있게한다.answer.charAt()로 사용하며 char 형태로 반환됨 추후에 string으로 반환시 String.valueof 로 변환
    //그리고 index ,index+1 로 중복된 것을 제거한다.
    public static String logic(String answer, int i){
        //"browoanoommnaon"
        StringBuilder answer_b = new StringBuilder(answer);
        if(i == answer.length()-1){
            return answer;
        }
        if(answer_b.charAt(i) != answer_b.charAt(i+1)){
            return logic(answer_b.toString(),i+1);
        }
        if(answer.length() < 3){
            return "";
        }
        answer_b.delete(i,i+2);
        answer = answer_b.toString();

        return logic(answer , 0);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        //logic : 연속으로 두번 중복된 글자는 삭제처리 한다.
        //zyelleyz => zyeeyz -> zyyz -> zz -> '' 이과정을 answer에 유지시켜야할듯
        //조건

        answer = logic(cryptogram, 0 );

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("zyelleyz");
    }



}
