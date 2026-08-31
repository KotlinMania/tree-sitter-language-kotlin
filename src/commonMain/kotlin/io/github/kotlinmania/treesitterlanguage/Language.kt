// port-lint: source tree-sitter-language/src/language.rs
package io.github.kotlinmania.treesitterlanguage

import kotlin.jvm.JvmInline

/**
 * Functional interface wrapping a native C function or language provider that returns a pointer to a Tree-sitter grammar.
 */
public fun interface LanguageProvider {
    /**
     * Returns the raw language grammar handle or pointer.
     */
    public fun getLanguage(): Any?
}

/**
 * `LanguageFn` wraps a C function that returns a pointer to a tree-sitter grammar.
 */
@JvmInline
public value class LanguageFn(
    public val f: LanguageProvider,
) {
    /**
     * Gets the function wrapped by this [`LanguageFn`].
     */
    public fun intoRaw(): Any? = f.getLanguage()

    /**
     * Invokes the language function.
     */
    public operator fun invoke(): Any? = intoRaw()

    public companion object {
        /**
         * Creates a [`LanguageFn`].
         *
         * # Safety
         *
         * Only call this with language functions generated from grammars
         * by the Tree-sitter CLI.
         */
        public fun fromRaw(f: LanguageProvider): LanguageFn = LanguageFn(f)

        /**
         * Creates a [LanguageFn] from a [LanguageProvider].
         */
        public fun fromProvider(provider: LanguageProvider): LanguageFn = LanguageFn(provider)
    }
}
