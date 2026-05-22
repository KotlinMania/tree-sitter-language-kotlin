// port-lint: source language.rs
package io.github.kotlinmania.treesitterlanguage

/**
 * `LanguageFn` wraps a C function that returns a pointer to a tree-sitter grammar.
 */
class LanguageFn private constructor(private val raw: () -> Long) {

    companion object {
        /**
         * Creates a [LanguageFn].
         *
         * Safety: only call this with language functions generated from grammars by the
         * Tree-sitter CLI.
         */
        fun fromRaw(f: () -> Long): LanguageFn = LanguageFn(f)
    }

    /**
     * Gets the function wrapped by this [LanguageFn].
     */
    fun intoRaw(): () -> Long = raw
}
