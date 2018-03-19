import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;

import java.util.Arrays;

/**
 * Created by Portal on 3/18/2018.
 */
public class fifoPageReplacement {
    static boolean isPresent(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] pg={1,2,3,4,1,2,5,1,2,3,4,5};
        //{0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1};{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};/*
        int i;
        int frames=3,pageFaults=0;
        int[] memory= new int[frames];
        for(i=0;i<frames;i++){
            memory[i]=pg[i];
        }
        pageFaults+=frames;
        int ptr=-1;
        for(i=frames;i<pg.length;i++){
            if(ptr==frames-1){
                ptr=-1;
            }
            //Arrays.sort(sorted);

            if(!isPresent(memory,pg[i])){
                ptr++;
                memory[ptr]=pg[i];

                pageFaults++;
            }
            //sorted=memory;
        }
        System.out.println("No. of page faults are:"+pageFaults);
    }
}
