package cat.institutmontilivi.listdrawerbesalumartinpol.navegacio

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cat.institutmontilivi.listdrawerbesalumartinpol.R


enum class  CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: ImageVector,
    val titol: String
){
    CategoriaGossos("CategoriaGossos", Icons.Default.Home, "CategoriaGossos"),
    CategoriaCotxes("CategoriaCotxes", Icons.Default.Call, "CategoriaCotxes"),
    CategoriaGuerrers("CategoriaGuerrers", Icons.Default.Build, "CategoriaGuerrers"),
    CategoriaExtra1("CategoriaExtra1", Icons.Default.ArrowForward, "CategoriaExtra1"),
    CategoriaExtra2("CategoriaExtra2", Icons.Default.Add, "CategoriaExtra2"),
}

sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List<ArgumentDeNavegacio> = emptyList()
)
{

    val rutaGenerica = run{
        val clausArguments = argumentsDeNavegacio.map { "{${it.clau}}" }
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")
    }
    val navArgs = argumentsDeNavegacio.map { it.toNavArgument() }

    object Principal: Destinacio(rutaBase = "Principal")
    object LlistaGossos: Destinacio(CategoriaDeNavegacio.CategoriaGossos.rutaPrevia + "/CategoriaGossos")
    object LlistaCotxes: Destinacio(CategoriaDeNavegacio.CategoriaCotxes.rutaPrevia + "/CategoriaCotxes")
    object LlistaGuerrers: Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia + "/CategoriaGuerrers")

    object Extra1: Destinacio(CategoriaDeNavegacio.CategoriaExtra1.rutaPrevia + "/CategoriaExtra1")
    object Extra2: Destinacio(CategoriaDeNavegacio.CategoriaExtra2.rutaPrevia + "/CategoriaExtra2")
    object ContingutGos:Destinacio(CategoriaDeNavegacio.CategoriaGossos.rutaPrevia + "/ContingutGossos", listOf(ArgumentDeNavegacio.GossosContent)){
        fun CreaRutaAmbArguments (idGos:Int) = "$rutaBase/$idGos"
    }
    object ContingutCotxe:Destinacio(CategoriaDeNavegacio.CategoriaCotxes.rutaPrevia + "/ContingutCotxes", listOf(ArgumentDeNavegacio.CotxeContent)){
        fun CreaRutaAmbArguments (idCotxe:Int) = "$rutaBase/$idCotxe"
    }
    object ContingutGuerrer:Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia + "/ContingutGuerrers", listOf(ArgumentDeNavegacio.GuerrerContent)){
        fun CreaRutaAmbArguments (idGuerrer:Int) = "$rutaBase/$idGuerrer"
    }
}

enum class ArgumentDeNavegacio (
    val clau: String,
    val tipus: NavType<*>
)
{
    GossosContent("GossosContent", NavType.IntType),
    CotxeContent("CotxeContent", NavType.IntType),
    GuerrerContent("GuerrerContent", NavType.IntType);

    fun toNavArgument () : NamedNavArgument{
        return navArgument(clau){type = tipus}
    }
}
