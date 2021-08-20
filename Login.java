import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JLabel userlabel;
    private JTextField textField;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton login;
    private JButton back;
    private JLabel success;
    private JFrame frame;
    private JPanel panel;
    public String name;
    public String pass;

    public static String Username;
    public static String Password;



    public Login() {

        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Login Page");

        panel.setLayout(null);

        userlabel = new JLabel("Username: ");
        userlabel.setBounds(10, 30, 80, 15);
        panel.add(userlabel);

        textField = new JTextField(20);
        textField.setBounds(100, 30, 165, 25);
        panel.add(textField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 60, 80, 15);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 60, 165, 25);
        panel.add(passwordText);

        login = new JButton("Login");
        panel.add(login);
        login.setBounds(165, 90, 75, 25);

        back = new JButton("<<Back");
        back.setBounds(95, 90, 75, 25);
        panel.add(back);


        success = new JLabel("");
        success.setBounds(100, 120, 300, 10);
        panel.add(success);

        frame.setVisible(true);
        ActionListener backbutton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccountLogin();
            }
        };
        back.addActionListener(backbutton);
        ActionListener Check = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Username = textField.getText();
                Password  = passwordText.getText();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
                    String line;
                    while((line=reader.readLine())!=null){
                            name = line.split(" ")[0];
                            pass = line.split(" ")[1];

                        if(Username.equals(name)&&Password.equals(pass)){
                            success.setText("You have an account");

                            JButton Continue = new JButton("Continue");
                            panel.add(Continue);
                            Continue.setBounds(120,140,80,20);
                            ActionListener startAgain = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame.setVisible(false);
                                    new TicTacToeGUI();
                                }
                            };
                            Continue.addActionListener(startAgain);
                            break;
                        }else {
                            success.setText("Incorrect Password or Username");
                        }
                    }
                    reader.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        };
        login.addActionListener(Check);

    }
}