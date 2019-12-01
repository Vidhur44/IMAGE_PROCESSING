
package Jtext;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;


public class o_to_bw {

    public static void main(String[] args)throws IOException{
        
           BufferedImage image=null;
           File f=null;
           
           try {
            
               f=new File("E:\\O_to_BW\\img1.jpg");
               image=ImageIO.read(f);
               
        } catch (Exception e) {
               System.err.println("Error is: "+e);
        }
        
           
           int width=image.getWidth();
           int height=image.getHeight();
           
           for(int y=0;y<height;y++){
               for(int x=0;x<width;x++){
                   
                   int pixel=image.getRGB(x, y);
                   
                   int alpha=(pixel>>24)&0xff;
                   int red=(pixel>>16)&0xff;
                   int green=(pixel>>8)&0xff;
                   int blue=(pixel)&0xff;
                   
                   int avg=(red+green+blue)/3;
                  
                   pixel=(alpha<<24) | (avg<<16) |(avg<<8) |avg;
                   
                   image.setRGB(x, y, pixel);
                   
                   
               }
           }
           
           try {
            
               f=new File("E:\\O_to_BW\\out1.jpg");
               ImageIO.write(image, "jpg", f);
               
        } catch (Exception e) {
            
               System.err.println("Error is: "+e);
        }
        
    }


    
}
