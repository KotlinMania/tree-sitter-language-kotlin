// port-lint: source build.rs
package io.github.kotlinmania.treesitterlanguage

/**
 * Tracking ledger for the upstream Cargo build script. The Rust crate's
 * `build.rs` runs only when the active Cargo `TARGET` triple starts with
 * `wasm32-unknown`; in that case it emits two cargo metadata keys
 * (`wasm-headers` and `wasm-src`) that downstream Tree-sitter grammar
 * crates pick up via `DEP_TREE_SITTER_LANGUAGE_*` environment variables to
 * locate the bundled `wasm/include` and `wasm/src` directories of this
 * crate.
 *
 * Kotlin Multiplatform has no per-source build script of its own. The
 * `tree-sitter-language` crate ships no `wasm/` directory in this
 * repository (the upstream Cargo source tree carries it only for downstream
 * grammar consumers that compile a `tree-sitter.wasm` artifact). The
 * Kotlin port surfaces only the `LanguageFn` trampoline declared in
 * `language.rs`; grammar artifact wiring lives in each per-grammar
 * `tree-sitter-<grammar>-kotlin` repo's Gradle build, not here.
 *
 * This file exists so `ast_distance` can match upstream `build.rs` to a
 * commonMain Kotlin file with the `port-lint: source build.rs` header;
 * its body is documentation only because the translation target is the
 * downstream Gradle build, not Kotlin source in this crate.
 */
internal object Build
