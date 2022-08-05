import java.io.*;
import java.util.*; 

public  class TaskC{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int val = Integer.parseInt(br.readLine());
            System.out.println(computeRes(val));
        }
    }
    public static String computeRes(int val){ 
        for(int i = 9;i>0;i--){ 
            String arr[] = new String[1];
            arr[0] = null ; 
            backtrack(i, val, new StringBuilder(), arr);
            if(arr[0]!=null){
                //System.out.println("got the value as "+arr[0]);
                return arr[0];
            }
        }
        return "";
    }
    
    private static void backtrack(int current_val,int total, StringBuilder sb, String arr[]){
        if(total==0){
            //System.out.println(sb.toString());
            char ch[] = sb.toString().toCharArray(); 
            Arrays.sort(ch); 
            arr[0] = new String(ch); 
            return ; 
        }
        if(total<0){
            return ; 
        }
        if(current_val < 1){
            return;  
        }
        //System.out.println(String.format("Got current_val %d total %d ", current_val , total));

        for(int i = current_val ;i>0;i--){ 
            sb.append(i);
            backtrack(i-1, total-i, sb ,arr);
            if(arr[0]!=null)
                return ; 
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
