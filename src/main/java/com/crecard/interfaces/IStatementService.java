package com.crecard.interfaces;


import com.crecard.model.Statement;

import java.time.LocalDate;
import java.util.List;

public interface IStatementService {
    public Statement addStatement(Statement statement);
    public Statement removeStatement(long id);
    public Statement updateStatement(long id,Statement statement);
    public Statement getStatement(long id);
    public List<Statement>  getAllStatements();
    public List<Statement> getBilledStatement();
    public List<Statement> getUnBilledStatement();

    public List<Statement> getCustomerStatements(long id);


}
