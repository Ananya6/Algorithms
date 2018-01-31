import java.util.Scanner;

/**
 * Created by Portal on 1/30/2018.
 */
public class fcfs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] burst=new int[n];
        int wait=0;
        int turnaround=0;
        int i=0;
        for(;i<n;i++){
            burst[i]=sc.nextInt();
        }
        String proc="P";
        System.out.println("Process  "+"Waiting Time  "+"Turnaround Time");
        for(i=0;i<n;i++){
            if(i!=0){
                wait=turnaround;
            }
            turnaround=wait+burst[i];
            System.out.println(proc+(i+1)+"          "+wait+"          "+turnaround);
        }
    }
}
