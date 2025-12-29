import java.util.Scanner;
interface Atmmachine{
    void details();
    void balancenquiry();
    void cashdeposit();
    void cashwithdrawal();
    void forgetpin();
    void exit();
    
}
abstract class insertcard implements Atmmachine{
   int orpin = 2865;
   private int pin;
   Scanner ob = new Scanner(System.in);
   public void details(){
       System.out.println("we to our service \n please insert your card \n please Enter your pin");
       for(int i = 1 ; i<=3 ; i++ ){
        setpin(ob.nextInt()); 
        
        if(pin == orpin){
            System.out.println("verified");
            break;
        }
        else if (i==3){
            System.out.println("Account locked , contact Branch");
            System.exit(0);
        }
        else{
            System.out.println("wrong pin, please try again");
        }
       }
       String arr[] = {"1. Balanceenquiry",
                        "2. cashwithdrawal",
                        "3. forget pin",  
                        "4. cash deposit",
                        "5. exit " };
       for (String s : arr){
        System.out.printf("%-20s%n" , s);
       }
       int n = ob.nextInt();
       switch(n){
         case 1 : balancenquiry();break;
         case 2 : cashwithdrawal();break;
         case 3 : forgetpin();break;
         case 4 : cashdeposit();break;
         case 5 : exit();break;
       }
    }
    public void setpin(int p){
        pin = p;
        return;
    }
}
class ATMservice extends insertcard{
    
    private double balance = 20_000;
    Scanner ob = new Scanner(System.in);
    public void cashdeposit(){
        System.out.println("Please Enter your amount ");
        double ba = ob.nextInt();
        System.out.println( ba + "Amount  deposited in your a/c");
        System.out.println("do you want to print receipt \t (y/n)");
        char c = ob.next().charAt(0);
        if(c == 'y'){
            balance += ba;
            System.out.println("Account balance : " + balance);
        }
        else{
            System.out.println("thank you");
        }

    }
    public void balancenquiry(){
        System.out.println( "your current savings bank account balance :" +balance);
    }
    public void cashwithdrawal(){
        System.out.println("Enter your amount");
        double cd = ob.nextInt();
        System.out.println();
        System.out.println("please wait your transaction has beed processed. \nplease collect your cash.");
        double balane = ( balance - cd);
        System.out.println("do you want to print receipt ? \t (y/n)");
        char c = ob.next().charAt(0);
        if(c == 'y'){
            System.out.println("current balance :" +balane);
        }
        else{
            System.out.println("Thank you !");
        }
    }
    public void forgetpin(){
        System.out.println("Enter your  15-digits A/C no: ");
        String ac = ob.nextLine();
        if(ac.length() == 15 ){
            System.out.println("your a/c no:" + ac);
            System.out.println("Account Holder Name : Sumitbalan G");
        }
        else{
            System.out.println("check your account number");
        }
        System.out.println("Enter your otp :");
        String otp = ob.nextLine();
        if(otp.length() == 4){
            System.out.println("OTP verified");
        }
        else{
            System.out.println("OTP Not verified");
        }
        System.out.println("OTP verified \n Set your 4-digit pin :");
        int spin = ob.nextInt();
        System.out.println("Re-enter your pin");
        int rpin = ob.nextInt();
       if(spin == rpin ){
        System.out.println("pin updated successfully");
        orpin = rpin;
        }
       else{
         System.out.println("PIN number not matches, Try again");
       }
       System.out.println("check once again,insert your card for verification");
       details();

    }
    public void exit(){
        System.exit(0);
    }
    
}

public class ATM{
 public static void main(String[] args) {
    ATMservice atm = new ATMservice();
    atm.details();
   
 }
}



