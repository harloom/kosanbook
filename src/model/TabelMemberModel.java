/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hx-loom
 */
public class TabelMemberModel extends AbstractTableModel {

    private List<Member> list = new ArrayList<Member>();

    public void setList(List<Member> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
               case 1:
                return "Kode";
            case 2:
                return "Nama";
            case 3:
                return "Jenis Kelamin";
            case 4:
                return "Tipe Kamar";
            case 5:
                return "Tipe Wifi";
            case 6:
                return "Total Biaya";
            case 7:
                return "Batas Waktu";
            default:
                return null;
        }
    }

    public boolean add(Member e) {

        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getColumnCount() - 1);
        }

    }

    public Member get(int index) {
        return list.get(index);
    }

    public Member set(int index, Member element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(getRowCount() - 1, getColumnCount() - 1);
        }
    }

    public Member remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StringBuffer sb = new StringBuffer(Integer.toString(list.get(rowIndex).getTotal()));

        switch (columnIndex) {
             case 0:
                return list.get(rowIndex).getId_member();
            case 1:
                return list.get(rowIndex).getNama();
//              case 1 : return  sb.toString();
            case 2:
                return list.get(rowIndex).getJenis_kelamin();
            case 3:
                return list.get(rowIndex).getTipe_kamar();
            case 4:
                return list.get(rowIndex).getTipe_wifi();
            case 5:
                return list.get(rowIndex).getTotal();
            case 6:
                return list.get(rowIndex).getExpire();
            default:
                return null;
        }
    }

}
