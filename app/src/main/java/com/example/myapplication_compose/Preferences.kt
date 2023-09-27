import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.myapplication_compose.R
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

@Composable
fun Preferences() {
    var selectedOption by remember { mutableStateOf("Pajaraos enojados") }
    var sliderValue by remember { mutableStateOf(5f) }
    var score by remember { mutableStateOf(0) }
    var selectedPlatform by remember { mutableStateOf("") } // Variable para la plataforma seleccionada

    val options = listOf(
        "Pajaraos enojados",
        "Mosca Dragon",
        "Colina Escalada Carrera",
        "Futbol en tu bolsillo",
        "Defensa Irradiante",
        "Salta, ninja",
        "Controlador de aire"
    )

    val platforms = listOf("Android", "Switch", "Play", "Xbox")

    val context = LocalContext.current // Obtener el contexto actual

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Agregamos los FilterChips para las plataformas aquí
        FilterChips(
            options = platforms,
            selectedOption = selectedPlatform,
            onOptionSelected = { platform ->
                selectedPlatform = platform

                // Mostrar el Toast con la plataforma seleccionada
                Toast.makeText(context, "Plataforma seleccionada: $platform", Toast.LENGTH_LONG).show()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        options.forEach { option ->
            RadioButtonItem(
                text = option,
                isSelected = option == selectedOption
            ) {
                selectedOption = option
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Value: $sliderValue",
            fontSize = 20.sp
        )

        Slider(
            value = sliderValue,
            onValueChange = { newValue -> sliderValue = newValue },
            valueRange = 0f..10f,
            steps = 10,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            val buttonSize = 100.dp
            val iconSize = 48.dp

            IconButton(
                onClick = {
                    score = (sliderValue * 1).toInt()

                    // Mostrar el Toast
                    Toast.makeText(context, "Puntuación: $score", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .size(buttonSize)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.White, Color(0xFFFFD700)),
                            start = Offset(0f, 0f),
                            end = Offset(100f, 100f)
                        ),
                        shape = CircleShape
                    ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Puntuación: $score",
            fontSize = 20.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), // Añadimos un espacio de padding
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { option ->
            val isSelected = option == selectedOption

            FilterChip(
                selected = isSelected,
                onClick = { onOptionSelected(option) },
                label = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = option)
                        if (isSelected) {
                            Icon(
                                painter = painterResource(id = R.drawable.check), // Cambia esto por el icono que desees
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(16.dp).align(Alignment.CenterVertically)
                            )
                        }
                    }
                },
                modifier = Modifier
                    .padding(end = 8.dp)
            )
        }
    }
}

@Composable
fun RadioButtonItem(text: String, isSelected: Boolean, onSelectedChange: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        RadioButton(
            selected = isSelected,
            onClick = { onSelectedChange() },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = text, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

