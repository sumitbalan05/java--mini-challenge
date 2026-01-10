import java.util.Scanner;

interface order{
    abstract class onlineorder{
        abstract void details();
    }
}
    class amazon implements order{
        public void details(){
            System.out.println("Welcome to amazon platform");
            System.out.println("Enter your login name and password : ");
        }
    
    
        private int password;
        String login;
        public void setpassword(int lp){
             password = lp;
        }
    
        public void loginsystem(String login){
            System.out.println("Enter your login name");
            System.out.println("loginname:" +login);
            System.out.println("Enter your password :");
            Scanner ob = new Scanner(System.in);
            for(int i = 1 ; i<=3 ; i++){
             setpassword(ob.nextInt());
             if (password == 2025){
                System.out.println("congrats!! you're successfully verifed with your crendentials");
                break;
             }
             else if(i==3){
                System.exit(0);
             }
             else{
                System.out.println("please try again ");
                System.out.println("you have only "  + (3-i) + " attemps more ");

               
             }
             
            }
        }
        
        public void additems(){
         System.out.println("there are some list of items ");
            for(int i = 1 ; i<=5 ; i++){
                if(i==1) System.out.println(i + ".  washing liquid");
                if(i==2) System.out.println(i + ".  watches");
                if(i==3) System.out.println(i + ".  flower decor");
                if(i==4) System.out.println(i + ".  A4 sheets");
                if(i==5) System.out.println(i + ".  silver plates with flower design");

            }
            System.out.println("how many items have you added to the cart");
            Scanner ob = new Scanner(System.in);
                int cd = ob.nextInt();
            System.out.println("what are they from the above list of items");
            ob.nextLine();
            for (int i = 1 ; i<=cd; i++){
                String items = ob.nextLine();
                System.out.println(items + " are added to the cart");

            }
        }


    }
   
    class payment implements order {
        public void paymethod(){
            System.out.println("there are two type of payment method \n 1. cash on delivery \n 2.online banking");
            System.out.println("choose your payment method");
            Scanner ob = new Scanner (System.in);
            String pm = ob.nextLine();
            if(pm.equals("cash on delivery")){
             System.out.println("ok your product has been deliverd with in three days");
             System.out.println("Thankyou for shopping on Amazon");

            }
            else if(pm.equals("online banking")){
                System.out.println("choose your payment method \n 1.upi \n 2.net banking \n 3.amazon balance");
                String sb = ob.nextLine();
                if(sb.equals("upi")){
                    System.out.println("using upi code or Qr code to checkout your products");
                    System.out.println("Thankyou for shopping on Amazon");
                }
                else if(sb.equals("net banking")){
                    System.out.println(" use any type of bank to checkout your products");
                    System.out.println("Thankyou for shopping on Amazon");
                }
                else{
                    System.out.println("using amazon balance to checkout your products");
                    System.out.println("Thankyou for shopping on Amazon");
                } 
            } 
                

                
                

        }
    }
    class flipkart  implements order{
        public void details(){
            System.out.println("welcome to flipkart platform");
            System.out.println("Enter your login name ");
        }
        private int password;
        String login;
        public void setpassword(int fp){
            password = fp;
        }
        public void loginsystem(String login){
          System.out.println("login name :" + login);
          System.out.println("Enter your password ");
          Scanner ob = new Scanner (System.in);
          for(int i = 1 ; i<=3; i++){
            setpassword(ob.nextInt());

            if(password == 2026){
                System.out.println("congrats!!, you're successfully login to  your flipkart account");
                additems();
            }
            else if(i==3){
                System.exit(0);
            }
            else{
                System.out.println("please try again");
                System.out.println("you have only " +(3-i) +" more");
            }

          }
        }
        public void additems(){
            System.out.println("there are some essentials items such as :");
            for (int i = 1 ; i<=5; i++){
                if(i==1) System.out.println("1. Boult neo air pods \t price : Rs.899");
                if(i==2) System.out.println("2. Himalaya charcoal facewash \t price: Rs.249");
                if(i==3) System.out.println("3. Fastrack smart watche model 122 \t price: Rs.1249");
                if(i==4) System.out.println("4. Skybags 1.5L  \t price: Rs.599");
                if(i==5) System.out.println("5. mobile stand \t price: Rs.359");
                
            }
            System.out.println("Enter the no of items to added in your carts");
            Scanner ob = new Scanner (System.in);
            int r = ob.nextInt();
            for(int i = 0 ; i<=r ; i++){
                String s = ob.nextLine();
                System.out.println(s + "item are added to your cart");
            }
            

        }
        
    }
    class Flipkartpayment implements order{
        public void paymethod(){
            System.out.println("there are two type of payment method \n 1. cash on delivery \n 2.online banking");
            System.out.println("choose your payment method name ");
            Scanner ob = new Scanner (System.in);
            String pm = ob.nextLine();
            if(pm.equals("cash on delivery")){
             System.out.println("ok your product has been deliverd with in three days");
             System.out.println("Thankyou for shopping on flipkart");

            }
            else if(pm.equals("online banking")){
                System.out.println("choose your payment method \n 1.upi \n 2.net banking \n 3.amazon balance ");
                String sb = ob.nextLine();
                if(sb.equals("upi")){
                    System.out.println("using upi code or Qr code to checkout your products");
                    System.out.println("Thankyou for shopping on flipkart");
                }
                else if(sb.equals("net banking")){
                    System.out.println(" use any type of bank to checkout your products");
                    System.out.println("Thankyou for shopping on flipkart");
                }
                else{
                    System.out.println("using flipkart balance to checkout your products");
                    System.out.println("Thankyou for shopping on flipkart");
                } 
            } 

    }  }





public class Onlineshopping{
    public static void main(String[] args) {
        order or;
        System.out.println("which online platform would you choose: \n 1.Amazon \n 2.flipkart");
        System.out.println("Enter the platform name here:");
        System.out.println();
        Scanner ob = new Scanner(System.in);
        String op = ob.nextLine();
        if(op.equals("amazon")){
        amazon a = new amazon();
        a.details();
        Scanner c = new Scanner(System.in);
        a.loginsystem(c.nextLine());
        a.additems();
        payment p = new payment();
        p.paymethod();
        }
        else{
          flipkart f = new flipkart();
          f.details();
          Scanner fc = new Scanner(System.in);
          f.loginsystem(fc.nextLine());
          f.additems();
          Flipkartpayment fkp = new Flipkartpayment();
          fkp.paymethod();

        }
    
        
        
      

    }

}



