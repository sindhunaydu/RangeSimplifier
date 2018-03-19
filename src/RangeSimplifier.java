import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RangeSimplifier {
	//Method to simplify list of zip codes in O(n log n) time and O(n) space complexity. 
	public List<ZipCodeRange> simplify(List<ZipCodeRange> zipCode) {
		//If the input list is empty, return empty list
		if(zipCode.equals(null) || zipCode.size() == 0)
			return new ArrayList<ZipCodeRange>();
		//Sort the list of zip codes based on lower bound
		sortByLowerBound(zipCode);
		//simplifiedRange contains result after simplification
		List<ZipCodeRange> simplifiedRange = new ArrayList<ZipCodeRange>();
		//Initialize with the lowest zip code
		simplifiedRange.add(zipCode.get(0));
		for (ZipCodeRange current : zipCode) {
			//Check for overlaps. If there is an overlap, use the highest upper bound
			if (current.getLowerBound() <= simplifiedRange.get(simplifiedRange.size() - 1).getUpperBound()) {
				simplifiedRange.get(simplifiedRange.size() - 1).setUpperBound(
						Math.max(simplifiedRange.get(simplifiedRange.size() - 1).getUpperBound(), current.getUpperBound()));
			} else {
				//If there is no overlap, keep the current zip code
				simplifiedRange.add(current);
			}
		}
		return simplifiedRange;
	}
	
	//Sort list of zip codes by lower bound
	private void sortByLowerBound(List<ZipCodeRange> zipCode) {
		Collections.sort(zipCode, new Comparator<ZipCodeRange>() {
			@Override
			public int compare(ZipCodeRange left, ZipCodeRange right) {
				return left.getLowerBound() - right.getLowerBound();
			}
		});
	}
}
