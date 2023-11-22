import java.io.*;
// import java.net.SocketTimeoutException;
// import java.rmi.server.SocketSecurityException;
import java.util.*;

// import javax.sound.sampled.SourceDataLine;
// import javax.swing.plaf.synth.SynthStyle;

class Account {
    static int acc_number = 1111;
    String acc_holder_name;
    int pin;
    double balance;
    int unique_id;
    int a_no;

    void createAcc(){
        a_no=acc_number;
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter account holder's name:");
        String acc_holder_name=inp.nextLine();
        System.out.println("Enter Username:");
        unique_id=inp.nextInt();
        int length_pin=0;
        do{
            System.out.println("Enter secret 4 digit pin:");
            pin=inp.nextInt();
            length_pin=String.valueOf(pin).length();
        }while(length_pin!=4);
        System.out.println("Enter initial deposit amount:");
        balance=inp.nextDouble();
        System.out.println("Congratulations! Your account has been created successfully!");
        System.out.println("Account Details-\n"+ "Account Number-"+a_no+ "\nAccount Holder's Name- "+ acc_holder_name+ "\nBalance- "+ balance + "\nThank You");
        //create a file with the account number
        String fileName=acc_number+ ".txt";
        File file=new File(fileName);
        try{
            file.createNewFile();
            FileWriter writer=new FileWriter(file);
            writer.write( "Account Create\n");
            writer.write( "Account Number: "+ acc_number+"\n");
            writer.write( "User ID-r: "+ unique_id+"\n");
            writer.write( "Account Holder's Name: "+ acc_holder_name+"\n");
            writer.write( "Pin: "+ pin+"\n");
            writer.write( "Balance: "+ balance+ "\n");
            writer.write( "Date: "+ new Date()+"\n\n\n");
            writer.close();   
        }catch(IOException e){
            System.out.println("An error occured while creating a file: "+fileName);
            e.printStackTrace();
        }
        // System.out.println("Thank You For Banking With US!");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    acc_number++;
    }
}

class ATM {
    void withdraw(Account acc){
        Scanner inp=new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Withdraw Money Mode\n");
        System.out.println("Enter Amount In Multiples Of 100- ");
        Double amount=inp.nextDouble();
        if(amount%100==0){
            if(acc.balance>=amount){
                acc.balance-=amount;
                System.out.print("Your Transition is Processing\n");
                try{
                    // Open the text file for appending new transaction
                    String fileName= acc.a_no+".txt";
                    FileWriter fileWriter= new FileWriter(fileName, true);
                    BufferedWriter bufferedWriter=new BufferedWriter( fileWriter);
                    // Write the transaction details to the text file
                    bufferedWriter.write("Date: "+ new Date()+ "\n");
                    bufferedWriter.write("Withdrawal: "+ amount+"\n");
                    bufferedWriter.write("Account Number: "+ acc.a_no+"\n");
                    bufferedWriter.write("Remaining Balance: "+acc.balance+"\n\n");
                    //Close the file writer and buffered writer
                    bufferedWriter.close();
                    fileWriter.close();
                }catch(IOException e){
                     System.out.println("An error occured while writting to the file.");
                     e.printStackTrace();
                }
                System.out.println("Thank You For Banking With Us!");
                try{
                    Thread.sleep(6000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();

            }else{
                System.out.print("Insufficient Funds!");
            }

        }else{
            System.out.println("Amount is not in multiple of 100!");
            System.out.println("Try again!");
        }
    }

void deposit_by_transfer(Account acc, double amount){
    acc.balance += amount;
    try{
        String fileName=acc.a_no+".txt";
        FileWriter fileWriter=new FileWriter(fileName, true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write("Deposit: "+amount+"\n");
        bufferedWriter.write("Date: "+ new Date()+"\n");
        bufferedWriter.write("Account Number: "+acc.a_no+"\n");
        bufferedWriter.write("Remaining Balance: "+ acc.balance+"\n\n");
        bufferedWriter.close();
        fileWriter.close();
    }catch(IOException e){
        System.out.println("An error occcured while writting to the file.");
        e.printStackTrace();
    }

}

void deposit(Account acc){
    Scanner inp=new Scanner(System.in);
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Money Deposit Mode\n");
    System.out.println("Enter amount you want to deposit: ");
    Double amount=inp.nextDouble();
    acc.balance+= amount;
    System.err.print("\033[H\033[2J");
    System.out.flush();
    try{
        String fileName=acc.a_no+".txt";
        System.out.println("The File Name- "+fileName);
        FileWriter fileWriter=new FileWriter(fileName,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write( "Deposit: "+ amount+"\n");
        bufferedWriter.write( "Date: "+ new Date()+"\n");
        bufferedWriter.write( "Account Number: "+acc.a_no+"\n");
        bufferedWriter.write( "Remaining Balance: "+acc.balance+"\n\n");
        bufferedWriter.close();
        fileWriter.close();
    }catch(IOException e){
        System.out.println("An error occured while writting to the file.");
        e.printStackTrace();
    }
    System.out.println("Processing your request. Please wait!");
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Transaction completed successfully!");;
    System.out.println("\n\nThank You For Banking With Us!");
    System.out.println("---Going to Login Page---");
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

void Transfer(Account acc1, Account acc2, double amount){
    if(acc1.balance>=amount){
        acc1.balance-= amount;
        ATM a =new ATM();
        a.deposit_by_transfer(acc2, amount);
        try{
            String fileName=acc1.a_no+".txt";
             FileWriter fileWriter=new FileWriter(fileName,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write( "Transfered "+ amount+"\n");
        bufferedWriter.write( "Date: "+ new Date()+"\n");
        bufferedWriter.write( "Account Number: "+acc1.a_no+"\n");
        bufferedWriter.write("Remaining Balance: "+acc1.balance+"\n\n");
        bufferedWriter.close();
        fileWriter.close();
        }catch(IOException e){
            System.out.println("An error occured while writting to the file.");
            e.printStackTrace();
        }
        System.out.println("Processing Your Request, Please Wait!\n");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();;
        System.out.println("\nAccount Transfer completed successfully!\n---Going to Login Page---");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

void display_details(Account acc){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("Displayinh account details\n");
    try{
        Thread.sleep(2000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    String file_name=String.valueOf(acc.a_no)+".txt";
    File file=new File(file_name);
    try{
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while((line= bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }catch(FileNotFoundException e){
        System.out.println("File not found: "+e.getMessage());

    }catch(IOException e){
        System.out.println("Error reading file: "+ e.getMessage());
    }
    System.out.println("Screen will automatically be timeout after 30 seconds. . .");
    try{
        Thread.sleep( 30000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

    void quit() {
        System.out.print("Thank You For Banking with Us!\n");
        return;
    }
}

class run_atm {
    int accout_search_by_unique_id(Account[] ac, String unique_id) {
        // for (int i; i < 5; i++) {
         for (int i; i < 5; i++) {
            // if (Objects.equals(acc_number, ac[i].a_no))
            if (Objects.equals(acc_number, ac[i].a_no))
                return i;
        }
        return -1;
    }

    int account_search_by_unique_id(Account[] ac, int account_number) {
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(account_number, ac[i].a_no))
                return i;
        }
        return -1;
    }

    void demo(Account[] ac){
        Scanner inp=new Scanner(System.in);
        System.out.print("\n\n\nWelcome to ATM\n");
        System.out.println("\nEnter Your Card/Unique ID");
        int unique_id =inp.nextInt();

        int i=account_search_by_unique_id(ac,unique_id);
        if(i==-1){
            System.out.println("Account not registered Yet!");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return;
        }else{
            System.out.println("Enter Your PIN: ");
            int pin=inp.nextInt();
            if(pin==ac[i].pin){
                System.out.println("Select the Options as Given Below!\nWithdraw---1\nDeposit---2\nAccount Transfer---3\nDisplay Account Details---4\nQuit---5");
                int ch;
                ATM atm=new ATM();
                ch=inp.nextInt();
                switch(ch){
                    case 1 -> atm.withdraw(ac[i]);
                    case 2 ->atm.deposit(ac[i]);
                    case 3 -> {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("Enter account number to transfer funds:");
                        int account_transfer=inp.nextInt();
                        int j= account_search_by_unique_id(ac, account_transfer);
                        if(j==-1){
                            System.out.println("Account not yet Registered!");
                            return;
                        }else{
                            System.out.println("Enter Amount for Transfering Funds: ");
                            double amount= inp.nextDouble();
                            atm.Transfer(ac[i], ac[j], amount);
                        }
                    }
                    case 4 -> atm.display_details(ac[i]);
                    case 5 -> atm.quit();
                }
            }
        else{
            System.out.println("Wrong PIN Entered!\n Try Again!");
            try{
                Thread.sleep( 3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return;
        }
  }
    }
}
public class Main{
    public static void main(String[] args){
        Scanner inp=new Scanner(System.in);
        Account[] ac=new Account[5];
        for(int i=0; i<5;i++){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Creating Account Mode-\n");
            ac[i]=new Account();
            ac[i].createAcc();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        for(; ;){
            Object ob=new Object();
            System.out.print ("\033[H\033[2J");
            System.out.flush();
            ob.demo(ac);
        }
    }
}
