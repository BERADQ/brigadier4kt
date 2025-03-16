import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.arguments.StringArgumentType.getString
import com.mojang.brigadier.arguments.IntegerArgumentType.getInteger
import com.mojang.brigadier.arguments.BoolArgumentType.getBool
import com.mojang.brigadier.arguments.DoubleArgumentType.getDouble
import com.mojang.brigadier.arguments.FloatArgumentType.getFloat
import com.mojang.brigadier.arguments.LongArgumentType.getLong

fun <S> CommandContext<S>.string(name: String): String = getString(this, name)

fun <S> CommandContext<S>.integer(name: String): Int = getInteger(this, name)

fun <S> CommandContext<S>.boolean(name: String): Boolean = getBool(this, name)

fun <S> CommandContext<S>.double(name: String): Double = getDouble(this, name)

fun <S> CommandContext<S>.float(name: String): Float = getFloat(this, name)

fun <S> CommandContext<S>.long(name: String): Long = getLong(this, name)