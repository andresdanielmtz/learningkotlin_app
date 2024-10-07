package com.a00227463.interfacesdesarrollo_ciberseguridad.controller
import kotlin.math.sqrt

class SecondGradeFormula {
    companion object {

        // TODO: Solve formulas for those with negative roots and complex numbers

        fun solveSecondGradeFormula(a:Float, b: Float, c:Float): Pair<Float, Float> {
            val yFirst = (-b + sqrt(b * b - 4 * a * c) / (2 * a))
            val ySecond = (-b - sqrt(b * b - 4 * a * c) / (2 * a))

            return Pair(yFirst, ySecond)
        }
    }
}