import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication_compose.R


@Composable
fun NewPlayer() {
    var text1 by remember { mutableStateOf("Name") }
    var text2 by remember { mutableStateOf("Surnames") }
    var text3 by remember { mutableStateOf("NickName") }
    var text4 by remember { mutableStateOf("Phone") }
    var text5 by remember { mutableStateOf("Email") }

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

    val primaryColor = Color(0xFF007ACC)
    val backgroundWithTransparency = Color(0xCC007ACC)

    val textFieldBackgroundModifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(8.dp)
        .background(
            backgroundWithTransparency,
            shape = RoundedCornerShape(8.dp)
        )


    val screenBackgroundColor = Color.Green

    val firaSansFamily = FontFamily(
        Font(R.font.courgette, FontWeight.Light),
        Font(R.font.courgette, FontWeight.Normal),
        Font(R.font.courgette, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.courgette, FontWeight.Medium),
        Font(R.font.courgette, FontWeight.Bold)
    )

    var showError by remember { mutableStateOf(false) }

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
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    modifier = textFieldBackgroundModifier
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
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    modifier = textFieldBackgroundModifier
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
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    modifier = textFieldBackgroundModifier
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
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Change",
                        fontSize = 24.sp,
                        fontFamily = firaSansFamily,
                        color = Color.White
                    )
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
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    modifier = textFieldBackgroundModifier
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
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }
                    ),
                    modifier = textFieldBackgroundModifier
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
                    fontFamily = firaSansFamily,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}
