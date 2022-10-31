package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PageNumTest {
	@Test
	public void 잘못된_페이지_에러_테스트() {
		assertThatThrownBy(() -> {
			PageNum pageNum = new PageNum(1);})
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			PageNum pageNum = new PageNum(400);})
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 각_자리수_리스트_매퍼_테스트() {
	    //given
		PageNum pageNum = new PageNum(123);
		//when
		List<Integer> eachNumbers = pageNum.mapPageNumToList();
		//then
		assertThat(Arrays.asList(3, 2, 1)).isEqualTo(eachNumbers);
	}

	@Test
	public void 페이지_각_자리수_더하기() {
	    //given
		PageNum pageNum = new PageNum(123);
		PageNum pageNum2 = new PageNum(345);
	    //when
		int addPage = pageNum.addEachPageNumber();
		int addPage2 = pageNum2.addEachPageNumber();
	    //then
		assertThat(6).isEqualTo(addPage);
		assertThat(12).isEqualTo(addPage2);
	}
}
