package cat.institutmontilivi.navigation3.ui.Pantalles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.listdrawerbesalumartinpol.R
import cat.institutmontilivi.listdrawerbesalumartinpol.navegacio.Gossos
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlin.random.Random

@Composable
fun texte(){
    Text(text = stringResource(R.string.bon_nadal_dam2),
        modifier = Modifier.size(46.dp))}