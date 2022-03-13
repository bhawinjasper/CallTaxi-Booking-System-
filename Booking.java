import java.util.Scanner;

public class Booking {
    static int cid=0;
     String  picl;
     String drl;
     int pickt;
     int cuid;
     int amount;
     int kms;
     int drt;
     static String pl="ABCDEF";
     Booking(String pl,String dl,int pt){
         this.picl=pl;
         this.drl=dl;
         this.pickt=pt;
         cid+=1;
         cuid=cid;
         this.kms=(int)Math.abs(this.pl.indexOf(pl)-this.pl.indexOf(dl));
         this.kms*=15;
         this.amount=100+(this.kms-5)*10;
         this.drt=pt+(int)Math.abs(this.pl.indexOf(pl)-this.pl.indexOf(dl));
         if(this.drt>24){
             this.drt=this.drt-24;
         }
     }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print(" for booking enter 1 ,for taxi details enter 2,to quit enter 3.");
       do{
           int in=sc.nextInt();
           switch (in) {
               case 1:
                   String pl = "";
                   String dl = "";
                   int pt = 0;
                   System.out.println("Valid Locations A,B,C,D,E,F");
                   System.out.println("Enter Pickup Location :");
                   pl = sc.next();
                   System.out.println("Enter Drop Location :");
                   dl = sc.next();
                   System.out.println("Enter Pickup Time (24 hr time format) :");
                   pt=sc.nextInt();
                   Booking b=new Booking(pl,dl,pt);
                   System.out.println("Your booking has received");
                   System.out.println("Thank you ");
                    Location.book(b);

                   break;
               case 2:
                   System.out.println("Enter taxi id.");
                   CallTaxi.taxiDetails(sc.nextInt());
                   break;
               case 3:
                   break;
           }
           if(in==3){
               break;
           }

       }while(true);


    }

}
