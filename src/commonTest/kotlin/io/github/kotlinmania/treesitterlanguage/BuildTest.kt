// port-lint: tests tree-sitter-language/build.rs
package io.github.kotlinmania.treesitterlanguage

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BuildTest {
    @Test
    fun configureWasmTarget() {
        val result = Build.configure("wasm32-unknown-emscripten", "/path/to/crate")
        assertEquals(
            listOf(
                "cargo::metadata=wasm-headers=/path/to/crate/wasm/include",
                "cargo::metadata=wasm-src=/path/to/crate/wasm/src",
            ),
            result,
        )
    }

    @Test
    fun configureNonWasmTarget() {
        val result = Build.configure("x86_64-unknown-linux-gnu", "/path/to/crate")
        assertTrue(result.isEmpty())
    }

    @Test
    fun configureNullTarget() {
        val result = Build.configure(null, "/path/to/crate")
        assertTrue(result.isEmpty())
    }

    @Test
    fun configureNullManifestDir() {
        val result = Build.configure("wasm32-unknown-emscripten", null)
        assertTrue(result.isEmpty())
    }

    @Test
    fun mainRunsWithoutError() {
        Build.main(null, null)
        Build.main("wasm32-unknown-none", "/tmp/mock")
    }
}
