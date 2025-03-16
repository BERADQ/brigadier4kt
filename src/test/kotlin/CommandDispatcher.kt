import com.mojang.brigadier.CommandDispatcher
import kotlin.test.*

class CommandDispatcher {
    class CommandSourceStack

    private val source = CommandSourceStack()
    private val dispatcher = CommandDispatcher<CommandSourceStack>()

    init {
        dispatcher.register {
            literal("test") {
                argument("foo", ArgType.WORD) {
                    executes { ctx ->
                        val foo = ctx.string("foo")
                        assertEquals("bar", foo)
                        1
                    }
                }
                executes { ctx ->
                    assertEquals("test", ctx.input)
                    1
                }
            }
        }
    }

    @Test
    fun parseAndExecute() {
        run {
            val parse = dispatcher.parse("test", source)
            val result = dispatcher.execute(parse)
            assertEquals(1, result)
        }
        run {
            val parse = dispatcher.parse("test bar", source)
            val result = dispatcher.execute(parse)
            assertEquals(1, result)
        }
    }

    @Test
    fun getUsage() {
        val usages = dispatcher.getSmartUsage(dispatcher.root, source)
        for (usage in usages) {
            println(usage.value)
        }
    }
}