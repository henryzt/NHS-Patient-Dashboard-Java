import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.BorderFactory.createEmptyBorder;

public class DashboardGUI {
    private JFrame f;
    private GUIController controller;


    DashboardGUI() {

        controller = new GUIController();

        f = new JFrame(); //creating instance of JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelMain = new JPanel();
        JPanel pWest = new JPanel();
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();
        JPanel pEast = new JPanel();


        //----------North
        JButton bReadCsv = new JButton("Load From CSV");
        JButton bReadJson = new JButton("Load From Json");
        JButton bSaveJson = new JButton("Save to Json");
//        b.setBounds(130, 100, 100, 40);

        pNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
//        pNorth.setBorder(BorderFactory.createEmptyBorder(5, 80, 5, 80));

        pNorth.add(bReadCsv);
        pNorth.add(bReadJson);
        pNorth.add(bSaveJson);

//        pNorth.setPreferredSize(new Dimension(900, 50));

        //--------------------West


        pWest.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        JScrollPane spList = new JScrollPane();
        spList.setViewportView(list);
        spList.setBorder(createEmptyBorder());

        Dimension d = spList.getPreferredSize();
        d.width = 240;
        spList.setPreferredSize(d);

        pWest.add(spList,BorderLayout.CENTER);
        pWest.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        pWest.setBackground(Color.WHITE);



        //---------------------South
        pSouth.setLayout(new GridLayout(1, 3,20,20));

        JPanel bottomLeft = new JPanel();
        bottomLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton bSearch = new JButton("Search");
        JTextField text = new JTextField("Search...",10);
        bottomLeft.add(text);
        bottomLeft.add(bSearch);

        JPanel bottomCenter = new JPanel();
        bottomCenter.add(new JLabel("Henry Zhang"));

        JPanel bottomRight = new JPanel();
        bottomRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomRight.add(new JLabel("Total Patient - 100"));

        pSouth.add(bottomLeft);
//        pSouth.add(bottomCenter);
        pSouth.add(bottomRight);


//        pSouth.setPreferredSize(new Dimension(900, 50));
        pSouth.setBorder(createEmptyBorder(0, 5, 0, 5));


        //---------------------Center

        JTextArea details = new JTextArea("Load Patient File to Begin...");
        details.setWrapStyleWord(true);
        JScrollPane spText = new JScrollPane();
        spText.setViewportView(details);
        spText.setBorder(createEmptyBorder());

        pEast.setBorder(createEmptyBorder(0, 5, 0, 0));
        pEast.setLayout(new BorderLayout());
        pEast.add(spText);




        //---------------------All
        panelMain.setLayout(new BorderLayout());
        panelMain.add(pNorth, BorderLayout.NORTH);
        panelMain.add(pWest, BorderLayout.WEST);
        panelMain.add(pSouth , BorderLayout.SOUTH);
        panelMain.add(pEast , BorderLayout.CENTER);



        f.add(panelMain);
        f.setSize(900, 650);
        f.setVisible(true);


        //----------------------Actions

        bReadCsv.addActionListener((ActionEvent e) -> {
                String path = fileChooser(FileDialog.LOAD);
                if(path != null){
                    if(controller.LoadPatients(path)) {
                        JDialog dialog = showLoading(f);

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                listModel.clear();
                                listModel.addAll(controller.getPatientNames());
                                details.setText(controller.getAllJson());
                                dialog.dispose();
                            }
                        }).start();

                        dialog.setVisible(true);



                    }else{
                        JOptionPane.showMessageDialog(f, "Fail to Load file, please check whether the file's content is valid.",
                                "File Error",
                                JOptionPane.ERROR_MESSAGE);

                    }

                }
            });


        list.addListSelectionListener((ListSelectionEvent e) -> {
                if(list.getSelectedIndex() != -1) {
                    details.setText(controller.getPatientJson(list.getSelectedIndex()));
                }
            }
        );



    }


    private String fileChooser(int mode){
        FileDialog dialog = new FileDialog(f, "Select a File Path");
        dialog.setMode(mode);
        dialog.setVisible(true);
        String file = dialog.getFile();
        if(file == null){
            return null;
        }
        return dialog.getDirectory() + file;
    }

    private JDialog showLoading(JFrame f){
        final JOptionPane optionPane = new JOptionPane("Loading...Please wait", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null); //create an empty loading dialog
        return optionPane.createDialog(f, "Notice");

    }



    public static void main(String[] args) {
        new DashboardGUI();
    }
}
