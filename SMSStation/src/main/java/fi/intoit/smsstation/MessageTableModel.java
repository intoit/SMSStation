/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
/**
 * Model for showing all messages in Store
 * @author lasa
 */
public class MessageTableModel extends AbstractTableModel {
    private SMSStore store;
    
    public MessageTableModel(SMSStore store) {
        this.store = store;
    }
    @Override
    public int getRowCount() {
        return store.getNumberOfMessages();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        String name = "XXXXX";
        switch (column) {
            case 0:
                name = "Timestamp";
                break;
            case 1:
                name = "Status";
                break;
            case 2:
                name = "Content";
                break;
            case 3:
                name = "To number";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
                //type = Date.class;
                break;
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SMS message = store.getMessage(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = message.getCreated();
                break;
            case 1:
                value = message.getStatus();
                break;
            case 2:
                value = message.getContent();
                break;
            case 3:
                value = message.getToNumber();
                break;
        }
        return value;
    }            
}
