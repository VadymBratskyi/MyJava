/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package face;

import mydatabase.SelRows;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

/**
 *
 * @author Vadym
 */
public class Table extends JTable{

    public Table() {
        super.setAutoCreateRowSorter(true);
        super.setDefaultRenderer(Integer.class, new SelRows());
        super.setDefaultRenderer(String.class, new SelRows());
        super.setDefaultRenderer(Date.class, new SelRows());
        super.setDefaultRenderer(Float.class, new SelRows());
        super.setDefaultRenderer(Double.class, new SelRows());
        super.setPreferredScrollableViewportSize(new Dimension(1300, 300));
    }
}
