import javax.swing.*;
import java.awt.*;

public class DashboardGUI {
    private JFrame f;
    DashboardGUI() {
        //test, src = https://www.javatpoint.com/java-swing
        f = new JFrame(); //creating instance of JFrame
        JPanel panelMain = new JPanel();
        JPanel pWest = new JPanel();
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();

        JButton bReadCsv = new JButton("Load From CSV");
        JButton bReadJson = new JButton("Load From Json");
        JButton bSaveJson = new JButton("Save to Json");
//        b.setBounds(130, 100, 100, 40);

        pNorth.setLayout(new GridLayout(1, 3,20,20));
        pNorth.setBorder(BorderFactory.createEmptyBorder(5, 80, 5, 80));

        pNorth.add(bReadCsv);
        pNorth.add(bReadJson);
        pNorth.add(bSaveJson);

//        pNorth.setPreferredSize(new Dimension(900, 50));


        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","asdasd"};
        JList list = new JList(week);


        list.setPreferredSize(new Dimension(200, 650));

        pWest.add(list);
//        pWest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pWest.setBackground(Color.WHITE);

        panelMain.setLayout(new BorderLayout());
        panelMain.add(pNorth, BorderLayout.NORTH);
        panelMain.add(pWest, BorderLayout.WEST);



        f.add(panelMain);
        f.setSize(900, 650);//400 width and 500 height
        f.setVisible(true);//making the frame visible


    }

    public static void main(String[] args) {
        new DashboardGUI();
    }
}
