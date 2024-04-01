import javax.swing.*;
import java.awt.event.*;

public class QueueManagementSystem extends JFrame implements ActionListener {
    private JButton addButton, callButton, viewButton;
    private JTextArea queueTextArea;
    private int[] queue;
    private int front, rear;

    public QueueManagementSystem() {
        setTitle("Queue Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        addButton = new JButton("Add Customer");
        addButton.setBounds(50, 30, 150, 30);
        addButton.addActionListener(this);
        add(addButton);

        callButton = new JButton("Call Next Customer");
        callButton.setBounds(50, 80, 150, 30);
        callButton.addActionListener(this);
        add(callButton);

        viewButton = new JButton("View Queue");
        viewButton.setBounds(50, 130, 150, 30);
        viewButton.addActionListener(this);
        add(viewButton);

        queueTextArea = new JTextArea();
        queueTextArea.setBounds(220, 30, 150, 200);
        add(queueTextArea);

        queue = new int[100];
        front = rear = -1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (rear == queue.length - 1) {
                JOptionPane.showMessageDialog(this, "Queue is full!");
            } else {
                rear++;
                queue[rear] = rear + 1;
                if (front == -1) {
                    front++;
                }
                JOptionPane.showMessageDialog(this, "Customer added to queue: " + queue[rear]);
            }
        } else if (e.getSource() == callButton) {
            if (front == -1) {
                JOptionPane.showMessageDialog(this, "Queue is empty!");
            } else {
                JOptionPane.showMessageDialog(this, "Calling next customer: " + queue[front]);
                if (front == rear) {
                    front = rear = -1;
                } else {
                    front++;
                }
            }
        } else if (e.getSource() == viewButton) {
            if (front == -1) {
                queueTextArea.setText("Queue is empty!");
            } else {
                StringBuilder queueContent = new StringBuilder("Queue: ");
                for (int i = front; i <= rear; i++) {
                    queueContent.append(queue[i]).append(" ");
                }
                queueTextArea.setText(queueContent.toString());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QueueManagementSystem app = new QueueManagementSystem();
            app.setVisible(true);
        });
    }
}
