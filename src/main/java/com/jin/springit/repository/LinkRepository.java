package com.jin.springit.repository;

import com.jin.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
