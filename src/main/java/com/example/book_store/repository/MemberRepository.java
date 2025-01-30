package com.example.book_store.repository;

import com.example.book_store.model.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @EntityGraph(attributePaths = "borrowBooks", value = "borrowedBooks.book")
    @Query("from Member where id=:member_id")
    Member findByMemberId(@Param("member_id") Long member_id);
}
