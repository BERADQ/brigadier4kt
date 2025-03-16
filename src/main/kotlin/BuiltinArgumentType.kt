import com.mojang.brigadier.arguments.*

object BuiltinArgumentType {
    val INT get() = IntegerArgumentType.integer()
    fun INT(min: Int) = IntegerArgumentType.integer(min)
    fun INT(min: Int, max: Int) = IntegerArgumentType.integer(min, max)

    val DOUBLE get() = DoubleArgumentType.doubleArg()
    fun DOUBLE(min: Double) = DoubleArgumentType.doubleArg(min)
    fun DOUBLE(min: Double, max: Double) = DoubleArgumentType.doubleArg(min, max)

    val FLOAT get() = FloatArgumentType.floatArg()
    fun FLOAT(min: Float) = FloatArgumentType.floatArg(min)
    fun FLOAT(min: Float, max: Float) = FloatArgumentType.floatArg(min, max)

    val LONG get() = LongArgumentType.longArg()
    fun LONG(min: Long) = LongArgumentType.longArg(min)
    fun LONG(min: Long, max: Long) = LongArgumentType.longArg(min, max)

    val WORD get() = StringArgumentType.word()
    val STRING get() = StringArgumentType.string()
    val GREEDY_STRING get() = StringArgumentType.greedyString()

    val BOOLEAN get() = BoolArgumentType.bool()
}

typealias ArgType = BuiltinArgumentType