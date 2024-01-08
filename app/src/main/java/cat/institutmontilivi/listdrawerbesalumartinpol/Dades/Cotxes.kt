package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import kotlin.random.Random

data class Cotxe(
    val id: Int,
    val nom: String,
    val foto: String,
    val velocitatMax: Int,
    val cavalls: Int,
    val kilometres: Int
)

class Cotxes {
    companion object {
        val dades = CrearCotxes()

        fun CrearCotxes(): List<Cotxe> {
            return (1..1000).map { i ->
                Cotxe(
                    i,
                    "Cotxe $i",
                    "https://loremflickr.com/300/300/car/?lock=${i + 150}",
                    (50..500).random(),
                    (1..1000).random(),
                    (1000..10000000).random()
                )
            }
        }
    }
}


