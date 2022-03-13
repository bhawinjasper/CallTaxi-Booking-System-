import java.util.ArrayList;

public class CallTaxi implements Comparable<CallTaxi>{
   static  int ctid=0;
   int tid;
   int te;
   int pict;
   int drpt;
   static ArrayList<CallTaxi> det=new ArrayList<>();
   ArrayList<Booking> ctd;
    CallTaxi(){
       ctid+=1;
       this.tid=ctid;
       this.ctd=new ArrayList<Booking>();
    }
    public static void taxiDetails(int j){
       if(j>ctid){
          System.out.println("Invalid Taxi Id");
       }else{
          CallTaxi temp = null;
          for(int i=0;i<det.size();i++){
             if(j==i+1){
                temp=det.get(i);
                break;
             }
          }
          System.out.println("Taxi-"+temp.tid+"\t"+"Total Earnings : "+temp.te);
          for(int k=0;k<temp.ctd.size();k++){
             System.out.println(temp.ctd.get(k).cuid+" "+temp.ctd.get(k).cuid+" "+temp.ctd.get(k).picl+" "+temp.ctd.get(k).drl+" "+temp.ctd.get(k).amount);
          }
          System.out.println("Thank you ");
       }
    }

   public static CallTaxi addTaxi(){
       CallTaxi cr=new CallTaxi();
       det.add(cr);
      return cr;
   }

   @Override
   public int compareTo(CallTaxi o) {
      return this.te-o.te;
   }
}
