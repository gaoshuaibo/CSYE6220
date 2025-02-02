package com.embio.tht.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.embio.tht.beans.*;

public final class FileUploader {

    public static void saveFileFromInputStream(InputStream stream, String path, String filename) throws IOException 
    {      
        FileOutputStream fs=new FileOutputStream( path + "/"+ filename); 
        byte[] buffer =new byte[1024*1024]; 
        int bytesum = 0; 
        int byteread = 0; 
        while ((byteread=stream.read(buffer))!=-1) 
        { 
           bytesum+=byteread; 
           fs.write(buffer,0,byteread); 
           fs.flush(); 
        } 
        fs.close(); 
        stream.close();      
    }      
    
}
