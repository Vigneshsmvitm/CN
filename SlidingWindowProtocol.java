/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

/**
 *
 * @author Lab6
 */
import java.util.Arrays;
public class SlidingWindowProtocol 
{
    private int windowSize;
    private int[] frames;
    private boolean[] ack;
    public SlidingWindowProtocol(int windowSize,int framecount)
    {
        this.windowSize=windowSize;
        this.frames=new int[framecount];
        this.ack=new boolean[framecount];
        for(int i=0;i<framecount;i++)
        {
            frames[i]=i;
            ack[i]=false;
            
        }
        
    }
    public void sendframes()
    {
        int sendindex=0;
        while(sendindex<frames.length)
        {
            for(int i=0;i<windowSize &&(sendindex+i)<frames.length;i++)
            {
                System.out.println("Sending frame"+frames[sendindex+i]);
            }
            for(int i=0;i<windowSize &&(sendindex+i)<frames.length;i++)
            {
                ack[sendindex+i]=receiveAck(sendindex+i);
            }
            while(sendindex<frames.length && ack[sendindex])
            {
                sendindex++;
            }
        }
    }
    private boolean receiveAck(int frame)
    {
        System.out.println("Receiving ack for frame:"+frame);
        return true;
    }
    public static void main(String[] args)
    {
        int windowSize=4;
        int framecount=10;
        SlidingWindowProtocol swp=new SlidingWindowProtocol(windowSize, framecount);
        swp.sendframes();
    }
}
