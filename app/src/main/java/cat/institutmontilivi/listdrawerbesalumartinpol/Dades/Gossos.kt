package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import androidx.compose.runtime.Composable
import kotlin.random.Random

data class Gos(
    val id: Int,
    val nom: String,
    val foto: String,
    val puntuacio: Int
)

class Gossos {
    companion object{
        val dades = CrearGossos()

        fun CrearGossos(): List<Gos> = (1..1000).map { i ->
            Gos(
                i,
                "Gos $i",
                "https://loremflickr.com/300/300/dog/?lock=${i + 150}",
                (1..10).random()
            )
        }
    }
}