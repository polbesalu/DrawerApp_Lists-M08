package cat.institutmontilivi.listdrawerbesalumartinpol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontilivi.listdrawerbesalumartinpol.ui.Aplicacio
import cat.institutmontilivi.listdrawerbesalumartinpol.ui.PantallaDeLaAplicacio
import cat.institutmontilivi.listdrawerbesalumartinpol.ui.theme.ListDrawerBesaluMartinPolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListDrawerBesaluMartinPolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaDeLaAplicacio {
                        Aplicacio()
                    }
                }
            }
        }
    }
}
