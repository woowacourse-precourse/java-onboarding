package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");

		ApplicationForm applicationForm = new ApplicationForm(forms);
		answer = applicationForm.getSimilarEmailList();

		return answer;
	}
}

class ApplicationForm {

	List<PeopleInfo> peopleInfoList;


	/**
	 * 유저 목록 인스턴스를 생성한다.
	 * 
	 * @param List<[이메일,닉네임]>
	 */
	public ApplicationForm(List<List<String>> forms) {
		peopleInfoList = new ArrayList<PeopleInfo>();
		for (List<String> form : forms) {
			peopleInfoList.add(new PeopleInfo(form));
		}

	}

	/**
	 * 닉네임이 유사한 사람들의 이메일 목록을 반환한다.
	 * 
	 * @return 닉네임이 유사한 사람들의 이메일 목록
	 */
	public List<String> getSimilarEmailList() {

		Set<PeopleInfo> similarNicknameIndex = new HashSet<PeopleInfo>();
		similarNicknameIndex = findSimilarNicknameIndex();
		List<String> emailList = indexToEmailList(similarNicknameIndex);

		return emailList;
	}

	/**
	 * 다른 유저의 닉네임과 닉네임이 유사한 유저들의 목록을 반환한다.
	 * 
	 * @return 닉네임이 유사한 사람들 유저들의 목록
	 */
	private Set<PeopleInfo> findSimilarNicknameIndex() {

		Set<PeopleInfo> indexSet = new HashSet<PeopleInfo>();

		for (PeopleInfo peopleInfo : peopleInfoList) {
			String nickName = peopleInfo.nickName;
			for (int i = 1; i < nickName.length(); i++) {
				String comparativeString = Character.toString(nickName.charAt(i - 1))
						+ Character.toString(nickName.charAt(i));
				indexSet.addAll(chcekOtherNickname(peopleInfo, comparativeString));
			}

		}
		return indexSet;
	}

	/**
	 * 유저 목록을 이메일 목록을 변환하여 반환한다.
	 * 
	 * @param 기준 유저, 비교 단어
	 * @return 유저 Set
	 */

	private Set<PeopleInfo> chcekOtherNickname(PeopleInfo target, String comparativeString) {

		Set<PeopleInfo> indexSet = new HashSet<PeopleInfo>();

		for (int j = 0; j < peopleInfoList.size(); j++) {
			PeopleInfo peopleInfo = peopleInfoList.get(j);
			if (!target.equals(peopleInfo) && peopleInfo.nickName.indexOf(comparativeString) != -1) {
				indexSet.add(peopleInfo);
			}
		}

		return indexSet;
	}

	/**
	 * 유저목록을 이메일 목록으로 변환하여 반환한다.
	 * 
	 * @param Set<PeopleInfo>
	 * @return 이메일 목록
	 */
	private static List<String> indexToEmailList(Set<PeopleInfo> similarNicknamePeople) {

		List<String> emailList = new ArrayList<String>();

		for (PeopleInfo peopleInfo : similarNicknamePeople) {
			emailList.add(peopleInfo.email);
		}

		emailSort(emailList);
		return emailList;
	}

	/**
	 * 이메일 목록을 정렬한다.
	 * 
	 * @param 이메일 목록
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

class PeopleInfo {

	int index;
	String email;
	String nickName;

	public PeopleInfo(List<String> form) {
		this.email = form.get(0);
		this.nickName = form.get(1);
	}

	@Override
	public String toString() {
		return "[" + email + ":" + nickName + "]";
	}
}
