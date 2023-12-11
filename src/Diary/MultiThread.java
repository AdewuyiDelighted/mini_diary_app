package Diary;

public class MultiThread extends Thread{
    @Override
    public void run(){
        for(int index = 0; index < 20;index++){
            System.out.print(">> ");
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

}
