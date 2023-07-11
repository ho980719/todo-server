package com.ho.todoserver.member.repository;

import com.ho.todoserver.member.dto.MemberDto;
import com.ho.todoserver.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Long countByLoginId(String loginId);

    Optional<MemberDto> findByLoginIdAndPassword(String loginId, String password);
}
