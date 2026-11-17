package com.example.artspace

import org.junit.Assert.assertEquals
import org.junit.Test

/** Проверка циклического перелистывания работ. */
class NavigationTest {
    @Test
    fun next_fromLast_goesToFirst() = assertEquals(0, nextIndex(3, 4))

    @Test
    fun previous_fromFirst_goesToLast() = assertEquals(3, previousIndex(0, 4))

    @Test
    fun next_inMiddle_increments() = assertEquals(2, nextIndex(1, 4))
}
