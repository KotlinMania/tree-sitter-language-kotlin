// port-lint: tests language.rs
package io.github.kotlinmania.treesitterlanguage

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LanguageTest {
    @Test
    fun testLanguageFnFromRaw() {
        val dummyGrammar = "tree_sitter_grammar_pointer"
        val langFn = LanguageFn.fromRaw { dummyGrammar }
        assertNotNull(langFn)
        assertEquals(dummyGrammar, langFn.intoRaw())
        assertEquals(dummyGrammar, langFn())
    }

    @Test
    fun testLanguageFnFromProvider() {
        val dummyGrammar = 12345L
        val langFn = LanguageFn.fromProvider { dummyGrammar }
        assertEquals(12345L, langFn.intoRaw())
        assertEquals(12345L, langFn())
    }
}
