=== Deep Analysis: tmp/tree-sitter-language/src (rust) -> src/commonMain/kotlin/io/github/kotlinmania/treesitterlanguage (kotlin) ===

Scanning source codebase (rust)...
Codebase: tmp/tree-sitter-language/src (rust)
  Files: 1
  Total imports: 0

Scanning target codebase (kotlin)...
Codebase: src/commonMain/kotlin/io/github/kotlinmania/treesitterlanguage (kotlin)
  Files: 4
  Total imports: 7

Comparing codebases...
Computing AST similarities...

=== Codebase Comparison Report ===

Source: tmp/tree-sitter-language/src (1 files)
Target: src/commonMain/kotlin/io/github/kotlinmania/treesitterlanguage (4 files)
Scoring invariant: FnSim is required function body/parameter similarity. Class/type and symbol parity are reported beside it; whole-file shape is diagnostic only.

Matched:   1 files
Unmatched: 0 source, 2 target

=== Matched Files (by porting priority) ===

Source                        Target                        FnSim     Dependents FunctionParityTypeParity  Priority
 --------------------------------------------------------------------------------------------------------------------------
language                      treesitterlanguage.Language   0.25      0          2/2           1/1         307.5     

=== Function and Symbol Details ===

language -> treesitterlanguage.Language
  similarity: 0.25, priority: 307.5, dependents: 0
  functions: 2/2 matched (target total: 6, required body score: 0.25)
  missing functions: none
  types: 1/1 matched (target total: 2)
  missing types: none


=== Porting Quality Summary ===

Matched by exact header:          1 / 1
Matched by provenance fallback:   0 / 1
Matched by name:                  0 / 1
Total TODOs in target: 0
Total lint errors:    0
Stub files:           0

=== Big Picture ===

- Missing files: 0
- Incomplete ports (similarity < 60%): 1
- Stub files: 0
- Files missing functions: 0 (total deficit: 0 functions)
- Type definitions missing: 0
- Files missing tests: 0 (total deficit: 0 unported `#[test]` functions)
- Documentation coverage: 24 / 16 lines (150%)

Primary focus: improve incomplete ports (similarity < 60%)

=== Files with Issues ===

File                          Similarity LineRatio  FunctionParityTests     TODOs Lint  Status
----------------------------------------------------------------------------------------------------
treesitterlanguage.Language   0.25       0.00       2/2           -         0     0     LOW_SIM

=== Porting Recommendations ===

Incomplete ports (similarity < 60%): 1
Missing files: 0

Incomplete ports to complete:
  language                       similarity=0.25 function_parity=2/2 dependents=0

=== Documentation Gaps ===

Documentation coverage: 24 / 16 lines (150%)
Files with >20% doc gap: 0

No significant documentation gaps found.

=== Generating Reports ===

✅ Generated: port_status_report.md
✅ Generated: high_priority_ports.md
✅ Generated: NEXT_ACTIONS.md
✅ Generated: port_lint_proposed_changes.md

📁 All reports generated successfully!
