import elements.Paper
import elements.Rock
import elements.Scissors
import elements.parent.Suit
import helper.StringContainer

fun main(args: Array<String>) {
    startSuitWithCom()
}

private fun startSuitWithCom() {
    val paper = Paper("paper")
    val rock = Rock("rock")
    val scissors = Scissors("scissors")

    val resultList: List<Suit> = listOf(paper, rock, scissors)
    val compSuit = resultList.random()

    println("computer milih -> ${compSuit.name}")
    println("Input suit (rock | paper | scissors)")

    loop@ while(true){
        println("Input Pemain 1: ")
        val input = readLine()
        val mySuit = when (input) {
            "scissors" -> Scissors(StringContainer.scissors)
            "rock" -> Rock(StringContainer.rock)
            "paper" -> Paper(StringContainer.paper)
            else -> continue@loop
        }

        val result = mySuit.actionAgainst(compSuit)
        println("you is ${result.status} | you: ${mySuit.name} vs comp: ${compSuit.name}")

        println("main lagi? (ketik yes jika ingin)")
        val yes = readLine()
        if (yes == "yes") {
            startSuitWithCom()
        } else {
            break
        }
    }

}