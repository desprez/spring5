package com.training.sample.springboothellorest.repository;

import com.training.sample.springboothellorest.domaine.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
