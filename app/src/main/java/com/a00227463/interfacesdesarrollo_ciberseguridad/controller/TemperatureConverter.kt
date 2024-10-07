package com.a00227463.interfacesdesarrollo_ciberseguridad.controller

class TemperatureConverter {
    companion object {
        fun fahrenheitToCelsius(inputValue: Float): Any {
            return (inputValue - 32) * 5 / 9

        }

        fun celsiusToFahrenheit(inputValue: Float): Any {
            return (inputValue * 9 / 5) + 32
        }
    }
}