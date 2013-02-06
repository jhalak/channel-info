package db;

import javax.swing.JOptionPane;

public class Chennel {
	private Integer id;
	private String name;
	private String number;
	
	public Chennel(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void update() {
		try{
			DbHandler.getQueryStatement().execute(
					" UPDATE chennels " +
					" SET name = '" + getName() + "', number = " + getNumber() +
					" WHERE id = " + getId()
			);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
