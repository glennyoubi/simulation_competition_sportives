/**
 * This selection class allow you to only select the first competitor of
 * each hens in the master.
 */

package Selection;


/**
 * @author glennpeternicholasyoubidegnon
 *
 */
public class SelectionBasicOne extends SelectionBasic{
	
	
	/**
	 * This constructor create a selectionBasic .
	 * @param comp List of competitors.
	 */
	public SelectionBasicOne(){}

	/**
	 * This methods return the number of competitors
	 * that will be choose by selection method
	 */
	@Override
	public int competitorToChoosePerLeague() {
		return 1;
	}
	
	

	
	
}
