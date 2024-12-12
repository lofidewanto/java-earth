package com.geo;

public class AnnotationExamples {

	@Deprecated(since = "2.0", forRemoval = true)
	public String getResult() {
		return "This result is deprecated";
	}

}
