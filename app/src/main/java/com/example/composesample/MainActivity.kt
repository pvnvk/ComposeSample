package com.example.composesample

import android.icu.number.Scale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesample.ui.theme.ComposeSampleTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
Column() {
    Greeting(name = "Praveen")
    Greeting(name = "Dinesh")
    Greeting(name = "Francis")
}
//            ColumnSample1()
//            ColumnSample2()
//            ColumnSample3()
//            ModifierSample1()
            /*ImageCard(
                painter = painterResource(id = R.drawable.shadow_fiend),
                contentDescription = "ShadowFiend",
                text = "Shadow Fiend",
                modifier = Modifier.width(300.dp)
            )*/
//            ColoredBox() //State
//            clickToChange()
//            GreetMe()
        }
    }



}
@Preview
@Composable
private fun GreetMe() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var textFieldState by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textFieldState,
                onValueChange = {
                    textFieldState = it
                },
                label = {
                    Text(text = "Enter your name")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hi $textFieldState !")
                }
            }) {
                Text(text = "Greet Me!")

            }

        }

    }
}

@Preview
@Composable
private fun ColoredBox() {
    val color = remember {

        mutableStateOf(Color.Blue)
    }
    Box(modifier = Modifier
        .background(color.value)
        .width(300.dp)
        .height(300.dp)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        })
}

@Preview
@Composable
private fun ImageCard(
    painter: Painter = painterResource(id = R.drawable.shadow_fiend),
    contentDescription: String = "SampleImage",
    modifier: Modifier = Modifier,
    text: String = "Sample Text"
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color.Cyan,
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Cyan
                            ),
                            startY = 350f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp),
                )
            }
        }

    }
}

@Preview
@Composable
private fun ColumnSample1() {
    Column() {
        Text("First TextView")
        Text("Second TextView")
    }
}

@Preview
@Composable
private fun ColumnSample2() {
    Column() {
        for (index in 1..10) Text("TextView at index $index")
    }
}

@Preview
@Composable
private fun ColumnSample3() {
    Column(
        modifier = Modifier
            .fillMaxHeight() // set to 1 by def setting to .5 takes 50% of screen. We can also use width(200.dp) height(200.dp)
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("First TextView")
        Text("Second TextView")
        Text("Third TextView")
    }
}

@Preview
@Composable
private fun ModifierSample1() {
    Column(
        modifier = Modifier
            .fillMaxSize() // set to 1 by def setting to .5 takes 50% of screen. We can also use width(200.dp) height(200.dp)
            .background(Color.Cyan)
            .border(10.dp, Color.Red)
            .padding(20.dp)
            .border(10.dp, Color.Yellow)
            .padding(20.dp)
            .border(10.dp, Color.Black)
            .padding(10.dp)
    ) {
        Text(
            "First TextView",
            modifier = Modifier
                .offset(10.dp, 10.dp)
                .border(5.dp, Color.Green)
                .padding(15.dp)
                .clickable { }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("Second TextView")
        Text("Third TextView")
    }
}

@Composable
private fun clickToChange() {
    ComposeSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.secondary
        ) {
            val color = remember {
                mutableStateOf(Color.Green)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting("Android")
                SimpleText("Learning Compose", TextStyle.Default)
                ClickableColourBox(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Red)
                ) {
                    color.value = it
                }
                ChangingColourBox(
                    Modifier
                        .background(color = color.value)
                        .height(100.dp)
                        .fillMaxWidth()
                )


            }

        }
    }
}

@Preview
@Composable
fun SimpleText(content: String = "test", style: TextStyle? = null) {
    Text(
        text = content,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

    )
}

@Preview
@Composable
fun SimpleMaterialTextFieldComponent() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = { text = it },
        label = { Text("Label") },
        placeholder = { Text("Placeholder") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview
@Composable
fun Greeting(name: String? = "TestUser") {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        Greeting("Android")
    }
}

@Composable
fun ClickableColourBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(
        modifier = modifier
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )

            },
    )
}

@Preview
@Composable
fun ChangingColourBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    )
}

@Preview
@Composable
fun scrollingColumn() {
    val verticalScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(verticalScrollState)
            .background(Color.Cyan)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (index in 1..50) {
            Text(
                "Item $index",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 16.sp)
            )
        }

    }
}

@Preview
@Composable
fun lazyColumn() {
    val verticalScrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .verticalScroll(verticalScrollState)
            .background(Color.Cyan)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(500) {
            Text(
                "Item $it",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 16.sp)
            )
        }
        /*for (index in 1..50) {
            Text("Item $index",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 16.sp)
            )
        }*/

    }
}

@Preview
@Composable
fun lazyColumnOfItems() {
    LazyColumn {
        itemsIndexed(listOf("This", "is", "lazy", "Column")) { index, content ->
            /*Text("$content",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(fontSize = 16.sp)
            )*/
            when (content) {
                "This" -> Text(
                    "$content",
                    modifier = Modifier.padding(12.dp),
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.Red
                )
                "is" -> Text(
                    "$content",
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(fontSize = 22.sp),
                    color = Color.Magenta
                )
                "lazy" -> Text(
                    "$content",
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Green
                )
                "Column" -> Text(
                    "$content",
                    modifier = Modifier.padding(6.dp),
                    style = TextStyle(fontSize = 18.sp),
                    color = Color.Yellow
                )


            }
        }

    }
}