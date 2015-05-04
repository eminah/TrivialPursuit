package edu.chl.trivialpursuit;

import jdepend.framework.JDepend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CyclicDependenciesTest {
	private JDepend jdepend;

	@Before
	public void setUp() throws IOException {
		jdepend = new JDepend();
		jdepend.addDirectory("target/classes");
	}

	@Test
	public void testIsFreeFromCyclicDependencies() {
		jdepend.analyze();
		Assert.assertFalse(jdepend.containsCycles());
	}
}
