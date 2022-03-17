package com.baudoliver7.fr;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

public class FrIntegerInLettersTest {

	@Test
	public void convertsUnits() {
		MatcherAssert.assertThat(
			new FrIntegerInLetters(1L).toString(),
			new IsEqual<>("Un")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(2L).toString(),
			new IsEqual<>("Deux")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(3L).toString(),
			new IsEqual<>("Trois")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(4L).toString(),
			new IsEqual<>("Quatre")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(5L).toString(),
			new IsEqual<>("Cinq")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(6L).toString(),
			new IsEqual<>("Six")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(7L).toString(),
			new IsEqual<>("Sept")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(8L).toString(),
			new IsEqual<>("Huit")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(9L).toString(),
			new IsEqual<>("Neuf")
		);
	}
	
	@Test
	public void convertsDix() {
		MatcherAssert.assertThat(
			new FrIntegerInLetters(10L).toString(),
			new IsEqual<>("Dix")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(11L).toString(),
			new IsEqual<>("Onze")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(12L).toString(),
			new IsEqual<>("Douze")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(13L).toString(),
			new IsEqual<>("Treize")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(14L).toString(),
			new IsEqual<>("Quatorze")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(15L).toString(),
			new IsEqual<>("Quinze")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(16L).toString(),
			new IsEqual<>("Seize")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(17L).toString(),
			new IsEqual<>("Dix-sept")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(18L).toString(),
			new IsEqual<>("Dix-huit")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(19L).toString(),
			new IsEqual<>("Dix-neuf")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(20L).toString(),
			new IsEqual<>("Vingt")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(30L).toString(),
			new IsEqual<>("Trente")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(40L).toString(),
			new IsEqual<>("Quarante")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(50L).toString(),
			new IsEqual<>("Cinquante")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(60L).toString(),
			new IsEqual<>("Soixante")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(70L).toString(),
			new IsEqual<>("Soixante-Dix")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(80L).toString(),
			new IsEqual<>("Quatre-vingt")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(90L).toString(),
			new IsEqual<>("Quatre-vingt-Dix")
		);
	}

	@Test
	public void convertsCents() {
		MatcherAssert.assertThat(
			new FrIntegerInLetters(100L).toString(),
			new IsEqual<>("Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(200L).toString(),
			new IsEqual<>("Deux Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(300L).toString(),
			new IsEqual<>("Trois Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(400L).toString(),
			new IsEqual<>("Quatre Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(500L).toString(),
			new IsEqual<>("Cinq Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(600L).toString(),
			new IsEqual<>("Six Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(700L).toString(),
			new IsEqual<>("Sept Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(800L).toString(),
			new IsEqual<>("Huit Cent")
		);
		MatcherAssert.assertThat(
			new FrIntegerInLetters(900L).toString(),
			new IsEqual<>("Neuf Cent")
		);
	}

	@Test
	public void convertsFullNumber() {
		MatcherAssert.assertThat(
			new FrIntegerInLetters(146_987L).toString(),
			new IsEqual<>("Cent Quarante Six Mille Neuf Cent Quatre-vingt Sept")
		);
	}
}
