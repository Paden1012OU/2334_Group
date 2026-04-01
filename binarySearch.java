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
            int mid = l + (r-1) / 2;

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
    public static void main(String args[])
    {
        binarySearch temp=new binarySearch();
        int[] arr=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=i;
        }
        int end=(arr.length);
        long startTime=System.nanoTime();
        
        System.out.println("Start "+System.nanoTime());
        System.out.println(recurSearch(arr,0,end,2));
        System.out.println("Mid "+(startTime-System.nanoTime()));
        startTime=System.nanoTime();
        System.out.println(recurSearch(arr,0,end,9));
        System.out.println("Mid "+(startTime-System.nanoTime()));
        startTime=System.nanoTime();
        System.out.println(recurSearch(arr,0,end,11));
        System.out.println("Mid "+(startTime-System.nanoTime()));
        startTime=System.nanoTime();
        System.out.println(recurSearch(arr,0,end,0));
        System.out.println("Mid "+(startTime-System.nanoTime()));
        startTime=System.nanoTime();
 
        System.out.println(temp.iterSearch(arr,2));
        System.out.println(temp.iterSearch(arr,9));
        System.out.println(temp.iterSearch(arr,11));
        System.out.println(temp.iterSearch(arr,0));

    }
}
