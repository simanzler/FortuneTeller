import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    ImageIcon icon;
    JLabel topLbl;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton fortBtn;
    JButton quitBtn;
    int prevIndex;

    public FortuneTellerFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottonPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setTitle("Fortune Teller");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize((int) (screenSize.width*.75),(int) (screenSize.height*.75));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void createTopPanel(){
        topPnl = new JPanel();
        icon = new ImageIcon("src/FortuneTellerIcon.jpg");
        ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(300,200, Image.SCALE_SMOOTH));
        topLbl = new JLabel("Fortune Teller", scaledIcon ,JLabel.CENTER);
        topLbl.setFont(new Font("Serif", Font.BOLD, 36));
        topLbl.setVerticalTextPosition(JLabel.BOTTOM);
        topLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(topLbl);
    }
    private void createMiddlePanel(){
        middlePnl = new JPanel();
        textArea = new JTextArea(6,50);
        textArea.setFont(new Font("Serif", Font.PLAIN, 12));
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.createVerticalScrollBar();

        middlePnl.add(scrollPane);
    }
    private void createBottonPanel(){
        bottomPnl = new JPanel();
        fortBtn = new JButton("Read My Fortune");
        quitBtn = new JButton("Quit");

        bottomPnl.add(fortBtn);
        bottomPnl.add(quitBtn);

        fortBtn.addActionListener((ActionEvent ae) -> {
            int index;
            ArrayList<String> fortList = new ArrayList<>(Arrays.asList(
                    "Don’t hold onto things that require a tight grip.",
                    "There is nothing stronger than a broken person who has rebuilt themselves.",
                    "Little by little, one travels far.",
                    "What good are wings, without the courage to fly.",
                    "All we have to decide is what to do with the time that is given to us.",
                    "If you want the rainbow, you gotta put up with the rain!",
                    "It's only after we've lost everything that we're free to do anything.",
                    "One bad chapter doesn't mean your story is over.",
                    "It is never too late to be what you might have been.",
                    "The most effective way to do it, is to do it.",
                    "Do not let making a living prevent you from making a life.",
                    "The road to success is always under construction."
            ));

            Random random = new Random();
            index = random.nextInt(11) + 1;
            while(index == prevIndex){
                index = random.nextInt(11) + 1;
            }
            if(textArea.getText() != ""){
                textArea.append("\n");
            }
            textArea.append(fortList.get(index));
            prevIndex = index;
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
