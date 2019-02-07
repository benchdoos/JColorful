package com.github.benchdoos.managers;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTableElement;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class JTableManager implements Manager {
    private Theme theme;

    public JTableManager(Theme theme) {
        this.theme = theme;
    }

    private void paintCellEditor(JTable table, JTableElement tableElement) {
        final TableCellEditor cellEditor = table.getCellEditor(0, 0);
        if (cellEditor != null) {
            Component editor = cellEditor.getTableCellEditorComponent(table, table.getValueAt(0, 0),
                    0 == table.getSelectedRow() && 0 == table.getSelectedColumn(), 0, 0);
            if (editor != null) {
                final BinaryElement element = tableElement.getEditor();
                if (element != null) {
                    editor.setBackground(element.getBackgroundColor());
                    editor.setForeground(element.getForegroundColor());
                }
            }
        }
    }

    public void paintComponent(Component c) {

        if (c instanceof JTable) {
            JTable table = (JTable) c;


            final JTableElement tableElement = theme.getTableElement();

            if (tableElement != null) {
                paintHeader(table, tableElement);

                paintSelectedRow(table, tableElement);

                paintRow(table, tableElement);

                paintCellEditor(table, tableElement);
            }
        }
    }

    private void paintHeader(JTable table, JTableElement tableElement) {
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setOpaque(false);//remove look and feel

        final BinaryElement header = tableElement.getHeader();
        if (header != null) {
            tableHeader.setBackground(header.getBackgroundColor());
            tableHeader.setForeground(header.getForegroundColor());
        }
    }

    private void paintRow(JTable component, JTableElement tableElement) {
        final BinaryElement row = tableElement.getRow();
        if (row != null) {
            component.setBackground(row.getBackgroundColor());
            component.setForeground(row.getForegroundColor());
        }
    }

    private void paintSelectedRow(JTable component, JTableElement tableElement) {
        final BinaryElement selectedRow = tableElement.getSelectedRow();
        if (selectedRow != null) {
            component.setSelectionBackground(selectedRow.getBackgroundColor());
            component.setSelectionForeground(selectedRow.getForegroundColor());
        }
    }
}
