/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Lab6
 */

import java.util.Scanner;
public class RSADemno {
    public static void main(String[] args)
    {
        String msg;
        int pt[]=new int[100];
        int ct[]=new int[100];
        int z,n,d,e,p,q,mlen;
        Scanner in=new Scanner(System.in);
        do
        {
            System.out.println("Enter the 2 large prime numbers for p&q");
            p=in.nextInt();
            q=in.nextInt();
        }
        while(prime(p)==0||prime(q)==0);
        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("valueof n "+n);
        System.out.println("value of z "+z);
  
        
        for(e=2;e<z;e++)
        {
            if(gcd(e,z)==1)
                break;
            
        }
        System.out.println("Encryption key e is "+e);
        System.out.println("Public key is(e,n)"+e+" ,"+n);
        
        for(d=2;d<z;d++)
        {
            if((e*d)%z==1)
                break;
            
        }
        System.out.println("Decryption key d is "+d);
        System.out.println("Private key is(e,n)"+d+","+n);
        in.nextLine();
        System.out.println("Enter the msg for encryption");
        msg=in.nextLine();
        mlen=msg.length();
        for(int i=0;i<mlen;i++)
            pt[i]=msg.charAt(i);
        System.out.println("ASCII values of PT array is");
        for(int i=0;i<mlen;i++)
            System.out.println(pt[i]);
        System.out.println("Encryption cipher text obtained");
        for(int i=0;i<mlen;i++)
            ct[i]=mult(pt[i],e,n);
        for(int i=0;i<mlen;i++)
        System.out.println(ct[i]+"\t");
        System.out.println("\n Decrytion:Plain text obtained");
        for(int i=0;i<mlen;i++)
            pt[i]=mult(ct[i],d,n);
        for(int i=0;i<mlen;i++)
        {
            System.out.println(pt[i]+":"+(char)pt[i]);
        }
    }
    public static int gcd(int a, int b) {
     
       if(b==0)
           return a;
       else
           return gcd(b,a%b);
           
           
       
    }
     public static int prime(int num) {
        

        for(int i = 2; i < num; i++) 
        {
            if (num % i == 0)
                return 0;
        }
        return 1;
   
     }



    public static int mult(int base,int exp,int n)
    {
               int res=1;
               for(int j=1;j<=exp;j++)
               res=((res*base)%n);
               return res;
    }
    
}            
