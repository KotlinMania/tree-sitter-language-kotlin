import Testing
import TreeSitterLanguage

@Suite struct TreeSitterLanguageExportTests {
    @Test func testLanguageFnUsage() {
        let dummyPointer: Int64 = 0x123456789ABCDEF
        var calls = 0
        let provider = languageProvider {
            calls += 1
            return dummyPointer
        }
        let fn = LanguageFn(f: provider)
        let raw = fn.intoRaw()
        #expect(calls == 0)

        #expect((raw.getLanguage() as? Int64) == dummyPointer)
        #expect(calls == 1)
        #expect((raw.call() as? Int64) == dummyPointer)
        #expect(calls == 2)
        #expect((raw.callAsFunction() as? Int64) == dummyPointer)
        #expect(calls == 3)
        #expect((fn.callAsFunction() as? Int64) == dummyPointer)
        #expect(calls == 4)
    }

    @Test func testLanguageFnFactoriesPreserveProvider() {
        let dummyPointer: Int64 = 0x123456789ABCDEF
        var calls = 0
        let provider = languageProvider {
            calls += 1
            return dummyPointer
        }
        let fromRaw = LanguageFn.Companion.shared.fromRaw(f: provider)
        let fromProvider = LanguageFn.Companion.shared.fromProvider(provider: provider)
        #expect(calls == 0)

        #expect((fromRaw.intoRaw().call() as? Int64) == dummyPointer)
        #expect(calls == 1)
        #expect((fromRaw.callAsFunction() as? Int64) == dummyPointer)
        #expect(calls == 2)
        #expect((fromProvider.intoRaw().call() as? Int64) == dummyPointer)
        #expect(calls == 3)
        #expect((fromProvider.callAsFunction() as? Int64) == dummyPointer)
        #expect(calls == 4)
    }

    @Test func testLanguageFnPreservesNilPayload() {
        var calls = 0
        let provider = languageProvider {
            calls += 1
            return nil
        }
        let fn = LanguageFn(f: provider)
        #expect(calls == 0)

        #expect(fn.intoRaw().call() == nil)
        #expect(calls == 1)
        #expect(fn.callAsFunction() == nil)
        #expect(calls == 2)
    }
}
