import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		List<ZipCodeRange> zipCodeRange = new ArrayList<ZipCodeRange>();
		List<ZipCodeRange> simplifiedRange = null;
		//Test data
		zipCodeRange.add(new ZipCodeRange(94133, 94133));
		zipCodeRange.add(new ZipCodeRange(94226, 94399));
		zipCodeRange.add(new ZipCodeRange(94200, 94299));
		//Simplify zip codes
		RangeSimplifier rangeSimplifier = new RangeSimplifier();
		simplifiedRange = rangeSimplifier.simplify(zipCodeRange);
		//Display simplified ranges
		for (ZipCodeRange item : simplifiedRange) {
			System.out.println("[" + item.getLowerBound() + "," + item.getUpperBound() + "]");
		}
	}
}