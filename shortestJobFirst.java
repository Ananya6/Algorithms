
import java.util.*;
import java.util.Comparator;

public class shortestJobFirst implements Comparable<shortestJobFirst> {
    String pr = null;
    int at;
    int bt;
    public int compareTo(shortestJobFirst o) {
        return this.at-o.at;
    }
    public String toString() {
        return String.format("(%s, %d,%d)", pr,at, bt);
    }
    shortestJobFirst(String m,int n,int o){
        this.pr=m;
        this.at=n;
        this.bt=o;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<shortestJobFirst> main = new ArrayList<>();
        //shortestJobFirst[] arr = new shortestJobFirst[n];
        int i = 0;
        for (; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String pr = "P" + (i + 1);
            int at = x;
            int bt = y;
            shortestJobFirst obj = new shortestJobFirst(pr, at, bt);
            main.add(obj);
        }

        Collections.sort(main, new Comparator<shortestJobFirst>() {
            @Override
            public int compare(shortestJobFirst o1, shortestJobFirst o2) {
                return o1.at - o2.at;
            }
        });
        ArrayList<shortestJobFirst> sub = new ArrayList<>();
        int totalTime = 0;

        int waitTime = 0;
        int actualWaitTime = 0;


        boolean first = true;
        while (true) {


            i = 0;
            while (true) {
                //int j=0;

                while (main.size() != 0 && (main.get(0).at <= totalTime)) {
                    sub.add(main.remove(0));
                }

                Collections.sort(sub, new Comparator<shortestJobFirst>() {
                    @Override
                    public int compare(shortestJobFirst o1, shortestJobFirst o2) {
                        return o1.bt - o2.bt;
                    }
                });

                shortestJobFirst element = sub.get(0);
                totalTime += element.bt;
                if (first == true) {
                    first = false;

                } else {
                    actualWaitTime = waitTime - element.at;
                }
                // main.remove(sub.get(0));
                System.out.print(sub.remove(0).toString());
                System.out.println("  Waiting time:" + actualWaitTime + "  TurnaroundTime:" + (actualWaitTime + element.bt));
                waitTime += element.bt;

                totalTime += sub.get(0).bt;
                // main.remove(sub.get(0));
                System.out.println(sub.remove(0).toString());

                if (main.size() == 0 && sub.size() == 0)
                    break;

            }


        }

    }

}
