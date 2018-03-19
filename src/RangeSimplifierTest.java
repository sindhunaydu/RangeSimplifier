import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class RangeSimplifierTest {
	private List<ZipCodeRange> inputRange;
	private List<ZipCodeRange> outputRange;
	private List<ZipCodeRange> expectedRange;
	private RangeSimplifier rangeSimplifier = new RangeSimplifier();

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
		inputRange.add(new ZipCodeRange(94133, 94133));
		expectedRange.add(new ZipCodeRange(94133, 94133));
		outputRange = rangeSimplifier.simplify(inputRange);
		Assert.assertEquals(expectedRange, outputRange);
		System.out.println("@Test: OneItem");
	}

	@Test
	public void validInput1() {
		inputRange.add(new ZipCodeRange(94133, 94133));
		inputRange.add(new ZipCodeRange(94200, 94299));
		inputRange.add(new ZipCodeRange(94600, 94699));

		expectedRange.add(new ZipCodeRange(94133, 94133));
		expectedRange.add(new ZipCodeRange(94200, 94299));
		expectedRange.add(new ZipCodeRange(94600, 94699));

		outputRange = rangeSimplifier.simplify(inputRange);
		Assert.assertEquals(expectedRange, outputRange);
		System.out.println("@Test: Valid input - Test data 1");
	}

	@Test
	public void validInput2() {
		inputRange.add(new ZipCodeRange(94133, 94133));
		inputRange.add(new ZipCodeRange(94200, 94299));
		inputRange.add(new ZipCodeRange(94226, 94399));

		expectedRange.add(new ZipCodeRange(94133, 94133));
		expectedRange.add(new ZipCodeRange(94200, 94399));

		outputRange = rangeSimplifier.simplify(inputRange);
		Assert.assertEquals("message", expectedRange, outputRange);
		System.out.println("@Test: Valid input - Test data 2");
	}

	@Test
	public void validInput3() {
		inputRange.add(new ZipCodeRange(94590, 94599));
		inputRange.add(new ZipCodeRange(94596, 94599));
		inputRange.add(new ZipCodeRange(94599, 94599));

		expectedRange.add(new ZipCodeRange(94590, 94599));

		outputRange = rangeSimplifier.simplify(inputRange);
		Assert.assertEquals("message", expectedRange, outputRange);
		System.out.println("@Test: Valid input - Test data 3");
	}
}