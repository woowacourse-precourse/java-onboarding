package onboarding;

//암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
//
//"browoanoommnaon"
//"browoannaon"
//"browoaaon"
//"browoon"
//"brown"
//임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
//
//제한사항
//cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
//cryptogram은 알파벳 소문자로만 이루어져 있다.
//실행 결과 예시
//cryptogram	result
//"browoanoommnaon"	"brown"
//"zyelleyz"	""


// 한글자씩 보며 중복되는 부분을 찾아 삭제.
// 중복삭제이후 그 이전 글자부터 다시 반복
// 아무 삭제도 일어나지 않으면 끝.
public class Problem2 {
	
	//1. 문자열을 순회하며 중복을 찾는 메소드 -> 있다면 해당 인덱스, 갯수 보내주고 아니면 -1 리턴
	public int[] check(int start_idx, String target) {
		char curr = target.charAt(start_idx);
		int idx = -1, num = 1; // 중복시 삭제할 인덱스, 갯수
		for (int i = start_idx; i < target.length() - 1; i++) {
			char next = target.charAt(i + 1);
			if (curr == next) {
				num++;
				if (idx == -1) {
					idx = i;
				}
			}
			else if (idx != -1) {
				break;
			}
			curr = next;
		}
		int [] arr = {idx, num};
		return arr;
		
	}
	
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
