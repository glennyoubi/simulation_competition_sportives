/**
 * This selection class allow you to  only select the first two competitor of
 * each hens in the master.
 */

package Selection;


/**
 * @author glennpeternicholasyoubidegnon
 *
 */
public class SelectionBasicTwo extends SelectionBasic{
	
	
	/**
	 * This constructor create a selectionBasic .
	 * @param comp List of competitors.
	 */
	public SelectionBasicTwo(){}

	/**
	 * This methods return the number of competitors
	 * that will be choose by selection method
	 */
	@Override
	public int competitorToChoosePerLeague() {
		return 2;
	}
	
	

	
	
}
