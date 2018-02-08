/**
 * Created on 2/8/2018.
 */
import java.util.*;
public class roundRobin {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("No of processes:");
        int n=sc.nextInt();
        System.out.println("Enter quant");
        int quant=sc.nextInt();
        int[] burst=new int[n];
        int[] finishTime=new int[n];
        Arrays.fill(finishTime,-1);
        ArrayList<Integer> order=new ArrayList<>();
        int i=0;
        int qmax=0,quotient=0,time=0;
        for(;i<n;i++){
            burst[i]=sc.nextInt();
            quotient=burst[i]/quant;
            if(quotient>qmax)
                qmax=quotient;
        }
        int[] copyBurst=Arrays.copyOf(burst,n);
        for(i=1;i<=qmax+1;i++){
            for(int j=0;j<n;j++){
                if(copyBurst[j]>=quant){
                    copyBurst[j]-=quant;
                    time+=quant;
                    order.add(j+1);
                }
                else{
                    if(copyBurst[j]!=0){
                        time+=copyBurst[j];
                        order.add(j+1);
                        copyBurst[j]=0;
                    }}

                if(copyBurst[j]==0){
                    if(finishTime[j]==-1)
                        finishTime[j]=time;
                }


                }
            }
            float totalWait=0,totalTurn=0;

        for(i=0;i<n;i++){
            int wait=finishTime[i]-burst[i];
            totalWait+=wait;
            totalTurn+=finishTime[i];
            System.out.println("P"+(i+1)+" Wait Time: "+wait+" TurnAround Time: "+finishTime[i]);
        }
        System.out.println("Order of processes"+order);
        System.out.println("Average Waiting time: "+totalWait/n+" \nAverage Turnaround: "+totalTurn/n);

    }
}
