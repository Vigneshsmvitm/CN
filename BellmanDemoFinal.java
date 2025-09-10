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
import java.util.*;
public class BellmanDemoFinal
{
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args)
    {
        int V,E=1,cngt=0;
        int w[][]=new int[20][20];
        int edge[][]=new int[50][2];
        System.out.println("Enter the no of vertices:");
        V=in.nextInt();
        System.out.println("Enter the weight matrix:");
        for(int i=1;i<=V;i++)
        {
            for(int j=1;j<=V;j++)
            {
                w[i][j]=in.nextInt();
                if(w[i][j]!=0)
                {
                    edge[E][0]=i;
                    edge[E++][1]=j;
                }
            }
        }
        cngt=bellmanFord(w,V,E,edge);
        if(cngt==1)
        {
            System.out.println("\nNo negative weight cycle");
        }
        else
        {
            System.out.println("\nNegative weight cycle exists");
        }
    }
    public static int bellmanFord(int w[][],int V,int E,int edge[][])
    {
        int u,s,flag=1;
        int v;
        int distance[]=new int[20];
        int parent[]=new int[20];
        for(int i=1;i<=V;i++)
        {
            distance[i]=999;
            parent[i]=-1;
        }
        System.out.println("Enter the source vertex:");
        s=in.nextInt();
        distance[s]=0;
        for(int i=1;i<=V-1;i++)
        {
            for(int k=1;k<=E;k++)
            {
                u=edge[k][0];
                v=edge[k][1];
                if(distance[u]+w[u][v]<distance[v])
                {
                    distance[v]=distance[u]+w[u][v];
                    parent[v]=u;
                }
            }
        }
        for(int k=1;k<=E;k++)
        {
            u=edge[k][0];
            v=edge[k][1];
            if(distance[u]+w[u][v]<distance[v])
                flag=0;
        }
        if(flag==1)
        {
            for(int i=1;i<=V;i++)
            {
                System.out.println("Vertex "+i+" -> cost= "+distance[i]+" Parent= "+(parent[i]));
            }
        }
        return flag;
    }
    
}
