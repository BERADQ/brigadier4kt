THERE IS NO LICENSE.

You can use this code however you like.

Copy and paste to your project to use.

Requires [Brigadier](https://github.com/Mojang/brigadier) ^1.0.0

```kotlin
class Example {
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
}
```