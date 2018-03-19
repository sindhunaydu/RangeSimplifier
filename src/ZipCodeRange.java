public class ZipCodeRange {
	private int lowerBound;
	private int upperBound;

	public ZipCodeRange(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof ZipCodeRange) {
			ZipCodeRange that = (ZipCodeRange) obj;
			result = (this.getUpperBound() == that.getUpperBound() && this.getLowerBound() == that.getLowerBound());
		}
		return result;
	}
}
