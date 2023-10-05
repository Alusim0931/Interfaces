import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myapplication_compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPlayer() {
    var text1 by remember { mutableStateOf("Name") }
    var text2 by remember { mutableStateOf("Surnames") }
    var text3 by remember { mutableStateOf("NickName") }
    var text4 by remember { mutableStateOf("Phone") }
    var text5 by remember { mutableStateOf("Email") }

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val phoneOptions = listOf("875638098", "789765312", "086539429")

    val state = rememberScrollState()
    val modifier = Modifier.verticalScroll(state)

    val textFieldModifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(8.dp)
        .background(
            Color.LightGray,
            shape = RoundedCornerShape(8.dp)
        )

    val imageModifier = Modifier
        .size(80.dp)
        .padding(end = 32.dp)

    val screenBackgroundColor = Color.Green

    var showError by remember { mutableStateOf(false) }

    //val series = listOf("875638098", "789765312", "086539429")

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackgroundColor)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(64.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Fit
                )
                BasicTextField(
                    value = text1,
                    onValueChange = { newText -> text1 = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Acciones cuando se presiona "Done" en el teclado
                        }
                    ),
                    modifier = textFieldModifier
                )
            }
            if (showError && text1.isBlank()) {
                Text(
                    text = "*Campo Obligatorio",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = text2,
                    onValueChange = { newText -> text2 = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Acciones cuando se presiona "Done" en el teclado
                        }
                    ),
                    modifier = textFieldModifier
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = text3,
                    onValueChange = { newText -> text3 = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Acciones cuando se presiona "Done" en el teclado
                        }
                    ),
                    modifier = textFieldModifier
                )
            }
            if (showError && text3.isBlank()) {
                Text(
                    text = "*Campo Obligatorio",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Fit
                )

                OutlinedTextField(
                    value = selectedText,
                    onValueChange = {
                        selectedText = it
                    },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .fillMaxWidth()
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    phoneOptions.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                selectedText = option
                            }
                        ) {
                        }
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Fit
                )
                BasicTextField(
                    value = text4,
                    onValueChange = { newText -> text4 = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Acciones cuando se presiona "Done" en el teclado
                        }
                    ),
                    modifier = textFieldModifier
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Fit
                )
                BasicTextField(
                    value = text5,
                    onValueChange = { newText -> text5 = newText },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Acciones cuando se presiona "Done" en el teclado
                        }
                    ),
                    modifier = textFieldModifier
                )
            }

            Button(
                onClick = {
                    showError = (text1.isBlank() || text3.isBlank())
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Add New Player",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Default,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

fun DropdownMenuItem(onClick: () -> Unit, interactionSource: () -> Unit) {

}
