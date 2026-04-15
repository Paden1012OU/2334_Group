
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class binarySearch {

    public static int recurSearch(int arr[], int l, int r, int goal)
    {
        if(r >= l && l <= arr.length - 1)
        {
            int mid=(l+(r))/2;
            if (arr[mid] == goal)
            {
                return mid;
            }
            
            if (arr[mid] > goal)
            {
                return recurSearch(arr, l, mid - 1, goal);
            }
            else return recurSearch(arr, mid + 1, r, goal);
        
                

        }
        return -1;
    }

    public int iterSearch(int arr[], int goal)
    {
        int l=0;
        int r=arr.length-1;

        while(l<=r)
        {
            int mid = l+(r-l)/ 2;

            if(arr[mid]==goal)
            {
                return mid;
            }
            if(arr[mid]<goal)
            {
                l=mid+1;
            }
            else r=mid-1;
        }
        return -1;
    }
    public static void main(String args[]) throws Exception
    {
        binarySearch temp=new binarySearch();
        int[] arr5k=new int[5000];
        for (int i = 0; i < 5000; i++) {
            arr5k[i]=i;
        }
        int end=(arr5k.length);
        long startTime=0;

        try
        {
        File file = new File("binaryoutput.txt");
        file.createNewFile();
        
        BufferedWriter wr=new BufferedWriter(new FileWriter(file));

        long afTime=0;
        Random rand = new Random();

        
        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr5k,0,end,rand.nextInt(5000));
        afTime=System.nanoTime();
        wr.write("5k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr5k,rand.nextInt(5000));
        afTime=System.nanoTime();
        wr.write("5k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }
        
        int[] arr10k=new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr10k[i]=i;
        }
        end=(arr10k.length);


        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr10k,0,end,rand.nextInt(10000));
        afTime=System.nanoTime();
        wr.write("10k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr10k,rand.nextInt(10000));
        afTime=System.nanoTime();
        wr.write("10k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }


        int[] arr30k=new int[30000];
        for (int i = 0; i < 30000; i++) {
            arr30k[i]=i;
        }
        end=(arr30k.length);


        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr30k,0,end,rand.nextInt(30000));
        afTime=System.nanoTime();
        wr.write("30k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr30k,rand.nextInt(30000));
        afTime=System.nanoTime();
        wr.write("30k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }


        int[] arr50k=new int[50000];
        for (int i = 0; i < 50000; i++) {
            arr50k[i]=i;
        }
        end=(arr50k.length);


        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr50k,0,end,rand.nextInt(50000));
        afTime=System.nanoTime();
        wr.write("50k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr50k,rand.nextInt(50000));
        afTime=System.nanoTime();
        wr.write("50k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }


        int[] arr70k=new int[70000];
        for (int i = 0; i < 70000; i++) {
            arr70k[i]=i;
        }
        end=(arr70k.length);


        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr70k,0,end,rand.nextInt(70000));
        afTime=System.nanoTime();
        wr.write("70k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr70k,rand.nextInt(70000));
        afTime=System.nanoTime();
        wr.write("70k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }


        int[] arr100k=new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr100k[i]=i;
        }
        end=(arr100k.length);


        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        recurSearch(arr100k,0,end,rand.nextInt(100000));
        afTime=System.nanoTime();
        wr.write("100k recur "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        for(int i=0;i<5;i++)
        {
        startTime=System.nanoTime();
        temp.iterSearch(arr100k,rand.nextInt(100000));
        afTime=System.nanoTime();
        wr.write("100k iter "+(i+1)+" "+(afTime-startTime));
        wr.newLine();
        }

        wr.close();
        }
        catch(Exception e)
        {
            System.out.println("nope");
        }
       
 
        
    }
}
