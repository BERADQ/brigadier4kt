import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.builder.LiteralArgumentBuilder.literal

class CommandBuilder<S>(val dispatcher: CommandDispatcher<S>) {
    inline fun literal(literal: String, body: LiteralArgumentBuilder<S>.() -> Unit) {
        val literalBuilder = literal<S>(literal)
        body(literalBuilder)
        dispatcher.register(literalBuilder)
    }
}

inline fun <S> CommandDispatcher<S>.register(builder: CommandBuilder<S>.() -> Unit) {
    builder(CommandBuilder(this))
}