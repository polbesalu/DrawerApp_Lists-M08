package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.listdrawerbesalumartinpol.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaContingutGuerrer(id: Int){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
        ){
            val guerrer = Guerrers.dades.find{it.id == id}
            Log.d("BESALU","conté la id correcta del guerrer -> $id")

            if (guerrer != null) {
                Text(stringResource(R.string.nom_) + guerrer.nom, modifier = Modifier.align(Alignment.CenterHorizontally))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(guerrer.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.guerrer_),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .weight(4F)
                )
                Text(text = stringResource(R.string.id_del_guerrer) + guerrer.id.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.edat) +guerrer.edat.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.for_a) + guerrer.forsa.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = guerrer.forsa.toFloat()/1000, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.resist_ncia) + guerrer.resistencia.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = guerrer.resistencia.toFloat()/1000, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.atac) + guerrer.atac.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = guerrer.atac.toFloat()/1000, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.defensa) + guerrer.defensa.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = guerrer.defensa.toFloat()/1000, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }