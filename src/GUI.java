import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GUI extends  Main
{
    private JPanel rootPanel;
    private JTextField inputField;
    private JButton submitButton,recursionMemoizationButton;
    private JLabel fibOutputLabel,nanoTimeOutputLabel, secondsTimeOutputLabel;

    public GUI() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                OutputFibonacciNum(false);
            }
        });
        recursionMemoizationButton.addActionListener(new ActionListener(){
            @Override
            public  void actionPerformed(ActionEvent e)
            {
                OutputFibonacciNum(true);
            }
        });
    }

    void OutputFibonacciNum(boolean memoization)
    {
        FibonacciSequence fib = new FibonacciSequence();
        int i  = 0;
        if(!inputField.getText().isEmpty())
            i = Integer.parseInt(inputField.getText());

        if(i > 0 && i < 101)
        {
            long startTime = System.nanoTime();
            fibOutputLabel.setText(Double.toString(fib.GetFib(i,memoization)));
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            nanoTimeOutputLabel.setText(Long.toString(elapsedTime));
            secondsTimeOutputLabel.setText(Long.toString(TimeUnit.SECONDS.convert(elapsedTime,TimeUnit.NANOSECONDS)));
        }
        else
            fibOutputLabel.setText("Only numbers between 1-100 can be processed");
    }

    public void DrawFrame() {
        JFrame frame = new JFrame("Recursive Fibonacci Calculator");
        frame.setContentPane(new GUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550,190));
        frame.pack();
        frame.setVisible(true);
    }

}

