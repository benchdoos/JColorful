package com.github.benchdoos.gui;

import com.github.benchdoos.beans.DefaultThemes;
import com.github.benchdoos.core.JColorful;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TestWindow extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton radioButton1;
    private JCheckBox checkBox1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JFormattedTextField formattedTextField1;
    private JTextArea awdawdadwdaTextArea;
    private JTextPane dwaddawdTextPane;
    private JEditorPane helloEditorPane;
    private JComboBox comboBox1;
    private JTable table1;
    private JList list1;
    private JTabbedPane tabbedPane1;
    private JTree tree1;
    private JSpinner spinner1;
    private JSlider slider1;
    private JProgressBar progressBar1;
    private JScrollBar scrollBar1;

    public TestWindow() {
        initGui();
        initButtons();
        initData();
    }

    private void initData() {
        final DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("First column", new String[]{"hello","world"});
        defaultTableModel.addColumn("Second column", new String[]{"goodbye","hell"});
        table1.setModel(defaultTableModel);
    }

    private void initButtons() {
        scrollBar1.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                progressBar1.setValue(e.getValue());
                slider1.setValue(e.getValue());
                spinner1.setValue(e.getValue());
            }
        });
    }

    private void initGui() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setSize(new Dimension(800,400));
    }

    private void onOK() {
        new JColorful(DefaultThemes.GRAY).colorize(this);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
