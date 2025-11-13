package io.rndev.banksimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import io.rndev.banksimulator.nav.AppNavigation
import io.rndev.banksimulator.ui.theme.BankSimulatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankSimulatorTheme {
                AppNavigation(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


