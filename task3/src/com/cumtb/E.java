package com.cumtb;
class Thread2 implements Runnable
{
    public void run()
    {
        for(int i = 1;i<=20;i++) {
            System.out.printf("第%d次执行%s\n",i,Thread.currentThread().getName());
            try {
                int slee = 300;
                Thread.sleep(slee);
            }catch(Exception e){

            }
        }
    }
}
public class E {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Thread2(),"线程2");
        th1.start();
    }
}
