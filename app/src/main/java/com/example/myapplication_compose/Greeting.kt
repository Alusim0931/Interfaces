import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication_compose.R
import com.example.myapplication_compose.ui.theme.MyApplication_composeTheme

@Composable
fun mainMenu(navController: NavController?) {
    val configuration = LocalConfiguration.current

    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val firaSansFamily = FontFamily(
        Font(R.font.courgette, FontWeight.Light),
        Font(R.font.courgette, FontWeight.Normal),
        Font(R.font.courgette, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.courgette, FontWeight.Medium),
        Font(R.font.courgette, FontWeight.Bold)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )

        Text(
            text = stringResource(id = R.string.PlayJuegos),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontFamily = firaSansFamily,
            modifier = Modifier
                .width(300.dp)
                .height(75.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isLandscape) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Button(
                        onClick = { navController?.navigate("Play")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.Play),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { navController?.navigate("NewPlayer")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.NewPLayer),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Button(
                        onClick = { navController?.navigate("About")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.About),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = { navController?.navigate("Preferences")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.Preferences),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        )
                    }
                }
            }
        } else {
            Button(
                onClick = { navController?.navigate("Play") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.Play),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController?.navigate("NewPlayer")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.NewPLayer),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {  navController?.navigate("About") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.About),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController?.navigate("Preferences")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.Preferences),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication_composeTheme {
        mainMenu(navController = null)
    }
}
