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

        Scanner reader = new Scanner(System.in);
        while(true)
        {
            System.out.println("Input 1 to run the first example "+ex1.toString());
            System.out.println("Input 2 to run the first example "+ex1.toString()+" - one step evaluation");
            System.out.println("Input 3 to run the second example "+ex2.toString());
            System.out.println("Input 4 to run the second example "+ex2.toString()+" - one step evaluation");
            System.out.println("Input 5 to run the third example "+ex3.toString());
            System.out.println("Input 6 to run the third example "+ex3.toString()+" - one step evaluation");

            System.out.println("Input 0 to exit");

            System.out.println("Enter a command: ");
            int n = reader.nextInt();
            if (n == 0)
                System.exit(0);
            if (n == 1) {
                try {
                    ctr.allStep();


                } catch (MyControllerException e) {
                    System.out.println(e.getMessage());
                }

            }
            if (n==2)
            {
                try{
                 while(true)
                 {
                     reader.nextLine();
                     System.out.println(ctr.oneStep(ctr.repo.getCrtPrg()));
                 }
                }
                catch (MyControllerException e) {
                    //reader.reset();
                    System.out.println(e.getMessage());
                }

            }
            if (n == 3) {
                try {
                    ctr2.allStep();


                } catch (MyControllerException e) {
                    System.out.println(e.getMessage());
                }

            }
            if (n==4)
            {
                try{
                    while(true)
                    {
                        reader.nextLine();
                        System.out.println(ctr2.oneStep(ctr2.repo.getCrtPrg()));
                    }
                }
                catch (MyControllerException e) {
                    //reader.reset();
                    System.out.println(e.getMessage());
                }

            }
            if (n == 5) {
                try {
                    ctr3.allStep();


                } catch (MyControllerException e) {
                    System.out.println(e.getMessage());
                }

            }
            if (n==6)
            {
                try{
                    while(true)
                    {
                        reader.nextLine();
                        System.out.println(ctr3.oneStep(ctr3.repo.getCrtPrg()));
                    }
                }
                catch (MyControllerException e) {
                    //reader.reset();
                    System.out.println(e.getMessage());
                }

            }

        }

    }

}
