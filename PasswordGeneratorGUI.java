import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class PasswordGeneratorGUI extends JFrame {

    public PasswordGenerator passwordGenerator;
    
    public PasswordGeneratorGUI(){
        super("Password Generator");

        setSize(540,570);

        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator = new PasswordGenerator();

        //render GUI commponents
        addGuiComponents();
    }

    private void addGuiComponents(){
        //create title text
        JLabel titleLabel =new JLabel("Password Generator");

        //increase the font size and make it bold
        titleLabel.setFont(new FontUIResource("Dialog", Font.BOLD,32));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0,10,540,39);

        //Add to GUI
        add(titleLabel); 

        //create result text area
        JTextArea passwordOutput =new JTextArea();

        //prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        //add scrollability in case output becomes to big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);

        //create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);


        //create password length label
        JLabel passwordLengthJLabel=new JLabel("Password Length");
        passwordLengthJLabel.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthJLabel.setBounds(25,215,272,39);
        add(passwordLengthJLabel);


        //create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);



        //create toggle buttons
        //uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        //lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        //number toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        //Sysmbol toggle
        JToggleButton sysmbolToggle = new JToggleButton("Symbol");
        sysmbolToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        sysmbolToggle.setBounds(282,373,225,56);
        add(sysmbolToggle);


        //create a generate button
        JButton generateButton= new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //validation: generate a password only when length >  amd one of the toggled buttons is pressed

                if (passwordLengthInputArea.getText().length() <= 0) return;
                    boolean anyToggleSelected =lowercaseToggle.isSelected() ||
                            uppercaseToggle.isSelected() ||
                            numbersToggle.isSelected() ||
                            sysmbolToggle.isSelected();

                //generate password
                //convert the text to an integer value

                int passwordlength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected) {
                    String generatedPassword =passwordGenerator.generatePassword(passwordlength,
                    uppercaseToggle.isSelected(),
                    lowercaseToggle.isSelected(),
                    numbersToggle.isSelected(),
                    sysmbolToggle.isSelected());

                    //display password back to the user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}
