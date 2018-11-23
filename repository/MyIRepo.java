package repository;

import model.*;


public interface MyIRepo {
    void addProgram(IStmt prg);
    void addProgram(PrgState p);
    PrgState getCrtPrg() throws MyRepoException ;
}