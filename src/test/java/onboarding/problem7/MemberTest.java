package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem7.Member;

public class MemberTest {

	@Nested
	class AddScore {

		@Test
		void memberScoreIs0AndAddScore5_ToBe5() throws Exception {
			// given
			final Member user = Member.of("user");

			// when
			user.addScore(5);

			// then
			assertThat(user.getFriendReferralScore()).isEqualTo(5);
		}

	}

	@Nested
	class InitScore {

		@Test
		void memberScoreIs1_ToBe0() throws Exception {
			// given
			final Member user = Member.of("user");
			user.addScore(1);

			// when
			user.initScore();

			// then
			assertThat(user.getFriendReferralScore()).isEqualTo(0);
		}

	}

	@Nested
	class Friend {

		@Test
		void aFriendsB_EachHasFriend() throws Exception {
			// given
			final Member a = Member.of("A");
			final Member b = Member.of("B");

			// when
			a.friend(b);

			// then
			assertThat(a.getFriends().size()).isEqualTo(1);
			assertThat(b.getFriends().size()).isEqualTo(1);
		}

	}

	@Nested
	class Visit {

		@Test
		void aVisitsBOnce_VisitCountIs1() throws Exception {
			// given
			final Member a = Member.of("A");
			final Member b = Member.of("B");

			// when
			a.visit(b);

			// then
			assertThat(b.getVisitors().get(a)).isEqualTo(1);
		}

		@Test
		void aVisitsBTwice_VisitCountIs2() throws Exception {
			// given
			final Member a = Member.of("A");
			final Member b = Member.of("B");

			// when
			a.visit(b);
			a.visit(b);

			// then
			assertThat(b.getVisitors().get(a)).isEqualTo(2);
		}

	}

}
