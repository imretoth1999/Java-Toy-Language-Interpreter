package view;
import controller.*;
import repository.*;
import model.*;
import test.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyRepoException{


        Test test = new Test();
        test.start();

        IStmt ex1=new CompStmt(new AssignStmt("v",new ConstExpr(2)), new PrintStmt(new VarExp("v")));
       PrgState prg1 = new PrgState(new MyStack(), new MyDictionary(), new MyList(), ex1);
        IStmt ex2= new CompStmt(new AssignStmt("a", new ArithExp(new ConstExpr(2),new ArithExp(new ConstExpr(3), new ConstExpr(5),3),1)), new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"), new ConstExpr(1),1)), new PrintStmt(new VarExp("b"))));
        IStmt ex3=new CompStmt(new AssignStmt("a", new ArithExp(new ConstExpr(2), new ConstExpr(2),2)), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExpr(2)), new AssignStmt("v", new ConstExpr(3))), new PrintStmt(new VarExp("v"))));
        PrgState prg2 = new PrgState(new MyStack(),new MyDictionary(),new MyList(),ex2);
        PrgState prg3 = new PrgState(new MyStack(),new MyDictionary(),new MyList(),ex3);

        MyIRepo repo1 = new MyRepo(prg1);
//        repo1.addProgram(prg2);
//        repo1.addProgram(prg3);
        MyController ctr = new MyController(repo1);
        MyIRepo repo2 = new MyRepo(prg2);
        MyController ctr2 = new MyController(repo2);
        MyIRepo repo3 = new MyRepo(prg3);
        MyController ctr3 = new MyController(repo3);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.show();
    }

    }


