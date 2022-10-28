package onboarding.problem2;

import java.util.ArrayList;
import java.util.List;

public class CryptogramDecoding {
	String decoded;
	List<DuplicatedRange> duplicatedRangeList;

	public CryptogramDecoding() {
		duplicatedRangeList = new ArrayList<>();
	}

	// 기능1. 암호해독을 한다.
	public String decode(String cryptogram) {
		decoded = cryptogram;
		while (true) {
			findDuplicated(decoded);

			if (duplicatedRangeList.isEmpty()) {
				break;
			}

			deleteDuplicated(decoded);
			duplicatedRangeList.clear();
		}
		return decoded;
	}

	// 기능2. 암호에서 중복되는 글자의 범위를 모두 찾고 리스트에 저장한다.
	// 이 코드 자체를 개선할 방법 찾아보기
	public void findDuplicated(String cryptogram) {
		int i, j;
		int length = cryptogram.length();
		for (i = 0; i < length; i++) {
			for (j = i; j < length; j++) {
				if (cryptogram.charAt(i) == cryptogram.charAt(j)) {
					continue;
				}
				j--;
				break;
			}

			if ((j < length) && (j - i > 0)) {
				duplicatedRangeList.add(new DuplicatedRange(i, j));
			} else if ((i != length - 1) && (j == length)) {
				j--;
				if (cryptogram.charAt(i) == cryptogram.charAt(j)) {
					duplicatedRangeList.add(new DuplicatedRange(i, j));
				}
			}
		}
	}

	// 기능3. 리스트에 있는 범위의 글자를 모두 제거한 후 decoded에 저장한다.
	public void deleteDuplicated(String cryptogram) {
		String processing = "";
		int before = 0;
		for (DuplicatedRange range : duplicatedRangeList) {
			processing += cryptogram.substring(before, range.start);
			before = range.end + 1;
		}
		processing += cryptogram.substring(before);
		decoded = processing;
	}
}
