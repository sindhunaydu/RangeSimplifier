import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class RangeSimplifierTest {
	private List<ZipCodeRange> inputRange;
	private List<ZipCodeRange> outputRange;
	private List<ZipCodeRange> expectedRange;
	private RangeSimplifier rangeSimplifier = new RangeSimplifier();

	// helper() converts list of ranges to 2D array for Assertion
	// To ensure stability, best practices are followed -> helper() avoids
	// overriding equals() method for assertion of arraylist of objects.
	
	public int[][] helper(List<ZipCodeRange> input) {
		int[][] intArray = new int[input.size()][2];
		for (int i = 0; i < input.size(); i++) {
			intArray[i][0] = input.get(i).getLowerBound();
			intArray[i][1] = input.get(i).getUpperBound();
		}
		return intArray;
	}

	@Before
	public void initalize() {
		System.out.println("Initialize");
		expectedRange = new ArrayList<ZipCodeRange>();
		inputRange = new ArrayList<ZipCodeRange>();
		outputRange = new ArrayList<ZipCodeRange>();
	}

	@After
	public void clearObjects() {
		System.out.println("Clear");
		expectedRange.clear();
		inputRange.clear();
		outputRange.clear();
	}

	@Test
	public void emptyList() {
		outputRange = rangeSimplifier.simplify(inputRange);
		Assert.assertEquals(expectedRange, outputRange);
		System.out.println("@Test: EmptyList");
	}

	@Test
	public void oneItem() {
		int[][] expectedRange = new int[1][2];
		expectedRange[0][0] = 94133;
		expectedRange[0][1] = 94133;

		inputRange.add(new ZipCodeRange(94133, 94133));
		outputRange = rangeSimplifier.simplify(inputRange);
		// Helper converts outputRange into 2D outputArray
		int[][] outputArray = helper(outputRange);
		Assert.assertArrayEquals(expectedRange, outputArray);
		System.out.println("@Test: OneItem");
	}

	@Test
	public void validInput1() {
		int[][] expectedRange = new int[3][2];
		expectedRange[0][0] = 94133;
		expectedRange[0][1] = 94133;
		expectedRange[1][0] = 94200;
		expectedRange[1][1] = 94299;
		expectedRange[2][0] = 94600;
		expectedRange[2][1] = 94699;

		inputRange.add(new ZipCodeRange(94133, 94133));
		inputRange.add(new ZipCodeRange(94200, 94299));
		inputRange.add(new ZipCodeRange(94600, 94699));

		outputRange = rangeSimplifier.simplify(inputRange);
		// Helper converts outputRange into 2D outputArray
		int[][] outputArray = helper(outputRange);
		Assert.assertArrayEquals(expectedRange, outputArray);
		System.out.println("@Test: Valid input - Test data 1");
	}

	@Test
	public void validInput2() {
		int[][] expectedRange = new int[2][2];
		expectedRange[0][0] = 94133;
		expectedRange[0][1] = 94133;
		expectedRange[1][0] = 94200;
		expectedRange[1][1] = 94399;

		inputRange.add(new ZipCodeRange(94133, 94133));
		inputRange.add(new ZipCodeRange(94200, 94299));
		inputRange.add(new ZipCodeRange(94226, 94399));

		outputRange = rangeSimplifier.simplify(inputRange);
		// Helper converts outputRange into 2D outputArray
		int[][] outputArray = helper(outputRange);
		Assert.assertArrayEquals(expectedRange, outputArray);
		System.out.println("@Test: Valid input - Test data 2");
	}

	@Test
	public void validInput3() {
		int[][] expectedRange = new int[1][2];
		expectedRange[0][0] = 94590;
		expectedRange[0][1] = 94599;

		inputRange.add(new ZipCodeRange(94590, 94599));
		inputRange.add(new ZipCodeRange(94596, 94599));
		inputRange.add(new ZipCodeRange(94599, 94599));

		outputRange = rangeSimplifier.simplify(inputRange);
		// Helper converts outputRange into 2D outputArray
		int[][] outputArray = helper(outputRange);
		Assert.assertArrayEquals(expectedRange, outputArray);
		System.out.println("@Test: Valid input - Test data 3");
	}
}