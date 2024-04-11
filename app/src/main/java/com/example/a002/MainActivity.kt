package com.example.a002

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a002.ui.theme.A002Theme

class MainActivity : ComponentActivity() {

    companion object {
        val items: List<Item> = listOf(
            Item(
                title = "item 1",
                image = R.drawable.image1
            ),
            Item(
                title = "item 2",
                image = R.drawable.image2
            ),
            Item(
                title = "item 3",
                image = R.drawable.image3
            ),
            Item(
                title = "item 4",
                image = R.drawable.image4
            ),
            Item(
                title = "item 5",
                image = R.drawable.image1
            ),
            Item(
                title = "item 6",
                image = R.drawable.image2
            ),
            Item(
                title = "item 7",
                image = R.drawable.image3
            ),
            Item(
                title = "item 8",
                image = R.drawable.image4
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A002Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController ()

                    NavHost(
                        navController = navHostController,
                        startDestination = "home_screen"
                    ) {
//                        homescreen
                        composable("home_screen"){
                            HomeScreen(navHostController = navHostController)
                        }
//                        Row Screen
                        composable("lazy_row_screen"){
                            LazyRowScreen()
                        }
//                        Column Screen
                        composable("lazy_column_screen"){
                            LazyColumnScreen()
                        }
//                        Grid Screen
                        composable("lazy_grid_screen"){
                            LazyGridScreen()
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Button 1
        Button(onClick = { navHostController.navigate("lazy_row_screen") }) {
            Text(text = "Lazy Row")
        }
        Spacer(modifier = Modifier.height(30.dp))

        //Button 2
        Button(onClick = { navHostController.navigate("lazy_column_screen") }) {
            Text(text = "Lazy Column")
        }
        Spacer(modifier = Modifier.height(30.dp))

        //Button 3
        Button(onClick = { navHostController.navigate("lazy_grid_screen") }) {
            Text(text = "Lazy Grid")
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
    
}
