import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.BorderFactory.createEmptyBorder;

public class DashboardGUI {
    private JFrame f;
    private GUIController controller;
    private List<String> statistics;
    private DefaultListModel<String> listModel; //for list actions
    private JTextArea details; //Text area
    private final String searchPlaceholder = "Search All...";


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
        JButton bShowAll = new JButton("Display All Patient");
        JButton bReadCsv = new JButton("Load From CSV");
        JButton bReadJson = new JButton("Load From Json");
        JButton bSaveJson = new JButton("Save to Json");
//        b.setBounds(130, 100, 100, 40);

        pNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
//        pNorth.setBorder(BorderFactory.createEmptyBorder(5, 80, 5, 80));

        pNorth.add(bShowAll);
        pNorth.add(bReadCsv);
        pNorth.add(bReadJson);
        pNorth.add(bSaveJson);

        bShowAll.setVisible(false);
//        pNorth.setPreferredSize(new Dimension(900, 50));

        //--------------------West


        pWest.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
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
        JButton bClearSearch = new JButton("Clear Search");
        JTextField text = new JTextField(searchPlaceholder,10);
        bottomLeft.add(text);
        bottomLeft.add(bSearch);
        bottomLeft.add(bClearSearch);
        bClearSearch.setVisible(false);

        JPanel bottomCenter = new JPanel();
        bottomCenter.add(new JLabel("Henry Zhang"));

        JPanel bottomRight = new JPanel();
        bottomRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomRight.add(new JLabel("Henry Zhang"));

        pSouth.add(bottomLeft);
//        pSouth.add(bottomCenter);
        pSouth.add(bottomRight);


//        pSouth.setPreferredSize(new Dimension(900, 50));
        pSouth.setBorder(createEmptyBorder(0, 5, 0, 5));


        //---------------------Center

        details = new JTextArea("Load Patient File to Begin");
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
        f.setSize(950, 650);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


        //----------------------Actions

        bReadCsv.addActionListener((ActionEvent e) -> loadFile(controller.FILE_CSV));
        bReadJson.addActionListener((ActionEvent e) -> loadFile(controller.FILE_JSON));
        bSaveJson.addActionListener((ActionEvent e) -> saveTo());
        bSearch.addActionListener((ActionEvent e) -> {if (doSearch(text.getText())) { bClearSearch.setVisible(true);}});
        bClearSearch.addActionListener((ActionEvent e) ->{
            text.setText(searchPlaceholder);
            bClearSearch.setVisible(false);
            controller.clearSearch();
            refreshList();
        });
        bShowAll.addActionListener((ActionEvent e) -> {
            details.setText(controller.getAllJson());
            list.clearSelection();
            bShowAll.setVisible(false);
        });
        text.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(text.getText().equals(searchPlaceholder)){
                    text.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(text.getText().equals("")){
                    text.setText(searchPlaceholder);
                }
            }
        });

        list.addListSelectionListener((ListSelectionEvent e) -> {
                if(list.getSelectedIndex() != -1) {
                    details.setText(controller.getPatientJson(list.getSelectedIndex()));
                    bShowAll.setVisible(true);
                }
            }
        );



    }

    private void loadFile(int fileType){
        String path = fileChooser(FileDialog.LOAD);
        if(path == null) {
            return;
        }
        if(controller.LoadPatients(path, fileType)) {
            if(controller.checkLoadedPatientName()){
                int confirmDialog = JOptionPane.showConfirmDialog(null,
                        "The file loaded doesn't seems to be a correct patient file, \nthis might cause errors. Do you wish to proceed anyway?",
                        "Warning", JOptionPane.YES_NO_OPTION);
                if (confirmDialog != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            JDialog dialog = showLoading(f);

            //Show loading while load
            new Thread(new Runnable() {
                @Override
                public void run() {
                    refreshList();
                    dialog.dispose();
                }
            }).start();

            statistics = controller.getStatistics();
            showStatistics();

            dialog.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(f, "Fail to Load file, please check whether the file's content is valid, \nor whether the file type match your selection.",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }



    private boolean doSearch(String text){
        if(text.equals(searchPlaceholder)){
            JOptionPane.showMessageDialog(f, "Please enter your search query. You can search for any data.", "Notice", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(!controller.searh(text)){
            JOptionPane.showMessageDialog(f, "No result found for \"" + text + "\".", "Notice", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        refreshList();
        return true;
    }

    private void refreshList(){
        listModel.clear();
        listModel.addAll(controller.getPatientNames());
        details.setText(controller.getAllJson());
    }

    private void saveTo(){
        String path = fileChooser(FileDialog.SAVE);
        if(path == null){
            return;
        }

        String msg;
        if(controller.saveJsonTo(path)){
            msg = "All patients detail saved successfully!";
        }else {
            msg = "Warning! Fail to save file.";
        }
        JOptionPane.showMessageDialog(f, msg, "Notice", JOptionPane.INFORMATION_MESSAGE);

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
        final JOptionPane optionPane = new JOptionPane("Loading, please wait...", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null); //create an empty loading dialog
        return optionPane.createDialog(f, "Notice");

    }

    private void showStatistics(){
        Timer timer = new Timer();
        int index = 0;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(statistics.get(controller.getStatisticIndex()));
            }
        };

        timer.schedule(task, 1000,3000);
    }


    public static void main(String[] args) {
        new DashboardGUI();
    }
}
