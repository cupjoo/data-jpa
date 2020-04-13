package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.controller.dto.MemberDto;
import study.datajpa.domain.Member;
import study.datajpa.domain.Team;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void testMember() {
        Member member = Member.builder().name("memberA").build();
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getName(), member.getName());
        assertEquals(findMember, member);
    }

    @Test
    public void basicCRUD() {
        Member member1 = Member.builder().name("member1").age(10).build();
        Member member2 = Member.builder().name("member2").age(15).build();
        memberRepository.save(member1);
        memberRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertEquals(findMember1, member1);
        assertEquals(findMember2, member2);

        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        assertEquals(all.size(), 2);

        //카운트 검증
        long count = memberRepository.count();
        assertEquals(count, 2);

        //삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);
        long deletedCount = memberRepository.count();
        assertEquals(deletedCount, 0);
    }

    @Test
    public void findByNameAndAgeGreaterThan(){
        Member m1 = Member.builder().name("AAA").age(10).build();
        Member m2 = Member.builder().name("AAA").age(20).build();
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByNameAndAgeGreaterThan("AAA", 15);

        assertEquals(result.get(0).getName(), "AAA");
        assertEquals(result.get(0).getAge(), 20);
        assertEquals(result.size(), 1);
    }

    @Test
    public void findMemberDto(){
        Team team = Team.builder().name("teamA").build();
        teamRepository.save(team);
        Member m1 = Member.builder().name("AAA").age(10).build();
        m1.changeTeam(team);
        memberRepository.save(m1);

        List<MemberDto> memberDtos = memberRepository.findMemberDto();
        assertEquals(memberDtos.get(0).getUserName(), m1.getName());
    }

    @Test
    public void paging(){
        for(int i = 1; i <= 5; i++){
            memberRepository.save(Member.builder().name("m"+i).age(10).build());
        }
        int age = 10, offset = 0, limit = 3;
        List<Member> members = new ArrayList<>();
        long totalCount = 0;

        assertEquals(members.size(), 3);
        assertEquals(totalCount, 5);
    }
}