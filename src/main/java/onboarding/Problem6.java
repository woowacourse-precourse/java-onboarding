package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

	public static String correct_email = "@email.com";
	public static List<String> wrong_emails = new ArrayList<>();
	public static List<String> wrong_words = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {

    	List<String> answer = new ArrayList<>();

		List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        // 이메일과 닉네임 리스트에 넣어놓고 비교하기
        for(int i = 0; i < forms.size(); i++) {
        	List<String> form = forms.get(i);

        	emails.add(form.get(0));
        	nicknames.add(form.get(1));
        }
        email_list(emails); // 이메일 체크
        word_list(nicknames); // 닉네임 단어 체크

        // 문제되는 이메일 인덱스 값 찾기
        for(int i = 0; i < wrong_emails.size(); i++) {
        	for(int j = 0; j < emails.size(); j++) {
        		if(wrong_emails.get(i).equals(emails.get(j)) && !answer.contains(emails.get(j))) answer.add(emails.get(j));
        	}
        }

        // 문제되는 단어 포함하는 닉네임 단어 인덱스 값 찾기
        for(int i = 0; i < wrong_words.size(); i++) {
        	for(int j = 0; j < nicknames.size(); j++) {
        		if(nicknames.get(j).contains(wrong_words.get(i)) && !answer.contains(emails.get(j))) answer.add(emails.get(j));
        	}
        }

        // 나타내는 이메일 오름차순
        answer.sort(null);

        return answer;
    }

    // 잘못된 이메일 체크
 	public static void email_list(List<String> emails) {
     	for(int i = 0; i < emails.size(); i++) {
     		if(!emails.get(i).contains(correct_email)) wrong_emails.add(emails.get(i));
     	}
     }

 	// 중복되는 단어 체크
     public static void word_list(List<String> nicknames) {

     	List<String> words = new ArrayList<>();
     	for(int i = 0; i < nicknames.size(); i++) {
     		String chk = nicknames.get(i);

     		// 2글자 이상으로 체크할 수 있는 단어 모음
     		for(int j = 0; j < chk.length() - 1; j++) {
     			for(int k = j + 1; k < chk.length(); k++) {
     				if(k - j >= 1) words.add(chk.substring(j, k + 1));
     			}
     		}
     	}

     	// 중복되는 단어인 값 체크
     	for(int i = 0; i < words.size(); i++) {
     		for(int j = 0; j < words.size(); j++) {
     			if(i != j && words.get(i).equals(words.get(j)) && !wrong_words.contains(words.get(i))) 
     				wrong_words.add(words.get(i));
     		}
     	}
     }
}