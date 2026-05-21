# tree-sitter-language-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Ftree--sitter--bash--kotlin-blue.svg)](https://github.com/KotlinMania/tree-sitter-language-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/tree-sitter-language-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/tree-sitter-language-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/tree-sitter-language-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/tree-sitter-language-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`tree-sitter/tree-sitter-language`](https://github.com/tree-sitter/tree-sitter-language).

**Original Project:** This port is based on [`tree-sitter/tree-sitter-language`](https://github.com/tree-sitter/tree-sitter-language). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `tree-sitter/tree-sitter-language`

> The text below is reproduced and lightly edited from [`https://github.com/tree-sitter/tree-sitter-language`](https://github.com/tree-sitter/tree-sitter-language). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs so they continue to resolve from this repository.

## tree-sitter-language

[![CI][ci]](https://github.com/tree-sitter/tree-sitter-language/actions/workflows/ci.yml)
[![discord][discord]](https://discord.gg/w7nTvsVJhm)
[![matrix][matrix]](https://matrix.to/#/#tree-sitter-chat:matrix.org)
[![crates][crates]](https://crates.io/crates/tree-sitter-language)
[![npm][npm]](https://www.npmjs.com/package/tree-sitter-language)
[![pypi][pypi]](https://pypi.org/project/tree-sitter-language)

Bash grammar for [tree-sitter](https://github.com/tree-sitter/tree-sitter).

## Development

Install the dependencies:

```sh
npm install
```

Build and run the tests:

```sh
npm run build
npm run test
```

Run the build and tests in watch mode:

```sh
npm run test:watch
```

### References

- [Bash man page](http://man7.org/linux/man-pages/man1/bash.1.html#SHELL_GRAMMAR)
- [Shell command language specification](http://pubs.opengroup.org/onlinepubs/9699919799/utilities/V3_chap02.html)
- [mvdnan/sh - a shell parser in go](https://github.com/mvdan/sh)

[ci]: https://img.shields.io/github/actions/workflow/status/tree-sitter/tree-sitter-language/ci.yml?logo=github&label=CI
[discord]: https://img.shields.io/discord/1063097320771698699?logo=discord&label=discord
[matrix]: https://img.shields.io/matrix/tree-sitter-chat%3Amatrix.org?logo=matrix&label=matrix
[npm]: https://img.shields.io/npm/v/tree-sitter-language?logo=npm
[crates]: https://img.shields.io/crates/v/tree-sitter-language?logo=rust
[pypi]: https://img.shields.io/pypi/v/tree-sitter-language?logo=pypi&logoColor=ffd242

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:tree-sitter-language-kotlin:0.1.0")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same MIT license as the upstream [`tree-sitter/tree-sitter-language`](https://github.com/tree-sitter/tree-sitter-language). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the tree-sitter-language authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`tree-sitter/tree-sitter-language`](https://github.com/tree-sitter/tree-sitter-language) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.
