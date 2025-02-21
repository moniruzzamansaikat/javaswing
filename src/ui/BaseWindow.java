package ui;

import javax.swing.JFrame;

abstract class BaseWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1413240366994601867L;


	/** default width **/
	private int width = 500;

	
	/** default height **/
	private int height = 400;
	
	/** is resizeable or not **/
	private boolean isResizable = false;
	
	
	public BaseWindow(String title)
	{
		setTitle(title);
		setSize(this.width, this.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(isResizable);
		addComponents();
	}
	
	abstract protected void addComponents();
	
	public void setWidth(int width) 
	{
		this.width = width;
		setSize(this.width, this.height);
	}
	
	public int getWidth() 
	{
		return width;
	}
	

	public void setHeight(int height) 
	{
		this.height= height;
		setSize(this.width, this.height);
	}
	
	public int getHeight() 
	{
		return height;
	}
	
	public void setResiable(boolean yesOrNo) 
	{
		this.isResizable = yesOrNo;
		super.setResizable(yesOrNo);
	}
	
	
}
