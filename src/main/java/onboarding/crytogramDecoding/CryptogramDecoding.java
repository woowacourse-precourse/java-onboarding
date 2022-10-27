package onboarding.crytogramDecoding;

import java.util.ArrayList;
import java.util.List;

public class CryptogramDecoding {
	String decoded;
	List<DuplicatedRange> duplicatedRanges;

	public CryptogramDecoding() {
		duplicatedRanges = new ArrayList<>();
	}

	// 기능1. 암호해독을 한다.
	public void decode(String cryptogram) {
		findDuplicated(cryptogram);
		for (DuplicatedRange elem : duplicatedRanges) {
			System.out.println("(" + elem.start + ", " + elem.end + ")");
		}
	}

	// 기능2. 암호에서 중복되는 글자의 범위를 모두 찾고 리스트에 저장한다.
	public void findDuplicated(String cryptogram) {
		int i, j;
		for (i = 0; i < cryptogram.length(); i++) {
			for (j = i; j < cryptogram.length(); j++) {
				if (cryptogram.charAt(i) == cryptogram.charAt(j)) {
					continue;
				}
				j--;
				break;
			}

			if ((j != cryptogram.length()) && (j - i > 0)) {
				duplicatedRanges.add(new DuplicatedRange(i, j));
			}
		}
	}

	public void deleteDuplicated(String cryptogram) {

	}
}
