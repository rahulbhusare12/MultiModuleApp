package feature.categoryDetails.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

@Composable
fun SecondScreen(){

}

object CategoryDetailsScreen :Screen{
    @Composable
    override fun Content() {
        Text(text = "Hello varad")
    }

}