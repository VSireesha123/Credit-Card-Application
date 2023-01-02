package com.crecard.repository;

import com.crecard.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StatementRepository extends JpaRepository<Statement,Long> {
    Statement deleteStatementByStatementId(long statementId);

    List<Statement> findAllByCustomerId(long id);

    @Query(value = "Select * from statement  where  Date(billing_date) >=:billingDate ",nativeQuery = true)
    List<Statement> getBilledStatements(@Param("billingDate") LocalDate billingDate);

    @Query(value = "Select * statement from  where  Date(billing_date) <=:billingDate ",nativeQuery = true)
    List<Statement> getUnBilledStatements(@Param("billingDate") LocalDate billingDate);

    Statement findFirstByCustomerId(long id);


}
