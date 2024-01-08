package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.listdrawerbesalumartinpol.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaContingutGos(id: Int){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
        ){
            val gos = Gossos.dades.find{it.id == id}
            Log.d("BESALU","conté la id correcta del gos -> $id")

            if (gos != null) {
                Text("Nom: " + gos.nom, modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(gos.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Gos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .weight(4F)
                )
                Text(text = "Id del gos: " + gos.id.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(text = "Puntuació del gos: " + gos.puntuacio.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }