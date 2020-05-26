package com.block.chain.news.domain.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByTitle(String title);

}
