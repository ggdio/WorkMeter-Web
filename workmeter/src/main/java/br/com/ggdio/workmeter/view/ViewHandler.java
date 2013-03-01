package br.com.ggdio.workmeter.view;

/**
 * Must be used to implement view handle actions
 * @author Guilherme Dio
 *
 */
public interface ViewHandler 
{
	/**
	 * Recover the base path of views
	 * @return base path of views
	 */
	public String getBase();
	
	/**
	 * Recover the specific view
	 * @param view - View Name, like index.jsp,home.jsp, and other...
	 * @return String - The view path
	 */
	public String getView(String view);
}
