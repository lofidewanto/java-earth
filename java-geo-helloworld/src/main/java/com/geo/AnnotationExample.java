package com.geo;

public class AnnotationExample {

	@Deprecated(since = "2.0", forRemoval = true)
	public String getResult() {
		return "This result is deprecated";
	}

}
