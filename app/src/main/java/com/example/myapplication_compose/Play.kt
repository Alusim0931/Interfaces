import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication_compose.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Play() {
    val juegos = listOf(
        "Pajaros Enojados",
        "Mosca Dragon",
        "Colina Escalada Carrera",
        "Futbol en tu Bolsillo",
        "Defensa Irradiante",
        "Salta, ninja",
        "Controlador de aire"
    )

    val imagenes = listOf(
        R.drawable.games_angrybirds,
        R.drawable.games_dragonfly,
        R.drawable.games_hillclimbingracing,
        R.drawable.games_pocketsoccer,
        R.drawable.games_radiantdefense,
        R.drawable.games_ninjump,
        R.drawable.games_aircontrol
    )

    var selectedGames by remember { mutableStateOf(emptyList<String>()) }

    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val selectedOptions = selectedGames.joinToString(", ")
                    Toast.makeText(context, "Games: $selectedOptions", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "Done")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Aumentamos el espacio entre elementos
        ) {
            Text(
                text = "Select your games:",
                fontSize = 24.sp, // Aumentamos el tamaño del texto
                modifier = Modifier.padding(bottom = 8.dp) // Añadimos espacio inferior al texto
            )

            juegos.forEachIndexed { index, juego ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = imagenes[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(75.dp) // Aumentamos el tamaño de la imagen
                            .padding(end = 10.dp) // Añadimos espacio a la derecha de la imagen
                    )

                    Checkbox(
                        checked = juego in selectedGames,
                        onCheckedChange = { isChecked ->
                            if (isChecked) {
                                selectedGames = selectedGames + juego
                            } else {
                                selectedGames = selectedGames - juego
                            }
                        },
                        modifier = Modifier.padding(end = 16.dp) // Añadimos espacio a la derecha del checkbox
                    )

                    Text(
                        text = juego,
                        fontSize = 18.sp, // Aumentamos el tamaño del texto
                        modifier = Modifier.padding(end = 16.dp) // Añadimos espacio a la derecha del texto
                    )
                }
            }
        }
    }
}

