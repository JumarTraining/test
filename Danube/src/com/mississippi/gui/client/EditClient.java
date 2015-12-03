package com.mississippi.gui.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class EditClient extends ClientGui{
	public EditClient(ActionListener a, int id){
		super(a);
		
		final ArrayList<String> column = new ArrayList<String>(Arrays.asList("ClientID"));
		final ArrayList<String> value = new ArrayList<String>(Arrays.asList(""+id));
		
		ResultSet Rs= db.select("Client", column, value);
		
		try {
			while(Rs.next()){
				nameBox.setText(Rs.getString(Rs.findColumn("Name")));
				adressBox.setText(Rs.getString(Rs.findColumn("Adress")));
				phoneBox.setText(Rs.getString(Rs.findColumn("Phone")));
				emailBox.setText(Rs.getString(Rs.findColumn("Email")));
				contactBox.setText(Rs.getString(Rs.findColumn("FK_StaffID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enter.removeAll();
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				ArrayList Columns=new ArrayList(Arrays.asList("Name","Adress","Phhone","Email","FK_StaffID"));
				ArrayList Values = new ArrayList(Arrays.asList(nameBox.getText(),adressBox.getText(),emailBox.getText(),contactBox.getText()));
				db.Update("Client", Columns, Values, column, value);
				
			}
			
		});
	}
}
