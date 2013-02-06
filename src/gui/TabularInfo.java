package gui;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import db.DbHandler;
import db.Chennel;

@SuppressWarnings("serial")
public class TabularInfo extends JPanel implements TableModelListener {
	
	public TabularInfo() {
		super(new GridLayout());
		
		String[] columnNames = {
			"ID",
			"Name",
            "Number"
		};

		Object[][] data = DbHandler.getChennelList();
		
		final JTable dataTable = new JTable(data, columnNames);
		dataTable.setPreferredScrollableViewportSize(new Dimension(400, 70));
		dataTable.setFillsViewportHeight(true);
		dataTable.getModel().addTableModelListener(this);
		
		JScrollPane jscrolPane = new JScrollPane(dataTable);
		add(jscrolPane);
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		TableModel model = (TableModel) e.getSource();
		
		Integer id = (Integer) model.getValueAt(0, 0);
		String name = (String) model.getValueAt(0, 1);
		String number = (String) model.getValueAt(0, 2);
		
		try {
			Chennel ch = new Chennel(name, number);
			ch.setId(id);
			ch.update();
		} catch(Exception x) {
			JOptionPane.showMessageDialog(null, x);
		}
		
	}
	
}
