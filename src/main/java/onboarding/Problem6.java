package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");

		answer = getEmailList(forms);

		return answer;
	}

	/**
     * 닉네임이 유사한 사람들의 이메일 목록을 반환한다.
     * @param <이메일,이름>의 리스트 
     * @return 닉네임이 유사한 사람들의 이메일 목록
     */
	private static List<String> getEmailList(List<List<String>> forms) {

		Set<Integer> similarNicknameIndex = new HashSet<Integer>();

		for (int index = 0; index < forms.size(); index++) {
			similarNicknameIndex.addAll(findSimilarNickname(index, forms));
		}
		List<String> emailList = indexToEmailList(similarNicknameIndex, forms);

		return emailList;
	}
	
	/**
     * 특정 index의 유저 닉네임과 닉네임이 유사한 사람들의 index를 반환한다
     * @param 검색기준이 되는 index, <이메일,이름>의 리스트 
     * @return 닉네임이 유사한 사람들 index 목록
     */
	private static Set<Integer> findSimilarNickname(int index, List<List<String>> forms) {

		Set<Integer> set = new HashSet<Integer>();

		String nickName = forms.get(index).get(1);
		for (int i = 1; i < nickName.length(); i++) {
			String comparativeString = Character.toString(nickName.charAt(i - 1))
					+ Character.toString(nickName.charAt(i));
			set.addAll(chcekOtherNickname(forms, index, comparativeString));
		}

		return set;
	}

	/**
     * 해당 철자가 다른 닉네임들과 유사한지 확인하고 그 index들을 밙환한다.
     * @param  <이메일,이름>의 리스트, 검색기준이 되는 index, 비교하는 철자
     * @return 닉네임이 유사한 사람들 index 목록
     */
	private static Set<Integer> chcekOtherNickname(List<List<String>> forms, int index, String comparativeString) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < forms.size(); i++) {
			if (i != index) {
				List<String> form = forms.get(i);
				String nickName = form.get(1);
				if (nickName.indexOf(comparativeString) != -1) {
					set.add(i);
				}
			}
		}
		return set;
	}

	/**
     * 인덱스의 목록을 이메일 목록을 변환하여 반환
     * @param  인덱스 목록, <이메일,이름>의 리스트
     * @return 이메일 목록
     */
	private static List<String> indexToEmailList(Set<Integer> similarNicknameIndex, List<List<String>> forms) {

		List<String> emailList = new ArrayList<String>();

		for (Integer index : similarNicknameIndex) {
			List<String> form = forms.get(index);
			emailList.add(form.get(0));
		}

		emailSort(emailList);
		return emailList;
	}
	
	/**
     * 이메일 목록을 정렬한다.
     * @param  이메일 목록
     */
	private static void emailSort(List<String> emailList) {

		Comparator<String> emailSort = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				o1.replace("@email.com", "");
				o2.replace("@email.com", "");
				return o1.compareTo(o2);
			}
		};

		emailList.sort(emailSort);
	}
}
