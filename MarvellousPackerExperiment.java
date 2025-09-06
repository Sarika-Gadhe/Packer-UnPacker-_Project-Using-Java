package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

public class MarvellousPackerExperiment
{
    private String PackName;
    private String DirName;

    public MarvellousPackerExperiment(String A, String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public int PackingActivity()
    {

        try
        {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("------------------------------- Marvellous Packer Unpacker ---------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("--------------------------------- Packing Activity -----------------------------------------------"); 
            System.out.println("--------------------------------------------------------------------------------------------------");
            
            int i = 0, j = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);

            // Check the existance of Directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println(DirName + " is successfully opened");

                File PackObj = new File(PackName);

                // Create a pack file
                boolean bRet = PackObj.createNewFile();

                if(bRet == false)
                {
                    System.out.println("Unable to create pack file");
                    return -2;
                }               
                
                System.out.println("Packed file gets successfully created with name : "+PackName);

                // Retrive all files from directory
                File Arr[] = fobj.listFiles();

                //Packed file object
                FileOutputStream foobj = new FileOutputStream(PackObj);

                //Buffer for read and write activity
                byte Buffer[] = new byte[1024];

                String Header = null;

                //Directory traversal
                for(i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName() + " " +Arr[i].length();

                    //Loop to form 100 bytes header 
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }

                    //write header into packed file
                    foobj.write(Header.getBytes());

                    //open file from directory for reading 
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    //write content of file into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name scanned : "+Arr[i].getName());
                        System.out.println("File size is : "+iRet);
                    }

                    fiobj.close();
                    iCountFile++;

                }
                System.out.println("Packing Activity is done ");

                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println("------------------------- Statistical Report ----------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------------------------");

                //To be add
                System.out.println("Total files packed : "+iCountFile);

                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println("---------------------------- Thank You for using our application ---------------------------------");
                System.out.println("--------------------------------------------------------------------------------------------------");

                return 1;
                
            }
            else
            {
                System.out.println("There is no such directory");
                return 0;
            }
        } //End of try 
        catch(Exception eobj)
        {
            return -3;
        }

       
    } // End of PackingActivity Function
} // End of MarvellousPacker class

