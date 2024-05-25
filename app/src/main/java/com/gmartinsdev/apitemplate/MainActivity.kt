package com.gmartinsdev.apitemplate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.gmartinsdev.apitemplate.ui.theme.ApitemplateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: MainViewModel by viewModels()

        setContent {
            ApitemplateTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    val state by vm.state.collectAsState()
                    LazyColumn(modifier = Modifier.padding(innerPadding)) {
                        lifecycleScope.launch {
                            Log.d("TESTING", "$state")
                            items(state) { data ->
                                Row(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                                    Text(data.id.toString())
                                    Text(data.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApitemplateTheme {
        Greeting("Android")
    }
}