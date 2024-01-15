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
fun PantallaContingutCotxe(id: Int){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
        ){
            val cotxe = Cotxes.dades.find{it.id == id}
            Log.d("BESALU","conté la id correcta del cotxe -> $id")

            if (cotxe != null) {
                Text(cotxe.nom, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(7.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(cotxe.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.guerrer),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                        .weight(4F)
                )
                Text(text = stringResource(R.string.id_cotxe) + cotxe.id.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.velocitat_m_x) + cotxe.velocitatMax.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = cotxe.velocitatMax.toFloat()/500, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.cavalls_de_pot_ncia) + cotxe.cavalls.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
                LinearProgressIndicator(progress = cotxe.cavalls.toFloat()/1000, modifier = Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = stringResource(R.string.kilometratge) + cotxe.kilometres.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }