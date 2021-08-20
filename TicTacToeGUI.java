import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class TicTacToeGUI {
    JPanel panel;

    JButton topLeft;
    JButton topMid;
    JButton topRight;
    JButton midLeft;
    JButton midMid;
    JButton midRight;
    JButton botLeft;
    JButton botMid;
    JButton botRight;
    JLabel winner;
    JButton retry;
    JButton logOut;
    JLabel ScoreKeep;

    String line;

    Random random = new Random();

    public TicTacToeGUI()  {
        load();
        JFrame frame = new JFrame();
        panel = new JPanel();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Tic Tac Toe");
        panel.setLayout(null);

        ScoreKeep = new JLabel("User Score is: "+signUp.score);
        panel.add(ScoreKeep);
        ScoreKeep.setBounds(275,50,300,40);


        winner = new JLabel(" ");
        panel.add(winner);
        winner.setBounds(250,450,300,75);

        retry = new JButton("Retry");
        retry.setBounds(250,500,75,20);

        logOut = new JButton("<<Log Out");
        panel.add(logOut);
        logOut.setBounds(100,500,75,20);

        ActionListener signOut = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save();
                new AccountLogin();
                frame.setVisible(false);
            }
        };
        logOut.addActionListener(signOut);



        ActionListener again = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        };
        retry.addActionListener(again);

        topLeft = new JButton(" ");
        panel.add(topLeft);
        topLeft.setBounds(100, 75, 100, 100);

        ActionListener TOPLEFT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(topLeft.getText().equals(" ")) {
                    topLeft.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        topLeft.addActionListener(TOPLEFT);

        topMid = new JButton(" ");
        panel.add(topMid);
        topMid.setBounds(250, 75, 100, 100);

        ActionListener TOPMID = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(topMid.getText().equals(" ")) {
                    topMid.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        topMid.addActionListener(TOPMID);

        topRight = new JButton(" ");
        panel.add(topRight);
        topRight.setBounds(400, 75, 100, 100);

        ActionListener TOPRIGHT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(topRight.getText().equals(" ")) {
                    topRight.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        topRight.addActionListener(TOPRIGHT);


        midLeft = new JButton(" ");
        panel.add(midLeft);
        midLeft.setBounds(100, 225, 100, 100);

        ActionListener MIDLEFT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(midLeft.getText().equals(" ")) {
                    midLeft.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        midLeft.addActionListener(MIDLEFT);

        midMid = new JButton(" ");
        panel.add(midMid);
        midMid.setBounds(250, 225, 100, 100);

        ActionListener MIDMID = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(midMid.getText().equals(" ")) {
                    midMid.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        midMid.addActionListener(MIDMID);

        midRight = new JButton(" ");
        panel.add(midRight);
        midRight.setBounds(400, 225, 100, 100);

        ActionListener MIDRIGHT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(midRight.getText().equals(" ")) {
                    midRight.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        midRight.addActionListener(MIDRIGHT);

        botLeft = new JButton(" ");
        panel.add(botLeft);
        botLeft.setBounds(100, 375, 100, 100);

        ActionListener BOTLEFT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(botLeft.getText().equals(" ")) {
                    botLeft.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        botLeft.addActionListener(BOTLEFT);

        botMid = new JButton(" ");
        panel.add(botMid);
        botMid.setBounds(250, 375, 100, 100);

        ActionListener BOTMID = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(botMid.getText().equals(" ")) {
                    botMid.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        botMid.addActionListener(BOTMID);

        botRight = new JButton(" ");
        panel.add(botRight);
        botRight.setBounds(400, 375, 100, 100);

        ActionListener BOTRIGHT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(botRight.getText().equals(" ")) {
                    botRight.setText("X");
                    int cpuPos = random.nextInt(9) + 1;
                    CPU(cpuPos);
                }
                CheckWinner();
            }
        };
        botRight.addActionListener(BOTRIGHT);

        frame.setVisible(true);


    }

    public void CPU(int cpuPos){
        switch (cpuPos){
            case 1:
                if(topLeft.getText().equals(" ")) {
                    topLeft.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 2:
                if(topMid.getText().equals(" ")) {
                    topMid.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 3:
                if(topRight.getText().equals(" ")) {
                    topRight.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 4:
                if(midLeft.getText().equals(" ")) {
                    midLeft.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 5:
                if(midMid.getText().equals(" ")) {
                    midMid.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 6:
                if(midRight.getText().equals(" ")) {
                    midRight.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 7:
                if(botLeft.getText().equals(" ")) {
                    botLeft.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 8:
                if(botMid.getText().equals(" ")) {
                    botMid.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            case 9:
                if(botRight.getText().equals(" ")) {
                    botRight.setText("O");
                }else {
                    cpuPos = random.nextInt(9)+1;
                    CPU(cpuPos);
                }
                break;
            default:
                break;
        }
    }
    public void CheckWinner(){
        if((topLeft.getText().equals("X")&&topMid.getText().equals("X")&&topRight.getText().equals("X"))||
                (midLeft.getText().equals("X")&&midMid.getText().equals("X")&&midRight.getText().equals("X"))||
                botLeft.getText().equals("X")&&botMid.getText().equals("X")&&botRight.getText().equals("X")||
                (topLeft.getText().equals("X")&&midLeft.getText().equals("X")&&botLeft.getText().equals("X"))||
                (topMid.getText().equals("X")&&midMid.getText().equals("X")&&botMid.getText().equals("X"))||
                (topRight.getText().equals("X")&&midRight.getText().equals("X")&&botRight.getText().equals("X"))||
                (topLeft.getText().equals("X")&&midMid.getText().equals("X")&&botRight.getText().equals("X"))||
                (topRight.getText().equals("X")&&midMid.getText().equals("X")&&botLeft.getText().equals("X"))){

            panel.add(retry);
            winner.setText("Congrats, You Won!!");
            Winner();
            readScore();


        }else if((topLeft.getText().equals("O")&&topMid.getText().equals("O")&&topRight.getText().equals("O"))||
                (midLeft.getText().equals("O")&&midMid.getText().equals("O")&&midRight.getText().equals("O"))||
                botLeft.getText().equals("O")&&botMid.getText().equals("O")&&botRight.getText().equals("O")||
                (topLeft.getText().equals("O")&&midLeft.getText().equals("O")&&botLeft.getText().equals("O"))||
                (topMid.getText().equals("O")&&midMid.getText().equals("O")&&botMid.getText().equals("O"))||
                (topRight.getText().equals("O")&&midRight.getText().equals("O")&&botRight.getText().equals("O"))||
                (topLeft.getText().equals("O")&&midMid.getText().equals("O")&&botRight.getText().equals("O"))||
                (topRight.getText().equals("O")&&midMid.getText().equals("O")&&botLeft.getText().equals("O"))){

            winner.setText("You Lost!!");
            panel.add(retry);
            Loser();
            readScore();

        }
        else if(!topLeft.getText().equals(" ")&&!topMid.getText().equals(" ")&&!topRight.getText().equals(" ")&&
                !midLeft.getText().equals(" ")&&!midMid.getText().equals(" ")&&!midRight.getText().equals(" ")&&
                !botLeft.getText().equals(" ")&&!botMid.getText().equals(" ")&&!botRight.getText().equals(" ")){

            winner.setText("Tie!!");
            panel.add(retry);
            readScore();
        }
    }
    public void readScore(){

        ScoreKeep.setText("User Score is "+ signUp.score);
    }
    public void Winner(){
        signUp.score ++;

    }
    public void Loser(){
        signUp.score --;
    }
    public void restart(){

        topLeft.setText(" ");
        topMid.setText(" ");
        topRight.setText(" ");
        midLeft.setText(" ");
        midMid.setText(" ");
        midRight.setText(" ");
        botLeft.setText(" ");
        botMid.setText(" ");
        botRight.setText(" ");
        winner.setText(" ");

    }
    public void save(){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            PrintWriter print = new PrintWriter(new FileWriter("database.txt",false));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String username = line.split(" ")[0];
                String lineArray [] = line.split(" ");
                if (username.equals(Login.Username)) {
                    lineArray[2] = signUp.score +"";
                    print.println(Arrays.toString(lineArray));

                }else{
                    print.println(line);
                }
            }

            print.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));

            while ((line = reader.readLine()) != null) {
                String username = line.split(" ")[0];
                if (username.equals(Login.Username)) {
                    String Score = line.split(" ")[2];
                    signUp.score = Integer.parseInt(Score);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
