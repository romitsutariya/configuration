
import java.io.*; 
import java.net.URL; 
import java.net.MalformedURLException; 
import java.io.*; 
import java.nio.file.Files; 
import java.nio.file.*; 

import java.util.concurrent.CountDownLatch;


public class Solution {
     private static final CountDownLatch loadingLatch = new CountDownLatch(3);
  public static void main(String ...arg)throws IOException,InterruptedException{
        
        File[] paths;
        File f = null;

             f = new File("/root/");

        Download url1=new Download("https://www.geeksforgeeks.org/",loadingLatch);
        Download url2=new Download("https://www.geeksforgeeks.org/",loadingLatch);
        Download url3=new Download("https://www.geeksforgeeks.org/",loadingLatch);
        Download url4=new Download("https://www.geeksforgeeks.org/",loadingLatch);
        Download url5=new Download("https://www.geeksforgeeks.org/",loadingLatch);
       

        Thread t1= new Thread(url1);
        Thread t2= new Thread(url2);
        Thread t3= new Thread(url3);
        Thread t4= new Thread(url4);
        Thread t5= new Thread(url5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
       
        loadingLatch.await();
        System.out.println("String Moving file");
        paths = f.listFiles((file,filename)-> filename.endsWith(".html"));
        for(File child:paths) {
         
         child.renameTo(new File("/root/Download/" + child.getName()));
         
        }
        System.out.println("File Moved Successfully :");
  }
}

class Download implements Runnable { 
  
    private CountDownLatch loadingLatch;
    String url;
    public Download(String url,CountDownLatch loadingLatch){
        this.url=url;
        this.loadingLatch=loadingLatch;
    }
    public void run(){
        DownloadWebPage(url);
        loadingLatch.countDown();
    }
    public static void DownloadWebPage(String webpage) 
    { 
        try { 
  
            // Create URL object 
            URL url = new URL(webpage); 
            BufferedReader readr =  
              new BufferedReader(new InputStreamReader(url.openStream())); 
  
            // Enter filename in which you want to download 
            BufferedWriter writer =  
              new BufferedWriter(new FileWriter("Download"+System.currentTimeMillis()+".html")); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
  
            readr.close(); 
            writer.close(); 
            System.out.println("Successfully Downloaded."); 
        } 
  
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println("Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised"); 
        } 
    } 
} 