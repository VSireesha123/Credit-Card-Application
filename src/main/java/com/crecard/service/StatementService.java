package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.execption.StatementIdNotFoundException;
import com.crecard.interfaces.IStatementService;
import com.crecard.model.Statement;
import com.crecard.repository.IStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StatementService implements IStatementService {

    @Autowired
    IStatementRepository statementRepository;
    @Override
    public Statement addStatement(Statement statement) {
        return statementRepository.save(statement);
    }

    @Override
    public String removeStatement(long statementId) {
    	if(statementRepository.existsById(statementId)) {
    		statementRepository.deleteById(statementId);
    		return "Deleted successfully."+statementId;
    	}
    	else {
    		throw new StatementIdNotFoundException("Delete is not done with this id."+statementId);
    	}
        /*Statement statement =getStatement(id);
        statementRepository.deleteStatementByStatementId(id);
        return  statement;*/
    }

    @Override
    public String updateStatement(long id, Statement statement) {
    	 if(statementRepository.existsById(id)) {
             Statement sta=statementRepository.save(statement);
             return "Update statement Successfully for "+sta.getStatementId();
         }
         else {
             throw new StatementIdNotFoundException("No statement is found with to update");
         }
        //return statementRepository.save(statement);
    }

    @Override
    public Statement getStatement(long id) {
        Optional<Statement> statement = statementRepository.findById(id);
        return statement.orElseThrow(()-> new CustomException("Statement Not Exists with id :"+id));
    }

    @Override
    public List<Statement> getAllStatements() {
        return statementRepository.findAll();
    }

    @Override
    public List<Statement> getBilledStatement() {
        return statementRepository.getBilledStatements(LocalDate.now());
    }


    @Override
    public List<Statement> getUnBilledStatement(){
        return statementRepository.getUnBilledStatements(LocalDate.now());
    }

    @Override
    public List<Statement> getCustomerStatements(long id) {
        return statementRepository.findAllByCustomerId(id);
    }

}
