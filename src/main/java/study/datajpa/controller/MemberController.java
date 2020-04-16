package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.controller.dto.MemberDto;
import study.datajpa.domain.Member;
import study.datajpa.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    // ?page=0&size=3&sort=id,desc&sort=name,desc
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 15) Pageable pageable){
        return memberRepository.findAll(pageable).map(m -> MemberDto.builder().member(m).build());
    }
}
