package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutCotxe
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGuerrer
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeCotxes
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGossos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGuerrers

@Composable
fun GrafDeNavegacio(controladorDeNavegacio: NavHostController = rememberNavController(),
                    paddingValues: PaddingValues)
{
    NavHost(navController = controladorDeNavegacio, startDestination = CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia,
        modifier = Modifier.padding(paddingValues))
    {
        navigation(startDestination = Destinacio.LlistaGuerrers.rutaBase, route = CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia)
        {
            composable(route = Destinacio.LlistaGuerrers.rutaGenerica)
            {
                PantallaLlistaDeGuerrers(titol = "Llista de Guerreres", onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutGuerrer.CreaRutaAmbArguments(idGuerrer = id))})
            }
            composable(
                route = Destinacio.ContingutGuerrer.rutaGenerica,
                arguments = Destinacio.ContingutGuerrer.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.GuerrerContent.clau)
                requireNotNull(n)
                PantallaContingutGuerrer(id = n)
            }
        }
        navigation(startDestination = Destinacio.LlistaCotxes.rutaBase,
            route = CategoriaDeNavegacio.CategoriaCotxes.rutaPrevia)
        {
            composable(route = Destinacio.LlistaCotxes.rutaGenerica)
            {
                PantallaLlistaDeCotxes(titol = "Llista de Cotxes",
                    onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutCotxe.CreaRutaAmbArguments(idCotxe = id))})
            }
            composable(
                route = Destinacio.ContingutCotxe.rutaGenerica,
                arguments = Destinacio.ContingutCotxe.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.CotxeContent.clau)
                requireNotNull(n)
                PantallaContingutCotxe(id=n)
            }
        }
        navigation(startDestination = Destinacio.LlistaGossos.rutaBase,
            route = CategoriaDeNavegacio.CategoriaGossos.rutaPrevia)
        {
            composable(route = Destinacio.LlistaGossos.rutaGenerica)
            {
                PantallaLlistaDeGossos(titol = "Llista de Gossos",
                    onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutGos.CreaRutaAmbArguments(idGos = id))})
            }
            composable(
                route = Destinacio.ContingutGos.rutaGenerica,
                arguments = Destinacio.ContingutGos.navArgs)
            {
                val n = it.arguments?.getInt(ArgumentDeNavegacio.GossosContent.clau)
                requireNotNull(n)
                PantallaContingutGos(id=n)
            }
        }
    }
}

