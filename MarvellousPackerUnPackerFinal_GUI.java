import javax.swing.*;
import java.awt.Label;
import java.awt.event.*;
import java.sql.ResultSet;

import MarvellousPackerUnpacker.MarvellousPackerExperiment;
import MarvellousPackerUnpacker.MarvellousUnpackerExperiment;

class MarvellousLoginForm implements ActionListener
{
    public JFrame fobj,WelcomeFrame,PackFrame,UnPackFrame;
    public JButton bobj1,PackButton,UnPackButton,bobjP,bobj2,ExtractButton;
    public JTextField tobj1,DirTF,tobj2,tobj3;
    public JPasswordField pobj;
    public JLabel Userlabel, Passlabel, Resultlabel,TitleLabel1,TitleLabel2,TitleLabel3,DirLabel,FileLabel,FileName;

    public void LoginForm()
    {
        fobj = new JFrame();

        TitleLabel1 = new JLabel("Marvellous Packer Unpacker : Login Form");
        TitleLabel1.setBounds(70,10,500,30);

        Userlabel = new JLabel("UserName");
        Userlabel.setBounds(50,50,100,30);

        tobj1 = new JTextField();
        tobj1.setBounds(150,50,150,30);

        Passlabel = new JLabel("Password");
        Passlabel.setBounds(50,100,100,30);

        pobj = new JPasswordField();
        pobj.setBounds(150,100,150,30);

        bobj1 = new JButton("SUBMIT");   
        bobj1.setBounds(150,150,100,30);

        Resultlabel = new JLabel("");
        Resultlabel.setBounds(150, 200, 250, 30);        


        fobj.add(bobj1);
        fobj.add(tobj1);
        fobj.add(pobj);
        fobj.add(TitleLabel1);
        fobj.add(Userlabel);
        fobj.add(Passlabel);
        fobj.add(Resultlabel);

        bobj1.addActionListener(this);

        fobj.setLayout(null);
        
        fobj.setTitle("Marvellous Packer Unpacker");
        fobj.setSize(400,300);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent aobj)
    {
        String uname = tobj1.getText();
        String pass = new String(pobj.getPassword());

        if((uname.equals("Sarika")) && (pass.equals("Sarika@123")))
        {
            Resultlabel.setText("Login Succesfull");

            fobj.dispose(); 

            WelcomeWindow();
            
        }
        else
        {
            Resultlabel.setText("Unable to Login");
        }

    }

    public void WelcomeWindow()
    {
        WelcomeFrame = new JFrame();
        
        TitleLabel2 = new JLabel("Welcome to Marvellous Packing and UnPacking Project");
        TitleLabel2.setBounds(70,10,500,30);
        
        PackButton = new JButton("Pack");   
        PackButton.setBounds(100,100,100,30);
        
        UnPackButton = new JButton("UnPack");   
        UnPackButton.setBounds(250,100,100,30);

        PackButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent aobj)
            {
                PackFrame = new JFrame("Marvellous Packer");
                
                TitleLabel2 = new JLabel("Marvellous Packing Portal");
                TitleLabel2.setBounds(100,10,500,30);

                DirLabel = new JLabel("Directory Name : ");
                DirLabel.setBounds(50,50,100,30);        
                
                DirTF = new JTextField();
                DirTF.setBounds(150,50,150,30);                    
                
                FileLabel = new JLabel("File Name : ");
                FileLabel.setBounds(50,100,100,30);

                tobj2 = new JTextField();
                tobj2.setBounds(150,100,150,30);            

                bobj2 = new JButton("SUBMIT");   
                bobj2.setBounds(100,150,100,30);

                bobjP = new JButton("PREVIOUS");   
                bobjP.setBounds(250,150,100,30);
                
                bobjP.addActionListener((new ActionListener() {
                    public void actionPerformed(ActionEvent aobj)
                    {
                        PackFrame.dispose();
                        WelcomeWindow();

                        UnPackButton.addActionListener((new ActionListener() {
                            public void actionPerformed(ActionEvent aobj)
                            {
                                UnPackFrame = new JFrame();

                                TitleLabel3 = new JLabel("Marvellous UnPacking Portal");
                                TitleLabel3.setBounds(100,10,500,30);

                                FileName = new JLabel("File Name : ");
                                FileName.setBounds(50,50,100,30); 

                                tobj3 = new JTextField(tobj2.getText());
                                tobj3.setBounds(150,50,150,30);

                                ExtractButton = new JButton("Extract Here");   
                                ExtractButton.setBounds(100,150,150,30);

                                ExtractButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent aobj)
                                    {
                                        String UnPackName = null;
                                        int Result = 0;

                                          UnPackName = tobj3.getText();

                                         System.out.println("Returned value = " + Result);


                                          MarvellousUnpackerExperiment muobj = new MarvellousUnpackerExperiment(UnPackName);
                                          Result = muobj.UnpackingActivity();

                                          if(Result == 1)
                                          {
                                                JOptionPane.showMessageDialog(null,"All File are Extracted..");
                                                JOptionPane.showMessageDialog(null,"UnPacking Activity is Done...");
                                                UnPackFrame.dispose();
                                          }
                                          else if(Result == -1)
                                          {
                                                JOptionPane.showMessageDialog(null,"Unable to access Packed file");
                                          }
                                          else
                                          {
                                                JOptionPane.showMessageDialog(null,"Something is Wrong...");
                                          }

                                          
                                    }
                                });
                                

                                UnPackFrame.add(ExtractButton);
                                UnPackFrame.add(tobj3);
                                UnPackFrame.add(FileName);
                                UnPackFrame.add(TitleLabel3);
                                
                                tobj3.setEditable(false);
                                UnPackFrame.setLayout(null);

                                UnPackFrame.setTitle("Marvellous UnPacker");
                                UnPackFrame.setSize(400,300);
                                UnPackFrame.setVisible(true);
                                UnPackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                            }
                        }));

                    }
                    
                }));

                bobj2.addActionListener((new ActionListener() {
                    public void actionPerformed(ActionEvent aobj)
                    {
                        String filename = tobj2.getText();

                        String pack = null,dir = null;
                        int Result = 0;

                        pack = tobj2.getText();
                        dir = DirTF.getText();

                        MarvellousPackerExperiment mpobj = new MarvellousPackerExperiment(pack, dir);
                        Result = mpobj.PackingActivity();

                           
                        if(Result == 1)
                        {
                            JOptionPane.showMessageDialog(null,filename + "  file is created successfully!");
                            JOptionPane.showMessageDialog(null,"Packing Activity Done...");
                        }
                        else if(Result == -2)
                        {
                            JOptionPane.showMessageDialog(null,"Failed to create pack file...");
                        }
                        else if(Result == 0)
                        {
                            JOptionPane.showMessageDialog(null,"Directory not found...");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Something is Wrong...");

                        }

                        fobj.dispose(); 

                    }
                }));


                PackFrame.add(bobjP);
                PackFrame.add(bobj2);
                PackFrame.add(tobj2);
                PackFrame.add(DirTF);
                PackFrame.add(DirLabel);
                PackFrame.add(FileLabel);
                PackFrame.add(TitleLabel2);
                
                PackFrame.setLayout(null);

                PackFrame.setTitle("Marvellous Packer");
                PackFrame.setSize(400,300);
                PackFrame.setVisible(true);
                PackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




            }
            
        });
        
        WelcomeFrame.add(UnPackButton);
        WelcomeFrame.add(PackButton);  
        WelcomeFrame.add(TitleLabel2);
        
        WelcomeFrame.setLayout(null);

        WelcomeFrame.setTitle("Marvellous Packer Unpacker");
        WelcomeFrame.setSize(400,300);
        WelcomeFrame.setVisible(true);
        WelcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}

class MarvellousPackerUnPackerFinal_GUI
{
    public static void main(String A[])
    {
        MarvellousLoginForm mobj = new MarvellousLoginForm();
        mobj.LoginForm();
    }
}