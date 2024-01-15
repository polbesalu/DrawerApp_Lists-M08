package cat.institutmontilivi.navigation3.ui.Pantalles

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.listdrawerbesalumartinpol.R

@Composable
fun Texte2(){
    Text(text = (stringResource(R.string.lorem_ipsum)),
        modifier = Modifier.size(300.dp)
            .fillMaxSize(1F)
            .padding(50.dp))}