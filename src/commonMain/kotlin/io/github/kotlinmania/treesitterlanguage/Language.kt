// port-lint: source language.rs
package io.github.kotlinmania.treesitterlanguage

/**
 * Adapter for the C function that returns a pointer to a tree-sitter grammar.
 *
 * Defined as a `fun interface` (single-abstract-method) so that lambda and
 * function-reference call sites — e.g. `LanguageFn.fromRaw(::treeSitterBash)` —
 * SAM-convert automatically and stay unchanged. The named nominal type also
 * keeps Kotlin function types (`() -> Long` / `Function0<Long>`) off the
 * public Swift Export bridge surface, which the plugin would otherwise
 * lower to an `Any as Function0<Long>` unchecked cast — see
 * `SWIFT_EXPORT_ROLLOUT.md` gap #8.
 */
public fun interface LanguageProvider {
    public fun call(): Long
}

/**
 * `LanguageFn` wraps a C function that returns a pointer to a tree-sitter grammar.
 */
public class LanguageFn private constructor(
    private val raw: LanguageProvider,
) {
    public companion object {
        /**
         * Creates a [LanguageFn].
         *
         * Safety: only call this with language functions generated from grammars by the
         * Tree-sitter CLI.
         */
        public fun fromRaw(f: LanguageProvider): LanguageFn = LanguageFn(f)
    }

    /**
     * Gets the function wrapped by this [LanguageFn].
     */
    public fun intoRaw(): LanguageProvider = raw
}
