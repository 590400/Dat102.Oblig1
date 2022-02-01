package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTTest {

	/**
	 * Test for KoeADT.
	 * 
	 * @author referert fra Ole Olsen
	 */

	// Referanse til Koe
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny Koe for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Test p� at en ny koe er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test p� inn and ut.
	 */
	@Test
	public void innUt() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("ut feilet uventet " + e.getMessage());
		}
	}

	/**
     * Test p� st�rrelsen
     */
    @Test
    public void stor() {
        koe.innKoe(e0);
        koe.innKoe(e1);
        koe.innKoe(e2);
        assertFalse(koe.erTom());
    }
	
	/**
	 * Test p� innKoe og utKoe med duplikate verdier.
	 */
	@Test
	public void innOgUtMedDuplikater() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("ut feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test p� at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test p� at en koe med null elementer er tom.
	 */
	@Test
	public void innUtErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("inn eller ut feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing p� foerste.
	 */
	@Test
	public void innUtInnInnUtFoerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("ut eller foerste feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Fors�k p� ut av en tom Koe skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void utFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}
