package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlin.random.Random

data class Guerrer(
    val id: Int,
    val nom: String,
    val foto: String,
    val edat: Int,
    val forsa: Int,
    val resistencia: Int,
    val atac: Int,
    val defensa: Int
)

class Guerrers {
    companion object {
        val dades = CrearGuerrers()

        fun CrearGuerrers(): List<Guerrer> = (1..1000).map { i ->
            Guerrer(
                i,
                "Guerrer $i",
                "https://loremflickr.com/300/300/warrior/?lock=${i + 150}",
                (40..100).random(),
                (50..1000).random(),
                (100..1000).random(),
                (100..1000).random(),
                (10..1000).random()
            )
        }
    }
}


