// port-lint: source language.rs
package io.github.kotlinmania.treesitterlanguage

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertSame

/**
 * Smoke tests for the [LanguageFn] / [LanguageProvider] surface. The upstream
 * Rust `tree-sitter-language` crate ships no `#[test]` or upstream `tests`
 * directory items —
 * its only consumers are grammar crates that bind `unsafe extern "C" fn()` to
 * a `LanguageFn`. The tests below pin the behavior the Kotlin downstream
 * grammar bindings (e.g. `tree-sitter-bash-kotlin`) depend on:
 *
 *  - [LanguageFn.fromRaw] does not invoke the supplied [LanguageProvider].
 *  - [LanguageFn.intoRaw] returns the same instance that was passed in.
 *  - A bare lambda SAM-converts to [LanguageProvider] without an explicit
 *    `LanguageProvider { … }` wrapper.
 *  - Re-roundtripping `fromRaw → intoRaw → fromRaw → intoRaw` preserves the
 *    underlying provider reference (i.e. `LanguageFn` is a transparent box,
 *    matching the upstream `#[repr(transparent)]`).
 */
class LanguageTest {
    @Test
    fun fromRawDoesNotInvokeProvider() {
        var invocations = 0
        val provider =
            LanguageProvider {
                invocations += 1
                0x1234L
            }
        val languageFn = LanguageFn.fromRaw(provider)
        assertNotNull(languageFn)
        assertEquals(0, invocations, "fromRaw must capture the provider without calling it")
    }

    @Test
    fun intoRawReturnsTheSameProviderInstance() {
        val provider = LanguageProvider { 0x42L }
        val languageFn = LanguageFn.fromRaw(provider)
        assertSame(provider, languageFn.intoRaw())
    }

    @Test
    fun providerCallReturnsTheConfiguredValue() {
        val languageFn = LanguageFn.fromRaw { 0xCAFEBABEL }
        assertEquals(0xCAFEBABEL, languageFn.intoRaw().call())
    }

    @Test
    fun samConversionAcceptsBareLambda() {
        val languageFn = LanguageFn.fromRaw { 7L }
        assertEquals(7L, languageFn.intoRaw().call())
    }

    @Test
    fun samConversionAcceptsFunctionReference() {
        val languageFn = LanguageFn.fromRaw(::sampleGrammarPointer)
        assertEquals(SAMPLE_GRAMMAR_POINTER, languageFn.intoRaw().call())
    }

    @Test
    fun roundTripPreservesProviderIdentity() {
        val provider = LanguageProvider { 0L }
        val once = LanguageFn.fromRaw(provider)
        val twice = LanguageFn.fromRaw(once.intoRaw())
        assertSame(provider, twice.intoRaw())
    }

    private companion object {
        const val SAMPLE_GRAMMAR_POINTER: Long = 0x0BADF00DL

        fun sampleGrammarPointer(): Long = SAMPLE_GRAMMAR_POINTER
    }
}
