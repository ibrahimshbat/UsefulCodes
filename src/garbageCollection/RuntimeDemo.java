package garbageCollection;
    import java.util.Date;
     
    public class RuntimeDemo
    {
    	public static void main(String args[]){
    	Runtime r=Runtime.getRuntime();
    	System.out.println("total memory of the heap :"+r.totalMemory());
    	System.out.println("free memory of the heap :"+r.freeMemory());
    	for(int i=0;i<10000;i++)
    	{
    		Date d=new Date();
    		d=null;
    	}
    	System.out.println("free memory of the heap :"+r.freeMemory());
    	r.gc();
    	System.out.println("free memory of the heap :"+r.freeMemory());
    	}
    }