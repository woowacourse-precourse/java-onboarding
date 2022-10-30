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
			final InMemoryDB inMemoryDB = InMemoryDB.of();
			final String username = "a";

			// when
			final Member member = inMemoryDB.insertIfAbsentAndQueryMember(username);

			// then
			assertThat(member).isNotNull();
			assertThat(member.getUsername()).isEqualTo(username);
		}

		@Test
		void memberIsPresentInDB_GetMemberAndEqualEachOther() throws Exception {
			// given
			final InMemoryDB inMemoryDB = InMemoryDB.of();
			final String username = "a";
			final Member member1 = inMemoryDB.insertIfAbsentAndQueryMember(username);

			// when
			final Member member2 = inMemoryDB.insertIfAbsentAndQueryMember(username);

			// then
			assertThat(member1).isEqualTo(member2);
		}

	}

	@Nested
	class QueryTop5FriendReferralList {

		@Test
		void case1() throws Exception {
			// given
			final InMemoryDB inMemoryDB = InMemoryDB.of();
			final Member mrko = inMemoryDB.insertIfAbsentAndQueryMember("mrko");
			final Member donut = inMemoryDB.insertIfAbsentAndQueryMember("donut");
			final Member andole = inMemoryDB.insertIfAbsentAndQueryMember("andole");
			final Member jun = inMemoryDB.insertIfAbsentAndQueryMember("jun");
			final Member shakevan = inMemoryDB.insertIfAbsentAndQueryMember("shakevan");
			final Member bedi = inMemoryDB.insertIfAbsentAndQueryMember("bedi");

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
			final List<String> top5FriendReferralList = inMemoryDB.queryTop5FriendReferralList(mrko.getUsername());

			// then
			assertThat(top5FriendReferralList).isEqualTo(expected);
		}

		@Test
		void case2() throws Exception {
			// given
			final InMemoryDB inMemoryDB = InMemoryDB.of();
			final Member hello = inMemoryDB.insertIfAbsentAndQueryMember("hello");
			final Member mrko = inMemoryDB.insertIfAbsentAndQueryMember("mrko");
			final Member donut = inMemoryDB.insertIfAbsentAndQueryMember("donut");
			final Member andole = inMemoryDB.insertIfAbsentAndQueryMember("andole");
			final Member jun = inMemoryDB.insertIfAbsentAndQueryMember("jun");
			final Member shakevan = inMemoryDB.insertIfAbsentAndQueryMember("shakevan");
			final Member bedi = inMemoryDB.insertIfAbsentAndQueryMember("bedi");
			final Member kane = inMemoryDB.insertIfAbsentAndQueryMember("kane");
			final Member sam = inMemoryDB.insertIfAbsentAndQueryMember("sam");
			final Member anne = inMemoryDB.insertIfAbsentAndQueryMember("anne");

			andole.friend(jun);
			andole.friend(bedi);
			jun.friend(shakevan);
			jun.friend(kane);
			jun.friend(sam);
			bedi.friend(shakevan);
			bedi.friend(anne);
			bedi.friend(sam);
			anne.friend(mrko);

			donut.visit(hello);
			anne.visit(hello);
			mrko.visit(hello);
			mrko.visit(hello);
			sam.visit(hello);

			final List<String> expected = Stream.of(mrko, anne, donut, sam)
				.map(Member::getUsername)
				.collect(Collectors.toList());

			// when
			final List<String> top5FriendReferralList = inMemoryDB.queryTop5FriendReferralList(hello.getUsername());

			// then
			assertThat(top5FriendReferralList).isEqualTo(expected);
		}

		@Test
		void case3() throws Exception {
			// given
			final InMemoryDB inMemoryDB = InMemoryDB.of();
			final Member andole = inMemoryDB.insertIfAbsentAndQueryMember("andole");
			final Member jun = inMemoryDB.insertIfAbsentAndQueryMember("jun");
			final Member donut = inMemoryDB.insertIfAbsentAndQueryMember("donut");
			final Member shakevan = inMemoryDB.insertIfAbsentAndQueryMember("shakevan");
			final Member bedi = inMemoryDB.insertIfAbsentAndQueryMember("bedi");
			final Member anne = inMemoryDB.insertIfAbsentAndQueryMember("anne");
			final Member mrko = inMemoryDB.insertIfAbsentAndQueryMember("mrko");
			final Member peter = inMemoryDB.insertIfAbsentAndQueryMember("peter");
			final Member sam = inMemoryDB.insertIfAbsentAndQueryMember("sam");

			andole.friend(jun);
			donut.friend(jun);
			donut.friend(shakevan);
			shakevan.friend(andole);
			shakevan.friend(jun);
			shakevan.friend(bedi);
			anne.friend(jun);

			donut.visit(andole);
			mrko.visit(andole);
			peter.visit(andole);
			sam.visit(andole);

			final List<String> expected = Stream.of(donut, anne, bedi, mrko, peter)
				.map(Member::getUsername)
				.collect(Collectors.toList());

			// when
			final List<String> top5FriendReferralList = inMemoryDB.queryTop5FriendReferralList(andole.getUsername());

			// then
			assertThat(top5FriendReferralList).isEqualTo(expected);
		}

	}

}
