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
     *
     * Marked `internal` because Swift Export emits an unchecked
     * `Any as Function0<Long>` cast in the generated bridge when a public
     * method returns a Kotlin function type (the
     * `<Module>_internal_functional_type_caller_*` helper). Under the
     * workspace-canonical `allWarningsAsErrors=true` that cast becomes a
     * compile error in `compileSwiftExportMainKotlin*`. See
     * `SWIFT_EXPORT_ROLLOUT.md` gap #8 for the underlying issue and the
     * internal-class workaround. Public callers invoke the wrapped function
     * via [invoke].
     */
    internal fun intoRaw(): () -> Long = raw

    /**
     * Invokes the wrapped function and returns its result.
     *
     * Equivalent to `intoRaw()()` but keeps the function type off the
     * public Swift Export bridge surface.
     */
    operator fun invoke(): Long = raw()
}
