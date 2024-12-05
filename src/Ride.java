import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;

    private int maxRider;
    private int numOfCycles;

    public Ride() {
    }

    private Queue<Visitor> waitingLine;
    private Queue<Visitor> VipWaitingLine;
    private LinkedList<Visitor> rideHistory;

    public Ride(String rideName, int capacity, Employee operator,int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.VipWaitingLine = new LinkedList<>();
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();

    }

    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider=10;
        this.numOfCycles = 0;
        this.VipWaitingLine = new LinkedList<>();
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();

    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        if (rideName == null || rideName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ride name cannot be null or empty");
        }
        this.rideName = rideName.trim();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative");
        }
        this.capacity = capacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    //我额外添加了vip的队列，提供了和特惠票不一样的地方，保证买了VIP能得到提前玩的权力
    //I added an additional VIP queue to provide a different place from
    // he special ticket to ensure that I can get the right to play in advance when I buy a VIP
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor!= null &&visitor.getTicketType().contains("VIP")){
        VipWaitingLine.offer(visitor);
        return;}

        waitingLine.offer(visitor);
    }

    //VIP能得到提前玩的权力
    //VIP can get the right to play in advance

    @Override
    public void removeVisitorFromQueue() {
        if (VipWaitingLine != null && !VipWaitingLine.isEmpty()) {
            VipWaitingLine.poll();
        } else if (waitingLine != null && !waitingLine.isEmpty()) {
            waitingLine.poll();
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Waiting line for " + rideName + ":");
        int v =0;
        int c =0;
        for (Visitor vip : VipWaitingLine){
            System.out.println(vip);
            v++;
        }
        System.out.print("The above is the vip queue");
        System.out.println("-------The number of VIP queue members is:"+v);
        System.out.println("----------------------------");

        for (Visitor visitor : waitingLine) {
            System.out.println(visitor);
            c++;
        }
        System.out.print("The above is the common queue");
        System.out.println("-------The number of com queue members is:"+c);
        System.out.println("----------------------------");
    }


    @Override
    public void runOneCycle() {
        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        play();
        if (operator == null) {
            System.out.println("No operator assigned. Ride cannot run.");
            return;
        }
        if (VipWaitingLine.isEmpty() && waitingLine.isEmpty()) {
            System.out.println("No waiting visitors. Ride cannot run.");
            return;
        }

        int ridersThisCycle = 0;


        // 优先处理 VIP 队列
        ridersThisCycle = Math.min(maxRider, VipWaitingLine.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = VipWaitingLine.poll();
            addVisitorToHistory(rider);
        }

        // 如果还有空位，处理普通队列
        int remainingCapacity = maxRider - ridersThisCycle;
        for (int i = 0; i < remainingCapacity && !waitingLine.isEmpty(); i++) {
            Visitor rider = waitingLine.poll();
            addVisitorToHistory(rider);
            ridersThisCycle++;
        }

        numOfCycles++;
        System.out.println("Ride cycle completed. " + ridersThisCycle + " visitors rode the " + rideName);
        System.out.println("*                                                      *");
        System.out.println("********************************************************");

    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor.getTimesOfPlay()==0){
            rideHistory.add(visitor);
        }else {
            visitor.setTimesOfPlay(visitor.getTimesOfPlay()+1);
            rideHistory.add(visitor);

        }


        try {
            inToHistory(rideHistory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory == null || rideHistory.isEmpty()) {
            System.out.println("No ride history available for " + rideName + ".");
            return;
        }

        int vipNum = 0;
        int noVipNum = 0;

        System.out.println("Ride history for " + rideName + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor);
            if (visitor.getTicketType().equalsIgnoreCase("VIP")) {
                vipNum++;
            }else {noVipNum++;}
        }

        System.out.println("Total VIP visitors: " + vipNum);
        System.out.println("Total ordinary visitors: " + noVipNum);
    }

    public void sortVisitorHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Visitor history has been sorted.");
    }


    public void inToHistory(List<Visitor> Queue) throws Exception{

        try (PrintWriter writer = new PrintWriter(new FileWriter("History.csv"))) {
            for (Visitor visitor : Queue) {
                writer.println(visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getGender() + "," +
                        visitor.getHeight() + "," +
                        visitor.getTicketType() + "," +
                        visitor.hasPassport());
            }
            System.out.println("Visitors exported to History.csv");
        } catch (IOException e) {
            System.out.println("Error exporting visitors: " + e.getMessage());
        }


    }

    public  void  outToHistory() throws IOException {
        System.out.println("----------The following is the history record saving file reading-----------");
      FileInputStream READ= new FileInputStream("History.csv");
      BufferedInputStream BI = new BufferedInputStream(READ);
      byte[] buffer = new byte[1024*8];
      int len;


      while((len = BI.read(buffer))!=-1){
          System.out.print(new String(buffer,0,len));

      }

    }






    @Override
    public String toString() {
        return String.format("Ride{rideName='%s', capacity=%d, operator=%s}",
                rideName, capacity, operator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return capacity == ride.capacity &&
                Objects.equals(rideName, ride.rideName) &&
                Objects.equals(operator, ride.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideName, capacity, operator);
    }

    public void play(){
        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        System.out.println("*                      WELCOME                         *");
        System.out.println("*                   HAPPY GAME GO !!!                  *");
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
    }
}