package com.siregarmartin.mymovie.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.NavHostFragment
import com.siregarmartin.mymovie.R
import com.siregarmartin.mymovie.databinding.ActivityMainBinding
import com.siregarmartin.mymovie.presentation.Screen
import com.siregarmartin.mymovie.presentation.coin_detail.CoinDetailScreen
import com.siregarmartin.mymovie.presentation.coin_list.CoinListScreen
import com.siregarmartin.mymovie.presentation.ui.theme.MyMovie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : /*ComponentActivity()*/ AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*setContent {
            MyMovie {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }*/


    }
}