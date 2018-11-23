package repository;

import model.*;

public class MyRepo implements MyIRepo {

    MyIList<PrgState> programs;

    public MyRepo(PrgState p) throws MyRepoException {
        programs = new MyList<PrgState>();
        programs.add(p);
    }

    public void addProgram(IStmt prg){
        MyIStack<IStmt> stk = new MyStack<IStmt>();
        MyIDictionary<String,Integer> symtbl = new MyDictionary<String,Integer>();
        MyIList<Integer> out = new MyList<Integer>();
        programs.add(new PrgState(stk,symtbl, out,prg));
    }

    public void addProgram(PrgState p){
        programs.add(p);
    }
    @Override
    public PrgState getCrtPrg() throws MyRepoException{
        try {
            return programs.get(0);
        } catch (MyDataException e) {
            throw new MyRepoException("There is no program!");
        }
    }



}
