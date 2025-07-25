package org.app.glimpse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.yandex.mapkit.MapKitFactory
import org.app.glimpse.data.ApiViewModel
import org.app.glimpse.pressentation.theme.GlimpseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val apiViewModel: ApiViewModel = viewModel()
            val navController = rememberNavController()
            GlimpseTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ){ paddingValues ->
                    Navigation(
                        navController = navController,
                        padding = paddingValues,
                        apiViewModel = apiViewModel
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}