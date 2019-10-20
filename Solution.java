public class Solution{
   private int size;
   private int[] stack;
   private int top;
   
   public Solution(int size){
	this.size=size;
        this.stack=new int[size];
        this.top=-1;
	}

   public void  insert(int data)throws Exception{
   if(isStackFull())
   {
       throw new Exception("Stack size is full");
   }
     System.out.println("Adding data into Stack");
     this.stack[++top]=data;
   }
   public int  pop()throws Exception{
      if(isEmpty())
      {
          throw new Exception("Stack is Empty");
      }
        System.out.println("Removind data from  Stack");
        return this.stack[top--];
      }

   public boolean isStackFull()
   { 
      return this.top==this.size-1;
   }

   public boolean isEmpty(){
      return this.top==-1;
   }

   public static void main(String []args)throws Exception{
       Solution s=new Solution(10);
       for(String s1:args)
       {
         // s.insert(10);
       }
       for(String s1:args)
       {
          s.pop();
       }
       
   }


}
