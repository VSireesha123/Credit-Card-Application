package com.crecard.repository;

import com.crecard.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IStatementRepository extends JpaRepository<Statement,Long> {
    void deleteStatementByStatementId(long statementId);

    List<Statement> findAllByCustomerId(long id);

    @Query(value = "Select * from statement  where  Date(billing_date) <=:billingDate ",nativeQuery = true)
    List<Statement> getBilledStatements(@Param("billingDate") LocalDate billingDate);

    @Query(value = "Select *  from statement  where  Date(billing_date) >=:billingDate ",nativeQuery = true)
    List<Statement> getUnBilledStatements(@Param("billingDate") LocalDate billingDate);

    Statement findFirstByCustomerId(long id);


}
