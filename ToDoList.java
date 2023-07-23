import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ToDoList extends JFrame{
    final private Font mainFont = new Font("SansSerif", Font.BOLD, 20);
    final private Font subFont = new Font("SansSerif", Font.BOLD, 10);
     public static void main(String[] args){
        ToDoList myToDoList = new ToDoList();
        myToDoList.initialize();
    }

    public void initialize(){
        setTitle("To-Do List");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        /*********** Title Panel ***********/
        JLabel lbTitle = new JLabel("My To-Do List", JLabel.CENTER);
        lbTitle.setFont(mainFont);

        /*********** Task Panel ***********/


        /*********** Action Panel ***********/
        JButton add = new JButton("Add");
        add.setFont(mainFont);
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { 
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
                
        JButton delete = new JButton("Delete");
        delete.setFont(mainFont);
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });

        JButton clearAll = new JButton("Clear All");
        clearAll.setFont(mainFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(add);
        buttonPanel.add(delete);
        buttonPanel.add(clearAll);


        JLabel message = new JLabel("Hello! Press the button what you want to do!");

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(250, 40));

        JButton okButton = new JButton("OK");
        okButton.setFont(subFont);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 2, 5, 5));
        textPanel.setOpaque(false);
        textPanel.add(input);
        textPanel.add(okButton);

        //This is combining the message, text box input and action button together in a row
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(3, 1, 5, 5));
        actionPanel.setOpaque(false);
        actionPanel.add(message);
        actionPanel.add(textPanel);
        actionPanel.add(buttonPanel);


        /*********** Main Panel ***********/
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(160, 218, 163));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10 ,10, 10, 10));
        mainPanel.add(lbTitle, BorderLayout.NORTH);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

}
