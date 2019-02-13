package com.github.benchdoos.gui;

import com.github.benchdoos.beans.DefaultThemes;
import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.core.JColorful;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindow extends JFrame {
    private Theme current = DefaultThemes.EXTREMELY_BLACK;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JFormattedTextField formattedTextField1;
    private JTextArea awdawdadwdaTextArea;
    private JTextPane dwaddawdTextPane;
    private JEditorPane helloEditorPane;
    private JTable table1;
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JSlider slider1;
    private JProgressBar progressBar1;
    private JScrollBar scrollBar1;
    private JLabel currentThemeLabel;
    private JRadioButton radioButton1;
    private JCheckBox checkBox1;
    private JList list1;
    private JComboBox comboBox1;
    private JTree tree1;
    private JComboBox comboBox2;
    private JProgressBar stringProgressBar;
    private JProgressBar intermediateProgressBar;
    private JRadioButton radioButton2;
    private JButton donatePaypalButton;

    TestWindow() {
        initGui();
        initData();
        initButtons();
        slider1.setValue(50);
    }

    private void initData() {
        final DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("First column", new String[]{"hello","world"});
        defaultTableModel.addColumn("Second column", new String[]{"goodbye","hell"});
        table1.setModel(defaultTableModel);
    }

    private void initButtons() {
        scrollBar1.addAdjustmentListener(e -> {
            progressBar1.setValue(e.getValue());
            slider1.setValue(e.getValue());
            spinner1.setValue(e.getValue());
            stringProgressBar.setValue(e.getValue());
            intermediateProgressBar.setValue(e.getValue());
        });
    }

    private void initGui() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setSize(new Dimension(800,400));

        currentThemeLabel.setText(current.getName());
    }

    private void onOK() {
        if (current.equals(DefaultThemes.EXTREMELY_BLACK)) {
            current = DefaultThemes.DARK_GRAY;
            new JColorful(DefaultThemes.DARK_GRAY).colorize(this);
        } else {
            current = DefaultThemes.EXTREMELY_BLACK;
            new JColorful(DefaultThemes.EXTREMELY_BLACK).colorize(this);
        }

        currentThemeLabel.setText(current.getName());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
