package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import onboarding.Problem7.InMemoryDB;
import onboarding.Problem7.Member;

public class InMemoryDBTest {

	@Nested
	class InsertIfAbsentAndQueryMember {

		@Test
		void memberIsAbsentInDB_GetMember() throws Exception {
			// given
			final String username = "a";

			// when
			final Member member = InMemoryDB.insertIfAbsentAndQueryMember(username);

			// then
			assertThat(member).isNotNull();
			assertThat(member.getUsername()).isEqualTo(username);
		}

		@Test
		void memberIsPresentInDB_GetMemberAndEqualEachOther() throws Exception {
			// given
			final String username = "a";
			final Member member1 = InMemoryDB.insertIfAbsentAndQueryMember(username);

			// when
			final Member member2 = InMemoryDB.insertIfAbsentAndQueryMember(username);

			// then
			assertThat(member1).isEqualTo(member2);
		}

	}

	@Nested
	class QueryTop5FriendReferralList {

		@Test
		void case1() throws Exception {
			// given
			final Member mrko = InMemoryDB.insertIfAbsentAndQueryMember("mrko");
			final Member donut = InMemoryDB.insertIfAbsentAndQueryMember("donut");
			final Member andole = InMemoryDB.insertIfAbsentAndQueryMember("andole");
			final Member jun = InMemoryDB.insertIfAbsentAndQueryMember("jun");
			final Member shakevan = InMemoryDB.insertIfAbsentAndQueryMember("shakevan");
			final Member bedi = InMemoryDB.insertIfAbsentAndQueryMember("bedi");

			donut.friend(andole);
			donut.friend(jun);
			donut.friend(mrko);
			shakevan.friend(andole);
			shakevan.friend(jun);
			shakevan.friend(mrko);

			bedi.visit(mrko);
			bedi.visit(mrko);
			donut.visit(mrko);
			bedi.visit(mrko);
			shakevan.visit(mrko);

			final List<String> expected = Stream.of(andole, jun, bedi)
				.map(Member::getUsername)
				.collect(Collectors.toList());
			// when
			final List<String> top5FriendReferralList = InMemoryDB.queryTop5FriendReferralList(mrko.getUsername());

			// then
			assertThat(top5FriendReferralList).isEqualTo(expected);
		}

	}

}
