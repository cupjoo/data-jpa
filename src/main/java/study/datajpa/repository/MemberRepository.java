package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.controller.dto.MemberDto;
import study.datajpa.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameAndAgeGreaterThan(String name, int age);

    @Query("select m from Member m where m.name = :name and m.age = :age")
    List<Member> findUser(@Param("name") String name, @Param("age") int age);

    @Query("select new study.datajpa.controller.dto.MemberDto(m.id, m.name, t.name)" +
            " from Member m join m.team t")
    List<MemberDto> findMemberDto();

    List<Member> findByName(String name);

    @Query("select m from Member m where m.name in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    // Paging
    @Query(value = "select m from Member m",
            countQuery = "select count(m.name) from Member m")
    Page<Member> findByAge(int age, Pageable pageable);

    @Modifying(clearAutomatically = true) // 벌크성 수정, 삭제 쿼리. excuteUpdate()
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);
}
