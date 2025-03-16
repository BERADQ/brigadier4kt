import com.mojang.brigadier.arguments.ArgumentType
import com.mojang.brigadier.builder.ArgumentBuilder
import com.mojang.brigadier.builder.RequiredArgumentBuilder

inline fun <S, T, E : ArgumentBuilder<S, E>?> ArgumentBuilder<S, E>.argument(
    name: String,
    type: ArgumentType<T>,
    body: RequiredArgumentBuilder<S, T>.() -> Unit
) {
    val builder = RequiredArgumentBuilder.argument<S, T>(name, type)
    body(builder)
    this.then(builder)
}