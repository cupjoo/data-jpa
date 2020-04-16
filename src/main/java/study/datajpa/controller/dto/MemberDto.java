package study.datajpa.controller.dto;

import lombok.Builder;
import lombok.Getter;
import study.datajpa.domain.Member;

@Getter
public class MemberDto {

    private Long id;
    private String userName;
    private String teamName;

    @Builder
    public MemberDto(Long id, String userName, String teamName){
        this.id = id;
        this.userName = userName;
        this.teamName = teamName;
    }

    @Builder
    public MemberDto(Member member){
        this.id = member.getId();
        this.userName = member.getName();
        this.teamName = member.getTeam().getName();
    }
}
