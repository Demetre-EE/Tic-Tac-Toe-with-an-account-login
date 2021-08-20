import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fazecast.jSerialComm.SerialPort;


public class signUp implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel newUser;
    public JTextField newUserText;
    private JLabel newPassword;
    public JPasswordField newPasswordText;
    private JLabel repeatNewPassword;
    public JPasswordField repeatNewPasswordText;
    private JButton signUp;
    private JButton back;
    private JLabel success;
    public static int score =0;

    public signUp() throws IOException, InterruptedException {
/*
        SerialPort sp = SerialPort.getCommPort("/dev/cu.usbserial-1430");
        sp.setComPortParameters(9600,8,1,0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING,0,0);

        if(sp.openPort()){
            System.out.println("Port is open");
        }else{
            System.out.println("Port is not open");
            return;
        }

 */

        frame = new JFrame();
        panel =  new JPanel();

        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Sign up Page");

        panel.setLayout(null);

        newUser = new JLabel("Username: ");
        newUser.setBounds(10, 30, 120, 10);
        panel.add(newUser);

        newUserText = new JTextField(20);
        newUserText.setBounds(120, 25, 165, 25);
        panel.add(newUserText);

        newPassword = new JLabel("New Password: ");
        newPassword.setBounds(10, 60, 120, 15);
        panel.add(newPassword);

        newPasswordText = new JPasswordField(20);
        newPasswordText.setBounds(120, 55, 165, 25);
        panel.add(newPasswordText);

        repeatNewPassword = new JLabel("Repeat Password: ");
        repeatNewPassword.setBounds(10, 90, 120, 15);
        panel.add(repeatNewPassword);

        repeatNewPasswordText = new JPasswordField(20);
        repeatNewPasswordText.setBounds(120, 85, 165, 25);
        panel.add(repeatNewPasswordText);

        signUp = new JButton("Sign up");
        panel.add(signUp);
        signUp.setBounds(190, 110, 75, 25);

        back = new JButton("<<Back");
        back.setBounds(120,110,75,25);
        panel.add(back);

        success = new JLabel("");
        panel.add(success);
        success.setBounds(50,145,200,30);

        frame.setVisible(true);
        ActionListener backbutton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccountLogin();

            }
        };
        back.addActionListener(backbutton);
        ActionListener SignUpButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter print = new PrintWriter(new FileWriter("database.txt",true));
                    print.println(newUserText.getText()+" "+newPasswordText.getText()+" "+score);
                    print.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                String repeatPass = repeatNewPasswordText.getText();
                if(newPasswordText.getText().equals(repeatPass)&&!newPasswordText.getText().equals("")){
                    success.setText("Account Created!!");

                    JButton Continue = new JButton("Continue");
                    panel.add(Continue);
                    Continue.setBounds(180,150,80,20);
                    ActionListener startAgain = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.setVisible(false);
                            new AccountLogin();
                        }
                    };
                    Continue.addActionListener(startAgain);

                }else{
                    success.setText("Try Again!!");
                }


            }
        };
        signUp.addActionListener(SignUpButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}