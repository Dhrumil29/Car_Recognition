/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bhailoo
 */
public class Car_DaTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/car_training.csv"));
        String line=null;
        Scanner scanner = null;
        int index=0;
        int Recognized_Class=0;
        float []attribute=new float[6];
        int given_class=0;
        /*Intialization of arrays of each cluster*/
        double unacc[] =new double[2];
        double acc[]=new double[2];
        double good[]=new double[2];
        double vgood[]=new double[2];
        
        unacc[0]=-1;
        acc[0]=-1;
        good[0]=-1;
        vgood[0]=-1;
        
        
            
            for(int i=1;i<1400;i++)
            {
               
                line=reader.readLine();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                for(int k=0;k<5;k++)
                {
                     attribute[k]=Float.valueOf(scanner.next());
                }
               
                 given_class=Integer.valueOf(scanner.next());
                 
                double node_value;  
            node_value = Give_Value(attribute);
                    switch(given_class)
                    {
                        
                             
                        case 0:
                        {
                           if(unacc[0]==0)
                           {
                               unacc[0]=node_value;
                           }
                            unacc[1]=node_value;
                            unacc[0]=(unacc[0]+unacc[1])/2;
                            break;
                        }
                        case 3:
                        {
                            if(acc[0]==0)
                            {
                                acc[0]=node_value;
                            }
                            acc[1]=node_value;
                           acc[0]=(acc[0]+acc[1])/2;
                           break;
                        }
                        case 6:
                        {
                             if(good[0]==0)
                            {
                                good[0]=node_value;
                            }
                           good[1]=node_value;
                           good[0]=(good[0]+good[1])/2;
                           break;
                        }
                        case 10:
                        {
                             if(vgood[0]==-1)
                            {
                                vgood[0]=node_value;
                            }
                            vgood[1]=node_value;
                           vgood[0]=(vgood[0]+vgood[1])/2;
                           break;
                        }
                            
                    }
                }
            
                /*Assigning the centroid to seperate variable*/
            double unacc_centroid=unacc[0];
            double acc_centroid=acc[0];
            double good_centroid=good[0];
            double vgood_centroid= good[0];
            
           System.out.println("unacc_Centroid:      :"+unacc_centroid);
           System.out.println("acc_centroid:       :"+acc_centroid);
           System.out.println("good_centroid       :"+good_centroid);
           System.out.println("vgood_centroid :"+vgood_centroid);
           Check_Efficiency p;
           
           new Efficiency_Checker(unacc_centroid,acc_centroid,good_centroid,vgood_centroid);
           
           
    }
   

    @SuppressWarnings("empty-statement")
    static  double Give_Value(float[] attribute) {
               double[] weight_of_attributes = {21.62584,21.62584,0.260181,0.426942,25.94058,25.94058,4.180038};
               double node_value;
               
               //weight_of_attributes 
               node_value=0;
               
               for(int k=0;k<6;k++)
               {
                   node_value+=weight_of_attributes[k]*attribute[k];
               }
               return node_value;

};
              
}
               

               

       
    


     
   
    

