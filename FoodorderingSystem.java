import java.util.Scanner;
import java.util.ArrayList;

interface foodsys{
  
     void details();

  }
class shopy implements foodsys{
    int lpass,opass = 2005;
    private int password;
    Scanner ob = new Scanner(System.in);
    public void details(){
        System.out.println("===================================");
        System.out.printf("%-15s", "WELCOME TO FOOD HUB");
        System.out.println();
        System.out.println("===================================");
        for(int i = 1; i<=3;i++){
            if(i==1)System.out.println("1. Login");
            if(i==2)System.out.println("2. Register");
            if(i==3)System.out.println("3. Exit");
        }
        System.out.println("Enter your choice:");
        int n = ob.nextInt();
        switch(n){
            case 1 : Login();break;
            case 2 : Register();break;
            case 3 : Exit();break;
        }

    }
    public void setpassword(){
        int ps = ob.nextInt();
        password = ps;
    }
    public void Login(){
        opass = lpass;
        ob.nextLine();
        System.out.println("Enter Username :");
        String us = ob.nextLine();
        System.out.println("Login name : "+us);
        System.out.println("Enter password :");
        for(int i =1;i<=3;i++){
            setpassword();
            if(password == opass){
                System.out.println("Login Successfull");
                System.out.println("--------------------------------");
                return;
            
            }
            else if( i==3){
                System.exit(0);
            }
            else{
                System.out.println("Please Try again!!");
            }
        }
    }
    public void Exit(){
        System.exit(0);
    }
    public void Register(){
        ob.nextLine();
        System.out.println("Enter your Name :");
        String nus = ob.nextLine();
        System.out.println("Username: "+nus);
        System.out.println("Enter Mobile number");
        String nm = ob.nextLine();
        if(nm.length() == 10){
            System.out.println("Enter OTP:");
            String otp = ob.nextLine();
            if(otp.length()==4){
                System.out.println("verified successfull");
            }
            
            System.out.println("Enter your new password:");
            int newpass = ob.nextInt();
            System.out.println("Re-Enter your password:");
            int repass = ob.nextInt();
            lpass = repass;
            if(newpass == repass){
                System.out.println("Register Successfull!!");
                
            }
            else{
                System.out.println("Please Try Again!");
                System.exit(0);
            }
            
        
         
        }
        Login();
    }
}
class fooditems extends shopy {
    Scanner ob = new Scanner(System.in);
    int odn,q,rpizza,rBurger,rDosa,rfriedrice,total=0,aq,cq,dq,oq;
    ArrayList<Integer> choices = new ArrayList<>();
    int i;
    public void menu(){
        System.out.println("============MENU===========");
        String[] items ={"1. Pizza","2. Burger","3. FriedRice", "4. Dosa"};
        int[] price ={250,150,120,80};
        System.out.printf("%-10s%-5s%n","Items","price");
        for(int i =0; i < items.length; i++){
            System.out.printf("%-10s₹%-5d%n",items[i],price[i]);
            System.out.println();
        }
        String ch;
        System.out.println();
        for(i =0 ; i <=choices.size() ;i++){
                System.out.println("Enter your number to order:");
                choices.add(ob.nextInt());
         switch(choices.get(i)){
                case 1 : pizza();System.out.println("Pizza added to the cart");
                break;
                case 2 : Burger();System.out.println("Burger added to the cart");
                break;
                case 3 : FriedRice();System.out.println("FriedRice added to the cart");
                break;
                case 4 : Dosa();System.out.println("Dosa added to the cart");
                break;
             }
             System.out.println("do you want to order more(yes/no)");
             ch = ob.next();
             if(ch.equals("yes")){
                continue;
             }
             else{
                break;
             }

            }
    


        
      
    }
    public void pizza(){
        System.out.println("Enter the no of quantity:");
        q = ob.nextInt();
        dq=q;
        rpizza = q * 250;
        total += rpizza;
    }
    public void Burger(){
        System.out.println("Enter the no of quantity");
        q = ob.nextInt();
        cq=q;
        rBurger =q * 150;
        total += rBurger;
    }
    public void Dosa(){
        System.out.println("Enter the no of quantity");
        q = ob.nextInt();
        aq=q;
        rDosa = q * 80;
        total += rDosa;
       
    }
    public void FriedRice(){
        System.out.println("Enter the no of quantity");
        q = ob.nextInt();
        oq=q;
        rfriedrice =q * 120;
        total +=rfriedrice;
    }

   public void cartdetails(){
     System.out.println("----------------------------");
     System.out.printf("%-15s","CartDetails");
     System.out.println();
     System.out.println("----------------------------");
     System.out.println();
     System.out.printf("%-10s%-5s%-5s","Item","qty","price");
     System.out.println();
     for(int choice : choices){

     
      switch(choice){
        case 1:
            System.out.printf("%-10s%-5s%-5s%n","Pizza",dq ,rpizza);
            break;
        case 2 :
            System.out.printf("%-10s%-5s%-5s%n","Burger",cq,rBurger);
            break;
        case 3 :
            System.out.printf("%-10s%-5s%-5s%n","FriedRice",aq,rfriedrice);
            break;
        case 4 :
            System.out.printf("%-10s%-5s%-5s%n","Dosa",oq,rDosa);
            break;

        }
     }
     System.out.println();
     System.out.println("----------------------------------");
     System.out.println("Total Amount : " +total);
     System.out.println();
    }

}

class paymentm extends fooditems{
    public void payment(){
        System.out.println("Choose Payment Method");
        System.out.println("1. Cash on Delivery\n2. UPI \n3. Netbanking ");
        System.out.println("Enter your choice");
        int ch = ob.nextInt();
        switch(ch){
            case 1:
                 System.out.println("Successfull");
                 break;
            case 2 :

                 System.out.println("Processing payment.....");
                 System.out.println("payment successfull !!");
                 break;
            case 3 :
                 System.out.println("choose bank for payment");
                 System.out.println("1. IndianBank\n2. IOB\n3. SBI\n4.otherbanks");
                 int pch = ob.nextInt();
                 if(pch ==1 | pch==2 | pch==3)System.out.println("Payment successfull!!");
                 if(pch==4){
                    System.out.println("Enter your bank here:");
                    String s = ob.nextLine();
                    System.out.println( "Payment successfull form  this"+ s+ "bank");
                 }
        }
        System.out.println("---------------------------------------");
        System.out.printf("%-10s","ORDER CONFRIMED !!");
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Thankyou for ordering with foodHub");

       

    }
}

public class FoodorderingSystem{
    public static void main(String[] args) {
       shopy s = new shopy();
       s.details();
       fooditems f = new fooditems();
       f.menu();
       f.cartdetails();
       paymentm p = new paymentm();
       p.payment();

    }
}
