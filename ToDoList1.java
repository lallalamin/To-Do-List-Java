import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

class Task extends JPanel{
    private boolean checked;

    JLabel index = new JLabel("");
    JTextField taskName = new JTextField("Type your task...");
    JButton done = new JButton("Button");

    Color pink = new Color(255, 161, 161);
    Color green = new Color(188, 226, 158);
    Color red = new Color(233, 119, 119);
    Color doneColor = new Color(89, 179, 94);

    Task(){
        this.setPreferredSize(new Dimension(400, 20));
        this.setBackground(pink);

        this.setLayout(new BorderLayout());

        checked = false;

        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(pink);
        this.add(taskName, BorderLayout.CENTER);

        done.setPreferredSize(new Dimension(80, 20));
        done.setBackground(red);
        done.setFocusPainted(false); 
        this.add(done, BorderLayout.EAST);
    }

    public void changeIndex(int num){
    this.index.setText(num + "");
    this.revalidate();
    }

    public JButton getDone(){
        return done;
    }

    public boolean getState(){
        return checked;
    }

    //Changing the state of the task
    public void changeState(){
        this.setBackground(green);
        taskName.setBackground(green);
        done.setBackground(doneColor);
        checked = true;
        revalidate(); // check on this
    }

}

class List extends JPanel{
    Color lightColor = new Color(245, 224, 157);

    List(){
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);

        this.setLayout(layout);
        this.setPreferredSize(new Dimension(400, 500));
        this.setBackground(lightColor);
    }

    public void updateNumbers(){
        Component[] listItems = this.getComponents();

        for(int i = 0; i < listItems.length; i ++){
            if(listItems[i] instanceof Task){
                ((Task) listItems[i]).changeIndex(i+1);
            }
        }
    }
    public void removeCompletedTasks(){
        for(Component c : getComponents()){
            if(c instanceof Task){
                if(((Task) c).getState()){
                    remove(c);
                    updateNumbers();
                }
            }
        }
    }
    public void clearAllTask(){
        for(Component c : getComponents()){
            if(c instanceof Task){
                remove(c);
            }
        }
    }
    
}
class Footer extends JPanel{
    JButton addTask;
    JButton clear;
    JButton clearAll;

    Color orange = new Color(233, 133, 128);
    Color lightColor = new Color(245, 224, 157);
    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer() {
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(lightColor);

        addTask = new JButton("Add Task");
        addTask.setFont(new Font("Sans-serif", Font.ITALIC, 20)); 
        addTask.setVerticalAlignment(JButton.BOTTOM); 
        this.add(addTask);

        this.add(Box.createHorizontalStrut(20));

        clear = new JButton("Clear finished tasks"); 
        clear.setFont(new Font("Sans-serif", Font.ITALIC, 20)); 
        this.add(clear); 

        this.add(Box.createHorizontalStrut(20));

        clearAll = new JButton("Clear All");
        clearAll.setFont(new Font("Sans-serif", Font.ITALIC, 20)); 
        this.add(clearAll);
    }

    public JButton getNewTask(){
        return addTask;
    }

    public JButton getClear(){
        return clear;
    }   

    public JButton getClearAll(){
        return clearAll;
    }
}

class TitleBar extends JPanel{
    Color lightColor = new Color(245, 224, 157);

    TitleBar(){
        this.setPreferredSize(new Dimension(400, 80)); 
        this.setBackground(lightColor); 
        JLabel titleText = new JLabel("To Do List"); 
        titleText.setPreferredSize(new Dimension(200, 60)); 
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20)); 
        titleText.setHorizontalAlignment(JLabel.CENTER); 
        this.add(titleText); 
    }
}

class AppFrame extends JFrame{
    private TitleBar title;
    private Footer footer;
    private List list;

    private JButton newTask;
    private JButton clear;
    private JButton clearAll;

    AppFrame(){
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        footer = new Footer();
        list = new List();

        this.add(title, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        newTask = footer.getNewTask();
        clear = footer.getClear();
        clearAll = footer.getClearAll();

        addListeners();
    }

    public void addListeners(){
        newTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Task task = new Task();
                list.add(task);
                list.updateNumbers();

                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        task.changeState();
                        list.updateNumbers();
                        revalidate();
                    }
                });
            }
        });

        clear.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                list.removeCompletedTasks();
                repaint();
            }
        });

        clearAll.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                list.clearAllTask();
                repaint();
            }
        });
    }
}

public class ToDoList1 {
    public static void main(String args[]){
        AppFrame frame = new AppFrame();
    }
}

