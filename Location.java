import java.util.ArrayList;
import java.util.Collections;

public class Location {
    static ArrayList<ArrayList<CallTaxi>> loc;
    static int size=6;
    static  String pl="ABCDEF";
    static {
        loc=new ArrayList<ArrayList<CallTaxi>>();
        loc.add(new ArrayList<>());
        loc.add(new ArrayList<>());
        loc.add(new ArrayList<>());
        loc.add(new ArrayList<>());
        loc.add(new ArrayList<>());
        loc.add(new ArrayList<>());
        loc.get(0).add(CallTaxi.addTaxi());
        loc.get(0).add(CallTaxi.addTaxi());
        loc.get(0).add(CallTaxi.addTaxi());
        loc.get(0).add(CallTaxi.addTaxi());
    }
    public static void addTaxiA(){
        loc.get(0).add(CallTaxi.addTaxi());
    }
    public static void addTaxiB(){
        loc.get(1).add(CallTaxi.addTaxi());
    }
    public static void addTaxiC(){
        loc.get(2).add(CallTaxi.addTaxi());
    }
    public static void addTaxiD(){
        loc.get(3).add(CallTaxi.addTaxi());
    }
    public static void addTaxiE(){
        loc.get(4).add(CallTaxi.addTaxi());
    }
    public static void addTaxiF(){
        loc.get(5).add(CallTaxi.addTaxi());
    }
    public static void bsucess(CallTaxi t){
        System.out.println("output : ");
        System.out.println("Taxi is available");
        System.out.println("Taxi id : "+t.tid);
    }
    public static void book(Booking b){
        int picl=pl.indexOf(b.picl);
        boolean flag=true;
        for(int i=picl;i< loc.size();i++) {
            int j=0;
            Collections.sort(loc.get(i));
            if (!loc.get(i).isEmpty()) {
               for(int k=0;k<loc.get(i).size();k++) {
                   if (loc.get(i).get(k).drpt + j < b.pickt) {
                       loc.get(i).get(k).ctd.add(b);
                       loc.get(i).get(k).te += b.amount;
                       loc.get(i).get(k).pict = b.pickt;
                       loc.get(i).get(k).drpt = b.drt;
                       bsucess(loc.get(i).get(k));
                       flag = false;
                       loc.get(pl.indexOf(b.drl)).add(loc.get(i).remove(k));
                       break;
                   }
               }
            }else{
                j++;
            }
        }
        if(flag){
            for(int i=picl;i>=0;i--) {
                int j=0;
                Collections.sort(loc.get(i));
                if (!loc.get(i).isEmpty()) {
                  for(int k=0;k<loc.get(i).size();k++) {
                      if (loc.get(i).get(k).drpt + j < b.pickt) {
                          loc.get(i).get(k).ctd.add(b);
                          loc.get(i).get(k).te += b.amount;
                          loc.get(i).get(k).pict = b.pickt;
                          loc.get(i).get(k).drpt = b.drt;
                          bsucess(loc.get(i).get(k));
                          flag = false;
                          loc.get(pl.indexOf(b.drl)).add(loc.get(i).remove(k));
                          break;
                      }
                  }
                }else{
                    j++;
                }
            }
        }
        if(flag){
            System.out.println("sorry !! Taxi is not available..");
        }

    }
}
