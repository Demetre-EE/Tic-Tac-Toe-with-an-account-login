import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AccountLogin implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //Login or Sign up Page
    private static JLabel choose;
    private static JButton Login;
    private static JButton SignUp;


    public AccountLogin() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Account Management");

        panel.setLayout(null);

        choose = new JLabel("Login or Sign up: ");
        panel.add(choose);
        choose.setBounds(125, 20, 200, 50);

        Login = new JButton("Login");
        panel.add(Login);
        Login.setBounds(70, 75, 100, 50);

        SignUp = new JButton("Sign Up");
        panel.add(SignUp);
        SignUp.setBounds(180, 75, 100, 50);

        frame.setVisible(true);

            ActionListener buttonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new Login();
                }
            };
            ActionListener buttonListener2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        new signUp();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    frame.setVisible(false);
                }
            };
            Login.addActionListener(buttonListener);
            SignUp.addActionListener(buttonListener2);
        }

    public static void main(String[] args) {
        new AccountLogin();
    }

}