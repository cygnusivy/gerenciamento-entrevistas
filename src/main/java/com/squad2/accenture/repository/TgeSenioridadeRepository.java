package com.squad2.accenture.repository;

import com.squad2.accenture.model.TgeSenioridadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgeSenioridadeRepository extends JpaRepository<TgeSenioridadeModel, Integer> {
}
