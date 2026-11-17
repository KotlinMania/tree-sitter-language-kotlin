// port-lint: source build.rs
package io.github.kotlinmania.treesitterlanguage

/**
 * Build configuration utilities matching upstream Cargo build script.
 */
internal object Build {
    /**
     * Emits Cargo metadata for Wasm targets if the target starts with "wasm32-unknown".
     *
     * @param target the target triple
     * @param manifestDir the base directory containing the manifest
     * @return list of metadata strings
     */
    fun configure(target: String?, manifestDir: String?): List<String> {
        if (target?.startsWith("wasm32-unknown") == true && manifestDir != null) {
            val wasmHeaders = "$manifestDir/wasm/include"
            val wasmSrc = "$manifestDir/wasm/src"
            return listOf(
                "cargo::metadata=wasm-headers=$wasmHeaders",
                "cargo::metadata=wasm-src=$wasmSrc",
            )
        }
        return emptyList()
    }

    /**
     * Executes the build script logic.
     */
    fun main(target: String? = null, manifestDir: String? = null) {
        if (target.orEmpty().startsWith("wasm32-unknown")) {
            val dir = manifestDir ?: return
            val wasmHeaders = "$dir/wasm/include"
            val wasmSrc = "$dir/wasm/src"

            println("cargo::metadata=wasm-headers=$wasmHeaders")
            println("cargo::metadata=wasm-src=$wasmSrc")
        }
    }
}
