package com.a00227463.interfacesdesarrollo_ciberseguridad.controller

class RockPaperScissors {
    companion object {
        fun play(player: String): String {
            if (player == "") {
                return "Please select a proper choice";
            }
            val computer = (0..2).random()
            val result = when (computer) {
                0 -> "rock"
                1 -> "paper"
                2 -> "scissors"
                else -> ""
        }
            if (player == result) {
                return "It's a tie!"
            }

            if (player == "rock" && result == "scissors") {
                return "You Win!"
            }
            if (player == "paper" && result == "rock") {
                return "You Win! !"
            }
            if (player == "scissors" && result == "paper") {
                return "You Win! ! !"
            }
            return "You lose"
            }
    }
}