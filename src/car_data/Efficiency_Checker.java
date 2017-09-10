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
class Check_Efficiency {



    Check_Efficiency(double unacc_centroid, double acc_centroid, double good_centroid, double vgood_centroid) throws IOException {
       
        BufferedReader reader ;
        reader = new BufferedReader(new FileReader("src/heart_diseases_training.csv"));
        String line=null;
        Scanner scanner = null;
        int Recognized_Class=0;
        float []attribute=new float[5];
        int given_class=0;
        int correctly_classified=0;
        int incorrectly_classified=0;
        //int correctly_classifies=47;
        //int incorrectly_classifies=6;
        
                
                for(int i=0;i<1728;i++)
                {
                    line=reader.readLine();
                    if(i>1400)
                    {
                        scanner = new Scanner(line);
                        scanner.useDelimiter(",");
                        for(int k=0;k<6;k++)
                {
                     attribute[k]=Float.valueOf(scanner.next());
                }
               
                 given_class=Integer.valueOf(scanner.next());

                double node_value; 
                Car_DaTA obj = null;
            node_value = obj.Give_Value(attribute);
             Recognized_Class=find_nearest_centroid(unacc_centroid,acc_centroid,good_centroid,vgood_centroid,node_value);
            if(given_class==Recognized_Class)
            {
                correctly_classified++;
            }
            else
            {
                incorrectly_classified++;
            }
                    }
        
                }
                float efficiency;
                efficiency = correctly_classified*100/(correctly_classified+incorrectly_classified);
                System.out.println("Correctly Classified:          "+correctly_classified);
                System.out.println();
                System.out.println("Incorrectly Classified:        "+incorrectly_classified);
                System.out.println();
                System.out.println("Efficiency               :"+efficiency+"%");
        
        
    }

    private int find_nearest_centroid(double unacc_centroid,double acc_centroid,double good_centroid,double vgood_centroid, double node_value) {
            double min_distance=(unacc_centroid-node_value)*(unacc_centroid-node_value);
            double distance_with_centroid;
            int recognized_class=0;
            distance_with_centroid=(acc_centroid-node_value)*(acc_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=1;
            }
            distance_with_centroid=(good_centroid-node_value)*(good_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=2;
            }
            distance_with_centroid=(vgood_centroid-node_value)*(vgood_centroid-node_value);
            if(min_distance>distance_with_centroid)
            {
                recognized_class=3;
            }
            return recognized_class;
    }
    
}

        
    
